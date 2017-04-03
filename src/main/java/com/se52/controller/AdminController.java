package com.se52.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {
	
	@RequestMapping(value = "/admin", method=RequestMethod.GET)
	public @ResponseBody String admin (){
		return "admin";
	}
	
	@RequestMapping(value = "/admin/db", method=RequestMethod.GET)
	public @ResponseBody String adminDb (){
		return "admin db";
	}
}
