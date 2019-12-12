package com.safe.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.safe.core.beans.Module;
import com.safe.core.service.ModuleService;

@Controller
@RequestMapping("/module")
public class ModuleController {
	@Autowired
	private ModuleService moduleService;
	@RequestMapping("/all")
	@ResponseBody
	public List<Module> allModule(){
		return moduleService.selectAll();
	}
	@RequestMapping("/auth/{id}")
	@ResponseBody
	public Module findOne(@PathVariable Integer id){
		return moduleService.selectByPrimaryKey(id);
	}
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Boolean deleteOne(@PathVariable Integer id){
		return moduleService.deleteByPrimaryKey(id);
	}
	@RequestMapping("/update")
	@ResponseBody
	public Module updateOne(Module module){
		return moduleService.update(module);
	}
	@RequestMapping("/insert")
	@ResponseBody
	public Module createOne(Module module){
		return moduleService.insert(module);
	}
}
