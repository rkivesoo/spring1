package com.spring.springmember;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")//��ȣ���� �ܾ� �� ������ ��ü�� �̸��� �ǹ� �Ѵ�. �̸��� ���������� ������ ù���ڰ� �ҹ��ڷ� ���ؼ� �̸��� ������ �ȴ�. �������� bean��ü ����� ���� �� �̸����� ����� ����. 
public class MemberServiceImpl implements MemberService {

	@Autowired(required=false) // ���� ���� �ɰ�. @Autowired(required;
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
    //�ٷ� �Ʒ� �κ� ���� �´��� Ȯ�� �� ��. #Ȯ���ϱ�. 
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
