package com.safe.core.beans;

import java.io.Serializable;

public class Dict implements Serializable {
    private Integer id;

    private String dictType;

    private String dictValue;

    private String dictGroupName;

    private String dictGroupValue;

    private String desc;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType == null ? null : dictType.trim();
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue == null ? null : dictValue.trim();
    }

    public String getDictGroupName() {
        return dictGroupName;
    }

    public void setDictGroupName(String dictGroupName) {
        this.dictGroupName = dictGroupName == null ? null : dictGroupName.trim();
    }

    public String getDictGroupValue() {
        return dictGroupValue;
    }

    public void setDictGroupValue(String dictGroupValue) {
        this.dictGroupValue = dictGroupValue == null ? null : dictGroupValue.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}