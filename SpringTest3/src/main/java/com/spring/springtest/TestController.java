package com.spring.springtest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@RequestMapping(value="input_form.bo")//"input_form.bo"이런 URL이 들어 오면 얘를 실행할꺼야
	public String input() {
		return "input_form";
	}
	/*HttpServletRequest request :리퀘스트 객체로 받아 올때 
	@RequestMapping(value="input.bo", method=RequestMethod.POST)
	public String res(HttpServletRequest request, Model model) {  
		
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "res";
				
	}
	*/
	
	//LoginVO vo:vo객체로 받아 올때
	 
	@RequestMapping(value="input.bo", method=RequestMethod.POST)
	public String res(LoginVO vo, Model model) {
		
		String id= vo.getId();
		String pw= vo.getPw();
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "res";
				
	}
	
	//ModelAndView
		/*
		@RequestMapping(value="input.bo", method=RequestMethod.POST)
		public ModelAndView res(HttpServletRequest request,  ModelAndView mav) {
			
		
			
			String id= request.getParameter("id");
			String pw= request.getParameter("pw");
			mav.addObject("id",id);
			mav.addObject("pw",pw);
			mav.setViewName("res");
			
			return mav;
					
		}
		*/
}
