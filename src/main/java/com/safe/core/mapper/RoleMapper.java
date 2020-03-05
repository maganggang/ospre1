package com.safe.core.mapper;

import java.util.List;

import com.safe.core.beans.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);


	int insertSelectiveReturnKey(Role role);

	List<Role> findAll();
}