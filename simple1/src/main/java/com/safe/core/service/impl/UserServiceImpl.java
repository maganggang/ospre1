package com.safe.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safe.core.beans.User;
import com.safe.core.mapper.UserMapper;
import com.safe.core.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
private UserMapper userMapper;
	public List<User> selectAll() {
		return userMapper.findAll();
	}

	public User selectByPrimaryKey(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public Boolean deleteByPrimaryKey(Integer id) {
		int i=userMapper.deleteByPrimaryKey(id);
		if(i>0){
			return true;
		}
		return false;
	}

	public User update(User user) {
		int i=userMapper.updateByPrimaryKeySelective(user);
		if(i>0){
			return user;
		}
		return null;
	}

	public User insert(User user) {
		int i=userMapper.insertSelectiveReturnKey(user);
		if(i>0){
			return user;
		}
		return null;
	}

}
