package com.safe.core.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safe.core.beans.AuthorityRoleRef;
import com.safe.core.beans.Module;
import com.safe.core.beans.Permission;
import com.safe.core.beans.Role;
import com.safe.core.mapper.AuthorityRoleRefMapper;
import com.safe.core.mapper.RoleMapper;
import com.safe.core.service.RoleService;
@Service
public class RoleServiceImpl implements  RoleService{
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private AuthorityRoleRefMapper authorityRoleRefMapper;
	public List<Role> selectAll() {
		return roleMapper.findAll();
	}

	public Role selectByPrimaryKey(Integer id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	public Boolean deleteByPrimaryKey(Integer id) {
		int i=roleMapper.deleteByPrimaryKey(id);
		if(i>0){
			return true;
		}
		return false;
	}

	public Role update(Role role) {
	int i=roleMapper.updateByPrimaryKeySelective(role);
		if(i>0){
			return role;
		}
		return null;
	}

	public Role insert(Role role) {
		int i=roleMapper.insertSelectiveReturnKey(role);
		if(i>0){
			return role;
		}
		return null;
	}

	@Override
	public Role addRole(Role role) {
		int i=roleMapper.insertSelectiveReturnKey(role);
		int j= authorityRoleRefMapper.insertBatch(role.getId(),role.getAuthorityIds());
		if(i>0){
			return role;
		}
		return null;
	}


}
