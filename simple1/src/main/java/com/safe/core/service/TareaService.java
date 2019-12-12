package com.safe.core.service;

import java.util.List;

import com.safe.core.beans.Tarea;

public interface TareaService {

	List<Tarea> selectAll();

	Tarea selectByPrimaryKey(Integer id);

	Boolean deleteByPrimaryKey(Integer id);

	Tarea update(Tarea tarea);

	Tarea insert(Tarea tarea);

}
