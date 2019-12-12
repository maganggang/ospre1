package com.safe.core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.safe.core.beans.Account;
import com.safe.core.beans.ResultBean;
import com.safe.core.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private AccountService accountService;
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
	 * 登录验证
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
			return "ok";
		}
		return null;
	}
}
