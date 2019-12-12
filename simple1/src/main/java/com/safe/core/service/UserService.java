package com.safe.core.service;

import java.util.List;

import com.safe.core.beans.User;

public interface UserService {

	List<User> selectAll();

	User selectByPrimaryKey(Integer id);

	Boolean deleteByPrimaryKey(Integer id);

	User update(User user);

	User insert(User user);

}
