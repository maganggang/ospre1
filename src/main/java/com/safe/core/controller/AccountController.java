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
		 //���÷�ҳ������Parameters:pageNum ҳ��pageSize ÿҳ��ʾ����count �Ƿ����count��ѯ
		page=PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
		List<Account>  result=accountService.selectAll();
	    //ʹ��PageInfo��װ��ѯ�����ֻ��Ҫ��pageInfo����ҳ��Ϳ���
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
	 * ��¼��֤ �����¼
	* @Title: login 
	* @param username
	* @param password
	* @return
	* @return: String 
	* @author mgg
	* @date 2019��12��12��
	 */
	@RequestMapping("/login")
	@ResponseBody
	public String login(HttpServletRequest req, String username,String password,String vcode){
		 HttpSession session = req.getSession();
			//ת����Сд��ĸ
			vcode = vcode.toLowerCase();
			String v = (String)session.getAttribute("_code");//�����Զ�ȡһ�κ����֤����գ�����ÿ�ε�¼�������ȡ��֤��;
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
	 * �˳��������session
	* @Title: loginOut 
	* @param req
	* @return
	* @return: String 
	* @author mgg
	* @date 2020��1��7��
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public String loginOut(HttpServletRequest req){
		HttpSession session=req.getSession();
		String userid=session.getAttribute("username").toString();
		HttpSession userSession=(HttpSession)SessionListener.sessionContext.getSessionMap().get(userid);
		//ע�������û�
		if(userSession!=null){
			userSession.invalidate();			
		}else{
			session.removeAttribute("accountId");
			session.removeAttribute("username");
			session.invalidate();
		}
		SessionListener.sessionContext.getSessionMap().remove(userid);
		//��������û��󣬸���map,�滻map sessionid
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
	 * ��ȡ��֤�루Gif�汾��
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
	         * gif��ʽ������֤��
	         * �����ߣ�λ����
	         */
	        Captcha captcha = new GifCaptcha(146,33,4);
	        //���
	        captcha.out(response.getOutputStream());
	        HttpSession session = request.getSession(true);  
	        //����Session
	        session.setAttribute("_code",captcha.text().toLowerCase());  
	    } catch (Exception e) {
	    	e.printStackTrace();
	        System.err.println("��ȡ��֤���쳣��"+e.getMessage());
	    }
	}
}