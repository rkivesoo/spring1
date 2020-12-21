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
private MemberServiceImpl memberService;//"���¿��⼭~ ������� ��ü�� ����ϰڴ�~!
	//���� ���� ȭ�� .
@RequestMapping("/login.me")//add1909
public String userCheck(MemberVO member, HttpSession session,
		HttpServletResponse response) throws Exception{
	
	System.out.println("������ �� vo => " + member.toString());
	
	//System.out.println("web (HttpServlet request)==> " +request.toString());//�ȳ��� -->(202012022051: ����: �������� Ư�� ������Ʈ�� ���Ұ� MemberVO member������ ��ģ��. ) 
	//System.out.println("web ==> " +member.toString());//�ȳ��� //
	
	String id= member.getId();//���̵� ���� ���� 
	String pw= member.getPassword();//�н����� ���� ���� 
	
//	MemberVO vo=memberService.userCheck(member);	
//	vo.setId(id);
//	vo.setPassword(pw);
	//----------��δ� ������ ������ �Է��� ��. ���� DB�ƴ�-------	
	
	//DB���� �޾� ���� 
	MemberVO rm = memberService.userCheck(member);
	
	System.out.println("DB���� �� vo => " + rm.toString());
	//int vo1=-1;//�߰� // ws                      

	//int res = 0;//�߰� �غ�
	
	response.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
	PrintWriter writer=response.getWriter();
	
	
	if(pw.equals(rm.getPassword()))//���̵�� �н����尡 ��ġ �ϴ� ���. - ���� 
	{
		session.setAttribute("id",rm.getId());
		
		writer.write("<script>alert('�α��� ����!!');"
				+" location.href='./main.me';</script>");
		//return "redirect:/main.me";
	}
	else
	{
		writer.write("<script>alert('�α��� ����!!');"
				+"location.href='./mainform.me';</script>");
		//return "redirect:/loginform.me";
	}
     return null;
 //	return x;
	
//	if(res==1)//���̵�� �н����尡 ��ġ �ϴ� ���. - ���� 
//	{
//		session.setAttribute("id",member.getId());
//		writer.write("<script>alert('�α��� ����!!');"
//				+" location.href='./main.me';</script>");
//		//return "redirect:/main.me";
//	}
//	else
//	{
//		writer.write("<script>alert('�α��� ����!!');"
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
		//view ȭ���� mail.jsp�� DB�� ���� �о�� �����͸� �����ش�. 
		ModelAndView result=new ModelAndView();  //-----------------------���� �´��� �𸣰ڴ� �߸��� ���� �� Ȯ�� �ܾ� ���� �Ʒ���
		List<MemberVO> member_list=memberService.getMembers();
		result.addObject("memberList",member_list);
		result.setViewName("list");//����߰� 202012021039 
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
			writer.write("<script>alert('ȸ�� ���� ����!!');"
					+"location.href='./loginform.me';</script>");
		}
		else
		{
			writer.write("<script>alert('ȸ�� ���� ����!!');"
					+"location.href='./joinform.me';</script>");
			
		}
		
		return null;//���Ķ����� �־���.������ ��ũ�� �̵�������...
	}
	//insert ��ư Ŭ���� ���� �����ͼ� list.jsp�� ȭ����ȯ ���ش�. 
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
		 
		 System.out.println("from web > " + member.toString()  );//����Ȯ�� ���� 20201202
		 
		 System.out.println("member.getId= "+member.getId());
		 String id= member.getId();
		 member=memberService.getMember(member);
		 
		 System.out.println("after select > " + member.toString());//����Ȯ�� ���� 20201202
		 
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
		 memberService.updateMember(member);//member�� ID�� �����ҵ����Ͱ� �����
		 System.out.println("update complete");
		 
		 return "redirect:/list.do";
	 }
	 
	 @RequestMapping("/delete.do")
	 public ModelAndView delete (MemberVO member) {
		 String id=member.getId();//member��ID����
		 
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
