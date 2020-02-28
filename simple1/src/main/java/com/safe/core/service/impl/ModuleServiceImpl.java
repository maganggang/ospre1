package com.safe.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safe.core.beans.Module;
import com.safe.core.mapper.ModuleMapper;
import com.safe.core.service.ModuleService;
@Service
public class ModuleServiceImpl implements ModuleService{
	@Autowired
private ModuleMapper moduleMapper;
	
	public List<Module> selectAll(Module module) {
		return moduleMapper.findAll(module);
	}

	public Module selectByPrimaryKey(Integer id) {
		return moduleMapper.selectByPrimaryKey(id);
	}

	public Boolean deleteByPrimaryKey(Integer id) {
		int i=moduleMapper.deleteByPrimaryKey(id);
		if(i>0){
			return true;
		}
		return false;
	}

	public Module update(Module module) {
		int i=moduleMapper.updateByPrimaryKey(module);
		if(i>0){
			return module;
		}
		return null;
	}

	public Module insert(Module module) {
	int i=moduleMapper.insertSelectiveReturnKey(module);
	if(i>0){
		return module;
	}
		return null;
	}

}
