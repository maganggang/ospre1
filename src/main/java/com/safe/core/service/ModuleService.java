package com.safe.core.service;

import java.util.List;

import com.safe.core.beans.Module;

public interface ModuleService {

	List<Module> selectAll(Module module);

	Module selectByPrimaryKey(Integer id);

	Boolean deleteByPrimaryKey(Integer id);

	Module update(Module module);

	Module insert(Module module);

}
