package com.safe.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safe.core.beans.Tarea;
import com.safe.core.mapper.TareaMapper;
import com.safe.core.service.TareaService;
@Service
public class TareaServiceImpl implements TareaService{
	@Autowired
private TareaMapper tareaMapper;
	public List<Tarea> selectAll() {
		return tareaMapper.findAll();
	}

	public Tarea selectByPrimaryKey(Integer id) {
		return tareaMapper.selectByPrimaryKey(id);
	}

	public Boolean deleteByPrimaryKey(Integer id) {
		int i=tareaMapper.deleteByPrimaryKey(id);
		if(i>0){
			return true;
		}
		return false;
	}

	public Tarea update(Tarea tarea) {
	int i=tareaMapper.updateByPrimaryKeySelective(tarea);
		if(i>0){
			return tarea;
		}
		return null;
	}

	public Tarea insert(Tarea tarea) {
		int i=tareaMapper.insertSelectiveReturnKey(tarea);
		if(i>0){
			return tarea;
		}
		return null;
	}


}
