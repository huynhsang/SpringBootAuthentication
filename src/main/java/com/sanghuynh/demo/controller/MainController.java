package com.sanghuynh.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sanghuynh.demo.repository.AuthorityDAO;


@Controller
public class MainController implements ErrorController{
	
	private static final String PATH = "/error";
	
	@Autowired
	AuthorityDAO authorityDAO;
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public @ResponseBody String home (){
		return "<button>M</button>";
	}
	
	@RequestMapping(value="/authority", method=RequestMethod.GET)
	public @ResponseBody String getAuthority(){
		String result = authorityDAO.findOne(1).getName().name();
		return result;
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public @ResponseBody ModelAndView login (){
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.GET)
	public @ResponseBody String register (){
		return "register";
	}
	
	@RequestMapping(value = PATH, method=RequestMethod.GET)
    public ModelAndView error() {
        return new ModelAndView("redirect:/login");
    }
	
	@RequestMapping(value = "/403", method=RequestMethod.GET)
	public @ResponseBody String forbidden (){
		return "403 Forbidden!";
	}
	
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}
}
