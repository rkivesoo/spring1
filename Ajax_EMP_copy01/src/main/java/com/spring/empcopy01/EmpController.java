package com.spring.empcopy01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;

	
	@RequestMapping(value="/home.do", method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	//produces 속성을 이용해 Response 의 Content-Type 을 제어할 수 있다. 
	 @RequestMapping(value="/getEmpdata.do",
			 method=RequestMethod.POST,
			 produces="application/json;charset=UTF-8")
	 
	@ResponseBody//jsp와 같은 뷰를 전달 하는 게 아닌 데이터를 전달 하기 위해 사용 
	public List<EmpVO> getEmpEx() {	
		
		List<EmpVO> list =empService.getEmpEx();
		
		return list;
	}
	
	
}
