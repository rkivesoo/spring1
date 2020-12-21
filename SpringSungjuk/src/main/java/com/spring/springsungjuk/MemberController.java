package com.spring.springsungjuk;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;//의존성 주입 
	
	@RequestMapping("/login.me")
	public String userCheck(SungjukVO memberVO, HttpSession session,
			HttpServletResponse response) throws Exception{
		int res=memberService.userCheck(memberVO);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer=response.getWriter();
		if(res==1)//아이디와 패스워드가 일치 하는 경우. 
		{
			session.setAttribute("hakbun",memberVO.getHakbun());
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
	
	@RequestMapping("/joinform.me")
	public String joinForm() throws Exception{
		return "joinForm";
	}
	
	@RequestMapping("/joinprocess.me")
	public String insertMember(SungjukVO memberVO, HttpServletResponse response)
			throws Exception{
		
		int res=memberService.insertMember(memberVO);
		
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
	
	 @RequestMapping("/memberlist.me")
	 	public String getMemberlist(Model model) throws Exception{
		 ArrayList<SungjukVO> member_list=memberService.getMemberlist();
		 model.addAttribute("member_list", member_list);
		
		 
		 return "member_list";
	 }
	
	 @RequestMapping("/memberinfo.me")
	 public String selectMember(SungjukVO memberVO, Model model)
			 throws Exception{
		 SungjukVO vo=memberService.selectMember(memberVO);
		 model.addAttribute("memberVO",vo);
		 
		 return "member_info";
	 }
	 
	 @RequestMapping("/memberdelete.me")
	 public String deleteMember(SungjukVO memberVO, Model model)
			 throws Exception{
		 		 
		 memberService.deleteMember(memberVO);
		 return "redirect:/memberlist.me";
	
	 }
	 

	
	 
	 @RequestMapping("/modifyform.me")
		public String modifyform(SungjukVO memberVO, Model model) throws Exception{
		 
		 SungjukVO vo=memberService.selectMember(memberVO);
		 model.addAttribute("memberVO",vo);
		 
			return "modifyform";
		}
	
	
		@RequestMapping("/modifyprocess.me")
		public String modifyMember(SungjukVO memberVO, HttpServletResponse response)
				throws Exception{
			
			int res=memberService.modifyMember(memberVO);
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter writer =response.getWriter();
			if(res != 0)
			{
				writer.write("<script>alert('회원 정보 수정 성공!!');"
						+"location.href='./memberlist.me';</script>");
			}
			else
			{
				writer.write("<script>alert('회원 정보 수정 실패!!');"
						+"location.href='./memberlist.me';</script>");
				
			}
			
			return null;//형식때문에 주었다.어차리 링크로 이동하지만...
		}
	
	
}

















