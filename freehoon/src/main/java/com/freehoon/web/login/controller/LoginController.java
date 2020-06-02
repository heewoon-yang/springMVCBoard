package com.freehoon.web.login.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.freehoon.web.login.service.LoginService;
import com.freehoon.web.user.model.UserVO;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class); 
	
	@Inject
	private LoginService loginService;
	
	//01.로그인 화면
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(Model model) throws Exception{
		model.addAttribute("userVO", new UserVO());
		return "login/login";
	}

	//
	@RequestMapping(value = "/signupForm", method = RequestMethod.GET) 
	public String signupForm(Model model) throws Exception { 
		model.addAttribute("userVO", new UserVO()); 
		return "login/signupForm"; 
	}

	
	//02.로그인 처리
	@RequestMapping(value = "/loginCheck", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView loginCheck(@ModelAttribute("userVO") UserVO userVO, HttpSession session ) throws Exception{
		boolean result = loginService.loginCheck(userVO, session);
		ModelAndView mav = new ModelAndView();
		
		if(result == true) {
			mav.setViewName("board/index");
			mav.addObject("msg","success");
		} else {
			mav.setViewName("login/login");
			mav.addObject("msg","failure");
		}
		logger.info("@@@@@@@@ mav.getViewName() - "+mav.getViewName());
		
		return mav;
	}
	
	//03.로그아웃 처리
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) throws Exception{
		loginService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login/login");
		mav.addObject("msg","logout");
		
		return mav;
	}

}
