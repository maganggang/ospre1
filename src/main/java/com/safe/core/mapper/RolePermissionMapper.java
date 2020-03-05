package com.safe.core.mapper;


import com.safe.core.beans.RolePermission;

public interface RolePermissionMapper {
    int insert(RolePermission record);

    int insertSelective(RolePermission record);

}