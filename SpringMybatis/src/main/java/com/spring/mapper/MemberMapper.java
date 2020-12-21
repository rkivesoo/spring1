package com.spring.mapper;
import java.util.ArrayList;
import java.util.HashMap;

import com.spring.springmybatis.MemberVO;

public interface MemberMapper {
	
	ArrayList<MemberVO> getMembers(); //������ ��  
	//ArrayList<MemberVo> getMembers(String t);
	//MemberVo getMember(String id); //�ϳ��� �� ���� 
	HashMap<String, String> getMember(String id);
	//������ ������ ��� ���� ��ȯ�ϱ� ���� ��ȯ ���� int�� ������.
	int insertMember(MemberVO member);//int ���� ���� ���ڴٰ� 
	void insertMember2(HashMap<String, String>map);//void���� ���� ���� ���� �ʰڴٰ�
	void updateMember(MemberVO member);
	void deleteMember(String id);
	int getCount();
	

}
