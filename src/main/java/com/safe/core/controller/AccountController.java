package com.safe.core.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.safe.core.beans.Account;
import com.safe.core.beans.ResultBean;
import com.safe.core.beans.User;
import com.safe.core.filter.SessionListener;
import com.safe.core.service.AccountService;
import com.safe.core.service.UserService;
import com.safe.core.utils.BaseUserInfo;
import com.safe.core.utils.Captcha;
import com.safe.core.utils.GifCaptcha;
import com.safe.core.utils.SessionContext;
import com.safe.core.utils.SessionUtils;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseUserInfo{
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserService UserService;
	@RequestMapping("/hello")
	@ResponseBody
 public String hello(){
	 return "hello";
 }
	@RequestMapping("/all")
	@ResponseBody
	public ResultBean<Account> allAccount(Page<Account> page,Account account){
		ResultBean<Account> b=new ResultBean<Account>();
		 //设置分页条件，Parameters:pageNum 页码pageSize 每页显示数量count 是否进行count查询
		page=PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
		List<Account>  result=accountService.selectAll();
	    //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
		b.setData(result);
	    b.setCount(page.getTotal());
		return b;
	}
/*	@RequestMapping("/org/all")
	@ResponseBody
	public ResultBean<Account> allOrgAccount(){
		ResultBean<Account> b=new ResultBean<Account>();
		List<Account>  result=accountService.selectAll();
		b.setData(result);
		return b;
	}*/
	@RequestMapping("/user/{id}")
	@ResponseBody
	public Account oneAccount(@PathVariable Integer id){
		return accountService.selectByPrimaryKey(id);
	}
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Boolean deleteAccount(@PathVariable Integer id){
		return accountService.deleteAccount(id);
	}
	@RequestMapping("/update")
	@ResponseBody
	public Account updateAccount(Account account){
		return accountService.updateAccount(account);
	}
	@RequestMapping("/insert")
	@ResponseBody
	public Account createAccount(Account account){
		return accountService.insertAccount(account);
	}
	/**
	 * 登录验证 单点登录
	* @Title: login 
	* @param username
	* @param password
	* @return
	* @return: String 
	* @author mgg
	* @date 2019年12月12日
	 */
	@RequestMapping("/login")
	@ResponseBody
	public String login(HttpServletRequest req, String username,String password,String vcode){
		 HttpSession session = req.getSession();
			//转化成小写字母
			vcode = vcode.toLowerCase();
			String v = (String)session.getAttribute("_code");//还可以读取一次后把验证码清空，这样每次登录都必须获取验证码;
			System.out.println(vcode+":"+v);
		Account ok=accountService.login(username,password);
		this.setAccountId(ok.getId());
		Integer aInteger=this.getAccountId();
		if(ok!=null){
			req.getSession().setAttribute("username",username);
			req.getSession().setAttribute("accountId",ok.getId());
			if(ok.getUserId()!=null){
				User user=UserService.selectUserInfo(ok.getUserId());
				if(user!=null&&user.getPost()!=null){
					this.setUserId(user.getId());
					req.getSession().setAttribute("postId", user.getPost().getId());
					req.getSession().setAttribute("postName", user.getPost().getName());
					this.setPostId(user.getPost().getId());
					if(user.getPost().getOrganization()!=null){
						req.getSession().setAttribute("orgId",user.getPost().getOrganization().getId());
						req.getSession().setAttribute("orgName", user.getPost().getOrganization().getName());
						this.setOrgId(user.getPost().getOrganization().getId());
					}
				}
			}
			SessionUtils.sessionHandlerByCacheMap(req.getSession());
			return "ok";
		}
		return null;
	}
	/**
	 * 退出清除缓存session
	* @Title: loginOut 
	* @param req
	* @return
	* @return: String 
	* @author mgg
	* @date 2020年1月7日
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public String loginOut(HttpServletRequest req){
		HttpSession session=req.getSession();
		String userid=session.getAttribute("username").toString();
		HttpSession userSession=(HttpSession)SessionListener.sessionContext.getSessionMap().get(userid);
		//注销在线用户
		if(userSession!=null){
			userSession.invalidate();			
		}else{
			session.removeAttribute("accountId");
			session.removeAttribute("username");
			session.invalidate();
		}
		SessionListener.sessionContext.getSessionMap().remove(userid);
		//清除在线用户后，更新map,替换map sessionid
		SessionListener.sessionContext.getSessionMap().remove(session.getId());	
		return "ok";
	}
	@RequestMapping("/myInfo")
	@ResponseBody
	public Account myInfo(){
		Integer accountId=this.getAccountId();
		if(accountId!=null){
			Account account=accountService.selectByPrimaryKey(accountId);
			return account;
		}else{
			return null;
		}
	}
	/**
	 * 获取验证码（Gif版本）
	 * @param response
	 */
	@RequestMapping(value="getGifCode",method=RequestMethod.GET)
	public void getGifCode(HttpServletResponse response,HttpServletRequest request){
	    try {
	        response.setHeader("Pragma", "No-cache");  
	        response.setHeader("Cache-Control", "no-cache");  
	        response.setDateHeader("Expires", 0);  
	        response.setContentType("image/gif");  
	        /**
	         * gif格式动画验证码
	         * 宽，高，位数。
	         */
	        Captcha captcha = new GifCaptcha(146,33,4);
	        //输出
	        captcha.out(response.getOutputStream());
	        HttpSession session = request.getSession(true);  
	        //存入Session
	        session.setAttribute("_code",captcha.text().toLowerCase());  
	    } catch (Exception e) {
	    	e.printStackTrace();
	        System.err.println("获取验证码异常："+e.getMessage());
	    }
	}
}
