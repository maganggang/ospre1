package com.safe.core.mapper;

import java.util.List;

import com.safe.core.beans.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

	int insertSelectiveReturnKey(Permission permission);

	List<Permission> findAll();
}