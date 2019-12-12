package com.safe.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.safe.core.beans.Position;
import com.safe.core.service.PositionService;

@Controller
@RequestMapping("/position")
public class PositionController {
	@Autowired
	private PositionService positionService;
	@RequestMapping("/all")
	@ResponseBody
	public List<Position> allPosition(){
		return positionService.selectAll();
	}
	@RequestMapping("/position/{id}")
	@ResponseBody
	public Position findOne(@PathVariable Integer id){
		return positionService.selectByPrimaryKey(id);
	}
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Boolean deleteOne(@PathVariable Integer id){
		return positionService.deleteByPrimaryKey(id);
	}
	@RequestMapping("/update")
	@ResponseBody
	public Position updateOne(Position position){
		return positionService.update(position);
	}
	@RequestMapping("/insert")
	@ResponseBody
	public Position createOne(Position position){
		return positionService.insert(position);
	}
}
