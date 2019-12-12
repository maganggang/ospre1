package com.safe.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.safe.core.beans.Permission;
import com.safe.core.service.PermissionService;

@Controller
@RequestMapping("/permission")
public class PermissionController {
	@Autowired
	private PermissionService permissionService;
	@RequestMapping("/all")
	@ResponseBody
	public List<Permission> allPermission(){
		return permissionService.selectAll();
	}
	@RequestMapping("/permission/{id}")
	@ResponseBody
	public Permission findOne(@PathVariable Integer id){
		return permissionService.selectByPrimaryKey(id);
	}
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Boolean deleteOne(@PathVariable Integer id){
		return permissionService.deleteByPrimaryKey(id);
	}
	@RequestMapping("/update")
	@ResponseBody
	public Permission updateOne(Permission permission){
		return permissionService.update(permission);
	}
	@RequestMapping("/insert")
	@ResponseBody
	public Permission createOne(Permission permission){
		return permissionService.insert(permission);
	}
}
