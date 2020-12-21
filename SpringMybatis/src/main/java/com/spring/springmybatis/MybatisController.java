package com.spring.springmybatis;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MybatisController {
@Autowired
private MemberServiceImpl memberService;
	//���� ���� ȭ�� .
	@RequestMapping("/list.do")
	public ModelAndView main(Model model) {
		//view ȭ���� mail.jsp�� DB�� ���� �о�� �����͸� �����ش�. 
		ModelAndView result=new ModelAndView();  //-----------------------���� �´��� �𸣰ڴ� �߸��� ���� �� Ȯ�� �ܾ� ���� �Ʒ���
		List<MemberVO> memberList=memberService.getMembers();
		result.addObject("memberList",memberList);
		result.setViewName("list");//����߰� 202012021039 
		return result;
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
		 member=memberService.getMember(id);
		 
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
