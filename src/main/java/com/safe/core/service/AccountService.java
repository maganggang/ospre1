package com.safe.core.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.safe.core.beans.Account;

public interface AccountService {
	public List<Account> selectAll();

	public Account selectByPrimaryKey(Integer id);

	public Boolean deleteAccount(Integer id);

	public Account updateAccount(Account account);

	public Account insertAccount(Account account);

	public Account login(String username,String password);
}
