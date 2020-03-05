package com.safe.core.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.safe.core.beans.AuthorityRoleRef;

public interface AuthorityRoleRefMapper {
    int insert(AuthorityRoleRef record);

    int insertSelective(AuthorityRoleRef record);

	int insertBatch(@Param("roleId")Integer roleId, @Param("authorityIds")List<String> authorityIds);
}