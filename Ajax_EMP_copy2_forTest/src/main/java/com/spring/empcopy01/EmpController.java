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
	
	//produces �Ӽ��� �̿��� Response �� Content-Type �� ������ �� �ִ�. 
	 @RequestMapping(value="/getEmpdata.do",
			 method=RequestMethod.POST,
			 produces="application/json;charset=UTF-8")
	 
	@ResponseBody//jsp�� ���� �並 ���� �ϴ� �� �ƴ� �����͸� ���� �ϱ� ���� ��� 
	public List<EmpVO> getEmpEx() {	
		
		List<EmpVO> list =empService.getEmpEx();
		
		return list;
	}
	
	
}
