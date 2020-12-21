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
	public String res(memberVO vo, Model model) {
		
		String id= vo.getId();
		String pw= vo.getPw();
		String jumin1= vo.getJumin1();
		String jumin2= vo.getJumin2();
		String gender= vo.getGender();
		String tel1= vo.getTel1();
		String tel2= vo.getTel2();
		String tel3= vo.getTel3();
		String email1= vo.getEmail1();
		String email2= vo.getEmail2();
		String hobby= vo.getHobby();
		String intro= vo.getIntro();	
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("jumin1", jumin1);
		model.addAttribute("jimin2", jumin2);
		model.addAttribute("gender", gender);
		model.addAttribute("tel1", tel1);
		model.addAttribute("tel2", tel2);
		model.addAttribute("tel3", tel3);
		model.addAttribute("email1", email1);
		model.addAttribute("email2", email2);
		model.addAttribute("hobby", hobby);
		model.addAttribute("intro", intro);
			
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
