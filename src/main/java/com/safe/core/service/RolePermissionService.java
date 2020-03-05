package com.safe.core.service;

import java.util.List;

import com.safe.core.beans.RolePermission;

public interface RolePermissionService {

	List<RolePermission> selectAll();

	RolePermission selectByPrimaryKey(Integer id);

	Boolean deleteByPrimaryKey(Integer id);

	RolePermission update(RolePermission rolePermission);

	RolePermission insert(RolePermission rolePermission);

}
