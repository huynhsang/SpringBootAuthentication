package com.se52.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StaffController {
	@RequestMapping(value = "/staff", method=RequestMethod.GET)
	public @ResponseBody String staff (){
		return "staff";
	}
}
