package com.safe.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.safe.core.beans.Item;
import com.safe.core.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService itemService;
	@RequestMapping("/all")
	@ResponseBody
	public List<Item> allItem(){
		return itemService.selectAll();
	}
	@RequestMapping("/item/{id}")
	@ResponseBody
	public Item findOne(@PathVariable Integer id){
		return itemService.selectByPrimaryKey(id);
	}
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Boolean deleteOne(@PathVariable Integer id){
		return itemService.deleteByPrimaryKey(id);
	}
	@RequestMapping("/update")
	@ResponseBody
	public Item updateOne(Item item){
		return itemService.update(item);
	}
	@RequestMapping("/insert")
	@ResponseBody
	public Item createOne(Item item){
		return itemService.insert(item);
	}
}
