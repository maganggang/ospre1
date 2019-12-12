package com.safe.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.safe.core.beans.User;
import com.safe.core.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/all")
	@ResponseBody
	public List<User> allUser(){
		return userService.selectAll();
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
