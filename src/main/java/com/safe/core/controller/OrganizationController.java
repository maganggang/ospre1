package com.safe.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.safe.core.beans.Organization;
import com.safe.core.service.OrganizationService;

@Controller
@RequestMapping("/organization")
public class OrganizationController {
	@Autowired
	private OrganizationService organizationService;
	@RequestMapping("/all")
	@ResponseBody
	public List<Organization> allOrganization(){
		return organizationService.selectAll();
	}
	@RequestMapping("/org/{id}")
	@ResponseBody
	public Organization findOne(@PathVariable Integer id){
		return organizationService.selectByPrimaryKey(id);
	}
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Boolean deleteOne(@PathVariable Integer id){
		return organizationService.deleteByPrimaryKey(id);
	}
	@RequestMapping("/update")
	@ResponseBody
	public Organization updateOne(Organization org){
		return organizationService.update(org);
	}
	@RequestMapping("/insert")
	@ResponseBody
	public Organization createOne(Organization org){
		return organizationService.insert(org);
	}
}
