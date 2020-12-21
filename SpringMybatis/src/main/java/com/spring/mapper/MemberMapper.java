package com.spring.mapper;
import java.util.ArrayList;
import java.util.HashMap;

import com.spring.springmybatis.MemberVO;

public interface MemberMapper {
	
	ArrayList<MemberVO> getMembers(); //여러개 값  
	//ArrayList<MemberVo> getMembers(String t);
	//MemberVo getMember(String id); //하나의 값 가능 
	HashMap<String, String> getMember(String id);
	//삽입후 삽입한 결과 상태 반환하기 위해 반환 값을 int로 정해줌.
	int insertMember(MemberVO member);//int 값을 가져 오겠다고 
	void insertMember2(HashMap<String, String>map);//void세개 값을 가져 오지 않겠다고
	void updateMember(MemberVO member);
	void deleteMember(String id);
	int getCount();
	

}
