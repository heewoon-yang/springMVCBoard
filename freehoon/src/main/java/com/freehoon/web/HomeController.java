package com.freehoon.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.freehoon.web.board.model.BoardVO;
import com.freehoon.web.board.model.MyStudentCommand;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model
//				, HttpServletRequest req
//				, @RequestParam("name") String name
			) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		System.out.println("### formattedDate--->"+ formattedDate);

//		logger.info("request.getParameter(\'id\')------{}.", req.getParameter("id"));
//		logger.info("@RequestParam('name')------{}.", name);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("hello", "Hello Java Spring World !!!" );
		
		return "home";
	}
	
	@ModelAttribute("value2")
	public String myview(Model model) {
		return "pass to view";
	}
	@ModelAttribute("value3")
	public BoardVO boardList() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("≈∏¿Ã∆≤");
		boardVO.setCate_cd("222222222222");
		return boardVO;
	}
	
	@RequestMapping(value = "value3")
	public String myview2() {
		return "board/index";
	}
	
	@RequestMapping(value = "myview")
	public String myview(MyStudentCommand student) {
		return "test/myView";
	}
	
	@RequestMapping(value = "testView/{name}/{age}")
	public String testView(
				@PathVariable("age") String age,
				@PathVariable("name") String name,
				Model model
			) {
		model.addAttribute("age",age);
		model.addAttribute("name",name);
		
		return "test/testView";
	}
	
	
}
