package com.spring.springmember;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")//괄호안의 단어 는 생성된 객체의 이름을 의미 한다. 이름을 지정해주지 않으면 첫글자가 소문자로 변해서 이름이 지정이 된다. 서버에서 bean객체 만들어 질때 저 이름으로 만들어 진다. 
public class MemberServiceImpl implements MemberService {

	@Autowired(required=false) // 자주 보게 될것. @Autowired(required;
	private MemberDAO memberDAO=null;
	
	
	
	@Override
	public int insertMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		int res=memberDAO.insertMember(memberVO);
		return res;
	}

	@Override
	public int userCheck(MemberVO memberVO) {
		// TODO Auto-generated method stub
		int res=memberDAO.userCheck(memberVO);
				return res;
	}
	
	@Override
	public ArrayList<MemberVO> getMemberlist() {
		// TODO Auto-generated method stub
		ArrayList<MemberVO> member_list=new ArrayList<MemberVO>();
		member_list=memberDAO.getMemberlist();
		return member_list;
	}
    //바로 아래 부분 정의 맞는지 확인 할 것. #확인하기. 
	@Override
	public MemberVO selectMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		MemberVO vo=memberDAO.selectMember(memberVO);
		return vo;
	}

	@Override
	public int deleteMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		int res=memberDAO.deleteMember(memberVO);
		return res;
	}


	@Override
	public int modifyMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		int res=memberDAO.modifyMember(memberVO);
		return res;
	}
	




}
