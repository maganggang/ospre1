package com.safe.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.safe.core.beans.Organization;
import com.safe.core.beans.Permission;
import com.safe.core.beans.User;
import com.safe.core.mapper.OrganizationMapper;
import com.safe.core.mapper.PermissionMapper;
import com.safe.core.service.PermissionService;
import com.safe.core.service.UserService;
@Service
public class PermissionServiceImpl implements PermissionService{
	@Autowired
private PermissionMapper permissionMapper;
	
	public List<Permission> selectAll() {
		return permissionMapper.findAll();
	}

	public Permission selectByPrimaryKey(Integer id) {
		return permissionMapper.selectByPrimaryKey(id);
	}

	public Boolean deleteByPrimaryKey(Integer id) {
		int i=permissionMapper.deleteByPrimaryKey(id);
		if(i>0){
			return true;
		}
		return false;
	}

	public Permission update(Permission permission) {
		int i=permissionMapper.updateByPrimaryKeySelective(permission);
		if(i>0){
			return permission;
		}
		return null;
	}

	public Permission insert(Permission permission) {
		int i=permissionMapper.insertSelectiveReturnKey(permission);
		if(i>0){
			return permission;
		}
		return null;
	}

}
