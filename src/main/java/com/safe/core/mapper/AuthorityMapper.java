package com.safe.core.mapper;

import java.util.List;

import com.safe.core.beans.Authority;

public interface AuthorityMapper {
    int insert(Authority record);

    int insertSelective(Authority record);

	int insertSelectiveReturnKey(Authority authority);

	List<Authority> findAll();

	Authority selectByPrimaryKey(Integer id);

	int deleteByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Authority authority);
}