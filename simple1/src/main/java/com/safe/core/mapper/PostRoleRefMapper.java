package com.safe.core.mapper;

import com.safe.core.beans.PostRoleRef;

public interface PostRoleRefMapper {
    int deleteByPrimaryKey(PostRoleRef key);

    int insert(PostRoleRef record);

    int insertSelective(PostRoleRef record);
}