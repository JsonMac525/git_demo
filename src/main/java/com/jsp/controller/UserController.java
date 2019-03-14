package com.jsp.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsp.async.AsyncTest;
import com.jsp.entity.User;
import com.jsp.mapper.UserMapper;



@Controller
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AsyncTest asyncTest;
	@Value("${base}")
	private String base;
	
	private static Logger log = Logger.getLogger(UserController.class);
	@ResponseBody
	@RequestMapping("getUser")
	public User getUser(String name){
		log.info(name);
		return userMapper.findByName(name);
	}
	@RequestMapping("/insert")
	public String insert(String name,String age){
		userMapper.insert(name, age);
		return "success";
	}
	@ResponseBody
	@RequestMapping("/async")
	public String async(){
		System.out.println("#############1");
		asyncTest.Test();
		System.out.println("#############2");
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("/base")
	public String base(){
		return base;
	}
	
	
}
