package com.safe.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.safe.core.beans.Department;
import com.safe.core.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departService;
	@RequestMapping("/all")
	@ResponseBody
	public List<Department> allDepartment(){
		return departService.selectAll();
	}
	@RequestMapping("/dept/{id}")
	@ResponseBody
	public Department findOne(@PathVariable Integer id){
		return departService.selectByPrimaryKey(id);
	}
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Boolean deleteOne(@PathVariable Integer id){
		return departService.deleteByPrimaryKey(id);
	}
	@RequestMapping("/update")
	@ResponseBody
	public Department updateOne(Department dept){
		return departService.update(dept);
	}
	@RequestMapping("/insert")
	@ResponseBody
	public Department createOne(Department dept){
		return departService.insert(dept);
	}
}
