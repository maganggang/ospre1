package com.safe.core.beans;

import java.io.Serializable;

public class Permission implements Serializable {
    private Integer id;

    private Integer parentId;
    private String pathUrl;

    private String name;

    private String desc;

    private static final long serialVersionUID = 1L;

    public String getPathUrl() {
		return pathUrl;
	}

	public void setPathUrl(String pathUrl) {
		this.pathUrl = pathUrl;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}