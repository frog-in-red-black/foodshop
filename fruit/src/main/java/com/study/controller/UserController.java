package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.entity.User;
import com.study.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	

	@RequestMapping("/login")	
	public String login() {
		return "login";
	}
	
	@RequestMapping("/register")	
	public String register() {
		return "register";
	}
	
	@RequestMapping("/toRegister")	
	public String register(User user,Model model) {
		
		int result=userService.userReg(user);
		if(result>0) {return "login";}
		return "login";
	}
	
    @RequestMapping("/toLogin")
	
	public String toLogin(User user,Model model) {
		System.out.println(user);		
		User userR=userService.userLogin(user);
		if (userR !=null) {
			model.addAttribute("user",userR );
			return "redirect:allFruit";
		}else {
			String message="密码或者账号错误";
			model.addAttribute("message", message);
			return "login";
		}
		
	}

}
