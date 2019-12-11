package com.safe.core.service;

import java.util.List;


import com.safe.core.beans.Account;

public interface AccountService {
	public List<Account> selectAll();

	public Account selectByPremaryKey(Integer id);

	public Boolean deleteAccount(Integer id);

	public Account updateAccountl(Account account);
}
