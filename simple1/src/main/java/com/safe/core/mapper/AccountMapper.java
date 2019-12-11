package com.safe.core.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.safe.core.beans.Account;
public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

	List<Account> selectAll();
}