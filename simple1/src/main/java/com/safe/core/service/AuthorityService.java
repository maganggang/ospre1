package com.safe.core.service;

import java.util.List;

import com.safe.core.beans.Account;
import com.safe.core.beans.Authority;

public interface AuthorityService {

	List<Authority> selectAll();

	Authority selectByPrimaryKey(Integer id);

	Boolean deleteByPrimaryKey(Integer id);

	Authority update(Authority authority);

	Authority insert(Authority authority);

	Account selectAuthority(Integer i);

}
