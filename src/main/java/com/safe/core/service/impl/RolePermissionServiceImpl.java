package com.safe.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safe.core.beans.RolePermission;
import com.safe.core.mapper.RolePermissionMapper;
import com.safe.core.service.RolePermissionService;
@Service
public class RolePermissionServiceImpl implements RolePermissionService{
	@Autowired
private RolePermissionMapper rolePermissionMapper;
	public List<RolePermission> selectAll() {
		return null;
	}

	public RolePermission selectByPrimaryKey(Integer id) {
		return null;
	}

	public Boolean deleteByPrimaryKey(Integer id) {
		int i=0;
		if(i>0){
			return true;
		}
		return false;
	}

	public RolePermission update(RolePermission rolePermission) {
	int i=0;
		if(i>0){
			return rolePermission;
		}
		return null;
	}

	public RolePermission insert(RolePermission rolePermission) {
		int i=rolePermissionMapper.insertSelective(rolePermission);
		if(i>0){
			return rolePermission;
		}
		return null;
	}


}
