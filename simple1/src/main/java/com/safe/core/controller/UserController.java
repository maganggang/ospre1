package com.safe.core.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.safe.core.beans.Account;
import com.safe.core.beans.ResultBean;
import com.safe.core.beans.User;
import com.safe.core.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/all")
	@ResponseBody
	public ResultBean<User> allUser(){
		ResultBean<User> b=new ResultBean<User>();
		List<User>  result=userService.selectAll();
		b.setData(result);
		return b;
	}
	@RequestMapping("/org/all")
	@ResponseBody
	public ResultBean<User> allOrgUser(HttpSession httpSession){
		ResultBean<User> b=new ResultBean<User>();
		if(httpSession.getAttribute("orgId")!=null){
			String orgId=httpSession.getAttribute("orgId").toString();
			List<User>  result=userService.findAllByOrg(Integer.parseInt(orgId));
			b.setData(result);
		}else{
			b.setMsg("非组织人员或登录过期！");
		}
		return b;
	}
	@RequestMapping("/user/{id}")
	@ResponseBody
	public User findOne(@PathVariable Integer id){
		return userService.selectByPrimaryKey(id);
	}
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Boolean deleteOne(@PathVariable Integer id){
		return userService.deleteByPrimaryKey(id);
	}
	@RequestMapping("/update")
	@ResponseBody
	public User updateOne(User user){
		return userService.update(user);
	}
	@RequestMapping("/insert")
	@ResponseBody
	public User createOne(User user){
		return userService.insert(user);
	}
}
