package com.safe.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.safe.core.beans.RolePermission;
import com.safe.core.service.RolePermissionService;

@Controller
@RequestMapping("/rolePermission")
public class RolePermissionController {
	@Autowired
	private RolePermissionService rolePermissionService;
	@RequestMapping("/all")
	@ResponseBody
	public List<RolePermission>  allRolePer(){
		return rolePermissionService.selectAll();
	}
	@RequestMapping("/rolePer/{id}")
	@ResponseBody
	public RolePermission findOne(@PathVariable Integer id){
		return rolePermissionService.selectByPrimaryKey(id);
	}
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Boolean deleteOne(@PathVariable Integer id){
		return rolePermissionService.deleteByPrimaryKey(id);
	}
	@RequestMapping("/update")
	@ResponseBody
	public RolePermission updateOne(RolePermission rolePermission){
		return rolePermissionService.update(rolePermission);
	}
	@RequestMapping("/insert")
	@ResponseBody
	public RolePermission createOne(RolePermission rolePermission){
		return rolePermissionService.insert(rolePermission);
	}
}
