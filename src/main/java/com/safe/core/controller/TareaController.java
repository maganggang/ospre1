package com.safe.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.safe.core.beans.Tarea;
import com.safe.core.service.TareaService;

@Controller
@RequestMapping("/tarea")
public class TareaController {
	@Autowired
	private TareaService tareaService;
	@RequestMapping("/all")
	@ResponseBody
	public List<Tarea> allTarea(){
		return tareaService.selectAll();
	}
	@RequestMapping("/user/{id}")
	@ResponseBody
	public Tarea findOne(@PathVariable Integer id){
		return tareaService.selectByPrimaryKey(id);
	}
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Boolean deleteOne(@PathVariable Integer id){
		return tareaService.deleteByPrimaryKey(id);
	}
	@RequestMapping("/update")
	@ResponseBody
	public Tarea updateOne(Tarea tarea){
		return tareaService.update(tarea);
	}
	@RequestMapping("/insert")
	@ResponseBody
	public Tarea createOne(Tarea tarea){
		return tareaService.insert(tarea);
	}
}
