package com.safe.core.beans;

import java.io.Serializable;

public class AuthorityRoleRef implements Serializable {
    private Integer authorityId;

    private Integer roleId;

    private static final long serialVersionUID = 1L;

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}