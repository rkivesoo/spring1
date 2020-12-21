package com.spring.springmybatis;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MybatisController {
@Autowired
private MemberServiceImpl memberService;//"나는여기서~ 멤버서비스 객체를 사용하겠다~!
	//시작 메인 화면 .
@RequestMapping("/login.me")//add1909
public String userCheck(MemberVO member, HttpSession session,
		HttpServletResponse response) throws Exception{
	
	System.out.println("웹에서 온 vo => " + member.toString());
	
	//System.out.println("web (HttpServlet request)==> " +request.toString());//안나와 -->(202012022051: 이유: 스프링의 특성 리퀘스트의 역할과 MemberVO member역할이 겹친다. ) 
	//System.out.println("web ==> " +member.toString());//안나와 //
	
	String id= member.getId();//아이디 가져 오기 
	String pw= member.getPassword();//패스워드 가져 오기 
	
//	MemberVO vo=memberService.userCheck(member);	
//	vo.setId(id);
//	vo.setPassword(pw);
	//----------상부는 웹에서 유저가 입력한 값. 절대 DB아님-------	
	
	//DB에서 받아 오자 
	MemberVO rm = memberService.userCheck(member);
	
	System.out.println("DB에서 온 vo => " + rm.toString());
	//int vo1=-1;//추가 // ws                      

	//int res = 0;//추가 해봄
	
	response.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
	PrintWriter writer=response.getWriter();
	
	
	if(pw.equals(rm.getPassword()))//아이디와 패스워드가 일치 하는 경우. - 변경 
	{
		session.setAttribute("id",rm.getId());
		
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
 //	return x;
	
//	if(res==1)//아이디와 패스워드가 일치 하는 경우. - 변경 
//	{
//		session.setAttribute("id",member.getId());
//		writer.write("<script>alert('로그인 성공!!');"
//				+" location.href='./main.me';</script>");
//		//return "redirect:/main.me";
//	}
//	else
//	{
//		writer.write("<script>alert('로그인 실패!!');"
//				+"location.href='./mainform.me';</script>");
//		//return "redirect:/loginform.me";
//	}
	//return null;
}

@RequestMapping("/main.me") //add1909
public String mainPage() throws Exception{
	return "main";
}

@RequestMapping("/loginform.me")
public String loginForm() throws Exception{
	return "loginForm";
}
	@RequestMapping("/list.do")
	public ModelAndView main(Model model) {
		//view 화면인 mail.jsp에 DB로 부터 읽어온 데이터를 보여준다. 
		ModelAndView result=new ModelAndView();  //-----------------------여기 맞는지 모르겠다 잘린거 없는 지 확인 단어 끝과 아래줄
		List<MemberVO> member_list=memberService.getMembers();
		result.addObject("memberList",member_list);
		result.setViewName("list");//방금추가 202012021039 
		return result;
	}
	@RequestMapping("/joinform.me")//add1946
	public String joinForm() throws Exception{
		return "joinForm";
	}
	
	@RequestMapping("/joinprocess.me")//add1946
	public String insertMember(MemberVO memberVO, HttpServletResponse response)
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
	//insert 버튼 클릭시 값을 가져와서 list.jsp로 화면전환 해준다. 
	@RequestMapping("/insert.do")
	public ModelAndView insert(MemberVO member) {
		memberService.insertMember(member);
		/*
		HashMap<String, String>map=new HashMap<String, String>();
		map.put("id",member.getId()); //HAah
		map.put("name", member.getName());//Hashmap
		map.put("email", member.getEmail());//Hashmap
	    map.put("phone",member.getPhone());//hashmap
	    memberService.insertMember2(map);//hashmap
	     */	
	    ModelAndView result = new ModelAndView();
	    List<MemberVO> memberList=memberService.getMembers();
	    result.addObject("memberList", memberList);
	    result.setViewName("list");
	    
	    return result;
	}
	
	 @RequestMapping("/updateForm.do")
	 public ModelAndView updateForm(MemberVO member) {
		 
		 System.out.println("from web > " + member.toString()  );//정보확인 구문 20201202
		 
		 System.out.println("member.getId= "+member.getId());
		 String id= member.getId();
		 member=memberService.getMember(member);
		 
		 System.out.println("after select > " + member.toString());//정보확인 구문 20201202
		 
		 System.out.println("updateForm complete");
		 
		 ModelAndView result= new ModelAndView();
		 result.addObject("member", member);
		 result.setViewName("updateForm");
		 return result;
		 
		 
	 }
	 /*
	 @RequestMapping("/update.do")
	 public ModelAndView update(MemberVo member) {
		 memberService.updateMember(member);
		 System.out.println("update complete");
		 
		 ModelAndView result = new ModelAndView();
		 List<MemberVO> memberList= memberService.getMembers(); ///idk,llllll
				 
		 result.addObject("memberList", memberList);
		 result.setViewName("list");
		 return result;	 
	 }
	 */
	 
	 @RequestMapping("/update.do")
	 public String update(MemberVO member) {
		 memberService.updateMember(member);//member에 ID와 수정할데이터가 저장됨
		 System.out.println("update complete");
		 
		 return "redirect:/list.do";
	 }
	 
	 @RequestMapping("/delete.do")
	 public ModelAndView delete (MemberVO member) {
		 String id=member.getId();//member에ID저장
		 
		 memberService.deleteMember(id);
		 System.out.println("delete complete");

		 ModelAndView result = new ModelAndView();
		 List<MemberVO>memberList= memberService.getMembers();				 
		 result.addObject("memberList", memberList);
		 result.setViewName("list");
		 return result;	
		
	 }
	 
	 /* 
	 @RequestMapping("/delete.do")
	 public String delete(MemberVO member) {
		 memberService.deleteMember(member);
		 System.out.println("delete complete");
		 
		 return "redirect:/list.do";
	 }
	 */
	
	 
	 
}
