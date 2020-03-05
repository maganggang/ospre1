package com.safe.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safe.core.beans.Organization;
import com.safe.core.mapper.OrganizationMapper;
import com.safe.core.service.OrganizationService;
@Service
public class OrganizationServiceImpl implements OrganizationService{
	@Autowired
private OrganizationMapper organizationMapper;
	
	public List<Organization> selectAll() {
		return organizationMapper.findAll();
	}

	public Organization selectByPrimaryKey(Integer id) {
		return organizationMapper.selectByPrimaryKey(id);
	}

	public Boolean deleteByPrimaryKey(Integer id) {
		int i=organizationMapper.deleteByPrimaryKey(id);
		if(i>0){
			return true;
		}
		return false;
	}

	public Organization update(Organization org) {
		int i=organizationMapper.updateByPrimaryKeySelective(org);
		if(i>0){
			return org;
		}
		return null;
	}

	public Organization insert(Organization org) {
		int i=organizationMapper.insertSelectiveReturnKey(org);
		if(i>0){
			return org;
		}
		return null;
	}

}
