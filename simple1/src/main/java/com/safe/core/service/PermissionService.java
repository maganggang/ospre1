package com.safe.core.service;

import java.util.List;

import com.safe.core.beans.Permission;

public interface PermissionService {

	List<Permission> selectAll();

	Permission selectByPrimaryKey(Integer id);

	Boolean deleteByPrimaryKey(Integer id);

	Permission update(Permission permission);

	Permission insert(Permission permission);

}
