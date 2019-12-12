package com.safe.core.mapper;

import com.safe.core.beans.AuthorityRoleRef;

public interface AuthorityRoleRefMapper {
    int insert(AuthorityRoleRef record);

    int insertSelective(AuthorityRoleRef record);
}