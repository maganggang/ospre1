package com.safe.core.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.safe.core.beans.Account;
import com.safe.core.beans.ResultBean;
import com.safe.core.beans.User;
import com.safe.core.filter.SessionListener;
import com.safe.core.service.AccountService;
import com.safe.core.service.UserService;
import com.safe.core.utils.SessionContext;
import com.safe.core.utils.SessionUtils;

@Controller
@RequestMapping("/account")
public class AccountController {
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
	public ResultBean<Account> allAccount(){
		ResultBean<Account> b=new ResultBean<Account>();
		List<Account>  result=accountService.selectAll();
		b.setData(result);
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
	public String login(HttpServletRequest req, String username,String password){
		Account ok=accountService.login(username,password);
		if(ok!=null){
			req.getSession().setAttribute("username",username);
			req.getSession().setAttribute("accountId",ok.getId());
			if(ok.getUserId()!=null){
				User user=UserService.selectUserInfo(ok.getUserId());
				if(user!=null&&user.getPost()!=null){
					req.getSession().setAttribute("postId", user.getPost().getId());
					req.getSession().setAttribute("postName", user.getPost().getName());
					if(user.getPost().getOrganization()!=null){
						req.getSession().setAttribute("orgId",user.getPost().getOrganization().getId());
						req.getSession().setAttribute("orgName", user.getPost().getOrganization().getName());
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
		}
		SessionListener.sessionContext.getSessionMap().remove(userid);
		//清除在线用户后，更新map,替换map sessionid
		SessionListener.sessionContext.getSessionMap().remove(session.getId());	
		session.removeAttribute("accountId");
		session.removeAttribute("username");
		session.invalidate();
		return "ok";
	}
	
}
