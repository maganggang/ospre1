package com.safe.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safe.core.beans.Role;
import com.safe.core.mapper.RoleMapper;
import com.safe.core.service.RoleService;
@Service
public class RoleServiceImpl implements  RoleService{
	@Autowired
private RoleMapper roleMapper;
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


}
