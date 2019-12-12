package com.safe.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.safe.core.beans.Position;
import com.safe.core.beans.Post;
import com.safe.core.beans.User;
import com.safe.core.service.PositionService;
import com.safe.core.service.PostService;
import com.safe.core.service.UserService;

@Controller
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostService postService;
	
	@RequestMapping("/all")
	@ResponseBody
	public List<Post> allPost(){
		return postService.selectAll();
	}
	@RequestMapping("/post/{id}")
	@ResponseBody
	public Post findOne(@PathVariable Integer id){
		return postService.selectByPrimaryKey(id);
	}
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Boolean deleteOne(@PathVariable Integer id){
		return postService.deleteByPrimaryKey(id);
	}
	@RequestMapping("/update")
	@ResponseBody
	public Post updateOne(Post post){
		return postService.update(post);
	}
	@RequestMapping("/insert")
	@ResponseBody
	public Post createOne(Post post){
		return postService.insert(post);
	}
}
