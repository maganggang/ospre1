package com.safe.core.mapper;

import com.safe.core.beans.PermissionModuleRef;

public interface PermissionModuleRefMapper {
    int deleteByPrimaryKey(PermissionModuleRef key);

    int insert(PermissionModuleRef record);

    int insertSelective(PermissionModuleRef record);
}