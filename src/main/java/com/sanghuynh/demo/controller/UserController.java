package com.sanghuynh.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	
	@RequestMapping(value = "/user", method=RequestMethod.GET)
	public @ResponseBody String user (){
		return "user";
	}
	
	@RequestMapping(value = "/user/db", method=RequestMethod.GET)
	public @ResponseBody String adminDb (){
		return "user db";
	}
}
