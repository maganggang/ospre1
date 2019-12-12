package com.safe.core.mapper;

import java.util.List;

import com.safe.core.beans.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int deleteByPrimaryKey(Integer id);

	int insertSelectiveReturnKey(User user);

	int updateByPrimaryKeySelective(User user);

	List<User> findAll();
}