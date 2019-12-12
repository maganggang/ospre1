package com.safe.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safe.core.beans.Company;
import com.safe.core.beans.Position;
import com.safe.core.mapper.CompanyMapper;
import com.safe.core.mapper.PositionMapper;
import com.safe.core.service.PositionService;
@Service
public class PositionServiceImpl implements PositionService{
	@Autowired
private PositionMapper positionMapper;
	public List<Position> selectAll() {
		return positionMapper.findAll();
	}

	public Position selectByPrimaryKey(Integer id) {
		return positionMapper.selectByPrimaryKey(id);
	}

	public Boolean deleteByPrimaryKey(Integer id) {
		int i=positionMapper.deleteByPrimaryKey(id);
		if(i>0){
			return true;
		}
		return false;
	}

	public Position update(Position position) {
	int i=positionMapper.updateByPrimaryKeySelective(position);
		if(i>0){
			return position;
		}
		return null;
	}

	public Position insert(Position position) {
		int i=positionMapper.insertSelectiveReturnKey(position);
		if(i>0){
			return position;
		}
		return null;
	}

}
