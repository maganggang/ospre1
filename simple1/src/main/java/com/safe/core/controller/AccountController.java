package com.safe.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.safe.core.beans.Account;
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
	public List<Account> allAccount(){
		return accountService.selectAll();
	}
	@RequestMapping("/user/{id}")
	@ResponseBody
	public Account oneAccount(@PathVariable Integer id){
		return accountService.selectByPremaryKey(id);
	}
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Boolean deleteAccount(@PathVariable Integer id){
		return accountService.deleteAccount(id);
	}
	@RequestMapping("/update")
	@ResponseBody
	public Account updateAccount(Account account){
		
		return accountService.updateAccountl(account);
	}
}
