package com.spring.springmybatis;

import java.util.ArrayList;
import java.util.HashMap;

public interface MemberService {
	public ArrayList<MemberVO> getMembers();
	public MemberVO getMember(String id);
	public void insertMember(MemberVO member);
	public void updateMember(MemberVO member);
	public void deleteMember(String id);
	public void insertMember2(HashMap<String, String> map);

}
