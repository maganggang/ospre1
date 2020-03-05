package com.safe.core.mapper;

import com.safe.core.beans.AccountRoleRef;

public interface AccountRoleRefMapper {
    int deleteByPrimaryKey(AccountRoleRef key);

    int insert(AccountRoleRef record);

    int insertSelective(AccountRoleRef record);
}