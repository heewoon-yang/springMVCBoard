package com.freehoon.web.user.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.freehoon.web.user.model.UserVO;
import com.freehoon.web.user.service.UserService;

@Controller 
@RequestMapping(value = "/user") 
public class UserController { 
	private static final Logger logger = LoggerFactory.getLogger(UserController.class); 
	
	@Inject 
	private UserService userService; 
	
	@RequestMapping(value = "/getUserList", method = {RequestMethod.GET,RequestMethod.POST}) 
	public String getUserList(Model model) throws Exception{ 
		logger.info("getUserList()...."); 
		model.addAttribute("userList", userService.getUserList()); 
		return "user/userList"; 
	} 
	
	@RequestMapping(value = "/insertUser", method = {RequestMethod.GET,RequestMethod.POST}) 
	public String insertUser(@ModelAttribute("userVO") UserVO userVO , RedirectAttributes rttr) throws Exception { 
		logger.info("insertUser()...."+userVO); 
		logger.info("insertUser()...."+rttr); 
		userService.insertUser(userVO); 
		return "redirect:/user/getUserList"; 
	} 
}
