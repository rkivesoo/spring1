package com.spring.springmybatis;

import java.util.ArrayList;
import java.util.HashMap;



public interface MemberService {
	public ArrayList<MemberVO> getMembers();//TOBe
	//public ArrayList<MemberVO> getMemberlist();//asis_202012021642
	
	public MemberVO getMember(MemberVO member);
	public int insertMember(MemberVO member);
	public void updateMember(MemberVO member);
	public void deleteMember(String id);
	public void insertMember2(HashMap<String, String> map);

	MemberVO userCheck(MemberVO memberVO);

}
