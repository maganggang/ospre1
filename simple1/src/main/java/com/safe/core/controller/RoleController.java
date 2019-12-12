package com.safe.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.safe.core.beans.Role;
import com.safe.core.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService roleService;
	@RequestMapping("/all")
	@ResponseBody
	public List<Role> allRole(){
		return roleService.selectAll();
	}
	@RequestMapping("/role/{id}")
	@ResponseBody
	public Role findOne(@PathVariable Integer id){
		return roleService.selectByPrimaryKey(id);
	}
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Boolean deleteOne(@PathVariable Integer id){
		return roleService.deleteByPrimaryKey(id);
	}
	@RequestMapping("/update")
	@ResponseBody
	public Role updateOne(Role role){
		return roleService.update(role);
	}
	@RequestMapping("/insert")
	@ResponseBody
	public Role createOne(Role role){
		return roleService.insert(role);
	}
	
}
