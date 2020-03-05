package com.safe.core.mapper;

import java.util.List;

import com.safe.core.beans.Tarea;

public interface TareaMapper {
    int deleteByPrimaryKey(Integer areaid);

    int insert(Tarea record);

    int insertSelective(Tarea record);

    Tarea selectByPrimaryKey(Integer areaid);

    int updateByPrimaryKeySelective(Tarea record);

    int updateByPrimaryKey(Tarea record);

	List<Tarea> findAll();

	int insertSelectiveReturnKey(Tarea tarea);
}