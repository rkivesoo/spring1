package com.spring.springmvcsungjuk01;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SungjukController {

	@Autowired
	private SungjukService sungjukService;//의존성 주입 
	
	
	@RequestMapping("/login.me")
	public String userCheck(SungjukVO sungjukVO, HttpSession session,
			HttpServletResponse response) throws Exception{
		int res=sungjukService.userCheck(sungjukVO);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer=response.getWriter();
		if(res==1)//아이디와 패스워드가 일치 하는 경우. 
		{
			session.setAttribute("hakbun",sungjukVO.getHakbun());
			writer.write("<script>alert('로그인 성공!!');"
					+" location.href='./main.me';</script>");
			//return "redirect:/main.me";
		}
		else
		{
			writer.write("<script>alert('로그인 실패!!');"
					+"location.href='./mainform.me';</script>");
			//return "redirect:/loginform.me";
		}
		return null;
	}
	
	@RequestMapping("/main.me")
	public String mainPage() throws Exception{
		return "main";
	}
	
	@RequestMapping("/loginform.me")
	public String loginForm() throws Exception{
		return "loginForm";
	}
	//@RequestMapping("/sungjuklist.me")
	//public String sungjuklistform() throws Exception{
	//	return "sungjuklistform";
	//}
	////@RequestMapping("/inputprocess.me")
	//public String sungjuk_input() throws Exception{
	////	return "sungjuk_input";
	//}
	
	@RequestMapping("/inputprocess.me")
	public String insertSungjuk(SungjukVO sungjukVO, HttpServletResponse response)
			throws Exception{
		
		int res=sungjukService.insertSungjuk(sungjukVO);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer =response.getWriter();
		if(res != 0)
		{
			writer.write("<script>alert('입력 성공!!');"
					+"location.href='./sungjuklist.me';</script>");
		}
		else
		{
			writer.write("<script>alert('입력 실패!!');"
					+"location.href='./sungjuklist.me';</script>");
			
		}
		
		return null;//형식때문에 주었다.어차리 링크로 이동하지만...
	}
	
	
	
	@RequestMapping("/joinform.me")
	public String joinForm() throws Exception{
		return "joinForm";
	}
	
	@RequestMapping("/joinprocess.me")
	public String insertMember(SungjukVO sungjukVO, HttpServletResponse response)
			throws Exception{
		
		int res=sungjukService.insertSungjuk(sungjukVO);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer =response.getWriter();
		if(res != 0)
		{
			writer.write("<script>alert('회원 가입 성공!!');"
					+"location.href='./loginform.me';</script>");
		}
		else
		{
			writer.write("<script>alert('회원 가입 실패!!');"
					+"location.href='./joinform.me';</script>");
			
		}
		
		return null;//형식때문에 주었다.어차리 링크로 이동하지만...
	}
	
	 @RequestMapping("/sungjuklist.me")
	 	public String getSungjuklist(Model model) throws Exception{
		 ArrayList<SungjukVO> sungjuk_list=sungjukService.getSungjuklist();
		 model.addAttribute("sungjuk_list", sungjuk_list);
		
		 
		 return "sungjuk_list";
	 }
	
	 @RequestMapping("/sungjukinfo.me")
	 public String selectSungjuk(SungjukVO sungjukVO, Model model)
			 throws Exception{
		 SungjukVO vo=sungjukService.selectSungjuk(sungjukVO);
		 model.addAttribute("sungjukVO",vo);
		 
		 return "sungjuk_info";
	 }
	 
	 @RequestMapping("/sungjukdelete.me")
	 public String deleteSungjuk(SungjukVO sungjukVO, Model model)
			 throws Exception{
		 		 
		 sungjukService.deleteSungjuk(sungjukVO);
		 return "redirect:/memberlist.me";
	
	 }
	 
	 
	 @RequestMapping("/modifyform.me")
		public String modifyform(SungjukVO sungjukVO, Model model) throws Exception{
		 
		 SungjukVO vo=sungjukService.selectSungjuk(sungjukVO);
		 model.addAttribute("memberVO",vo);
		 
			return "modifyform";
		}
	
	
		@RequestMapping("/modifyprocess.me")
		public String modifyMember(SungjukVO sungjukVO, HttpServletResponse response)
				throws Exception{
			
			int res=sungjukService.modifySungjuk(sungjukVO);
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter writer =response.getWriter();
			if(res != 0)
			{
				writer.write("<script>alert(' 정보 수정 성공!!');"
						+"location.href='./memberlist.me';</script>");
			}
			else
			{
				writer.write("<script>alert(' 정보 수정 실패!!');"
						+"location.href='./memberlist.me';</script>");
				
			}
			
			return null;//형식때문에 주었다.어차리 링크로 이동하지만...
		}
	
	
}


