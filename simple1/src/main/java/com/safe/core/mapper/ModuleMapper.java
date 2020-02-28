package com.safe.core.mapper;

import java.util.List;

import com.safe.core.beans.Module;

public interface ModuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);

	int insertSelectiveReturnKey(Module module);

	List<Module> findAll(Module module);
}