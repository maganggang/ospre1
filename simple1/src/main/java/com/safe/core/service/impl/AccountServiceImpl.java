package com.safe.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safe.core.beans.Account;
import com.safe.core.mapper.AccountMapper;
import com.safe.core.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
private AccountMapper accountMapper;

	public List<Account> selectAll() {
		return accountMapper.selectAll();
	}

	public Account selectByPremaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean deleteAccount(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Account updateAccountl(Account account) {
		// TODO Auto-generated method stub
		return null;
	}
}
