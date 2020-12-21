package com.spring.springmybatis;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.MemberMapper;
import com.spring.springmybatis.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired 
	private SqlSession sqlSession; //������ ���� sql���� ��ü ����
	
	@Override
	public ArrayList<MemberVO> getMembers(){
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		MemberMapper memberMapper=
				sqlSession.getMapper(MemberMapper.class);
		//getMember()�� �޼ҵ��� mapper.xml�� id�� �����ؾ� �Ѵ�.
		memberList=memberMapper.getMembers();
		System.out.println(memberMapper.getCount());
	    //memberList=memberMapper.getmembers("tab_mybatits");
		return memberList;
	}
	
	@Override 
	public int insertMember(MemberVO member) {
		
		MemberMapper memberMapper=
				sqlSession.getMapper(MemberMapper.class);
		int res=memberMapper.insertMember(member);
		System.out.println("res"+ res);
		return res;
	}
	/*@Override 
	public void insertMember(MemberVO member) {		
		MemberMapper memberMapper=
				sqlSession.getMapper(MemberMapper.class);
		int res=memberMapper.insertMember(member);
		System.out.println("res"+ res);		
	}*/		
	@Override
	public void insertMember2(HashMap <String, String> map) {
		System.out.println("hashmap");
		MemberMapper memberMapper= 
				sqlSession.getMapper(MemberMapper.class);
		memberMapper.insertMember2(map);
	}
	@Override
	public MemberVO getMember(MemberVO member) {
		
		MemberVO vo= new MemberVO();
		
		//HashMap<String, String> vo =new HashMap<String, String>(); // ha~~
		MemberMapper memberMapper=
				sqlSession.getMapper(MemberMapper.class);
		vo=memberMapper.getMember(member);
		/*
		vo=memberMapper.getMember(id); //hashmap�̿�� ....
		System.out.println("vo.id="+vo.get("id"));
		member.setId(vo.get("id"));
		member.setPassword(vo.get("password"));
		member.setName(vo.get("name"));
		member.setAge(vo.get("age")); m.m parseInt �´µ� ��.�� ;;;
		member.setAge(vo.Integer.parseInt("age"));
		member.setGender(vo.get("gender"));
		member.setEmail(vo.get("email"));
		*/
		
		return member;	
		
	}
	
	@Override
	public void updateMember(MemberVO member) {
		MemberMapper memberMapper=
				sqlSession.getMapper(MemberMapper.class);
		memberMapper.updateMember(member);
	}
	
	
	@Override 
	public void deleteMember(String id) { 
		MemberMapper memberMapper=
				sqlSession.getMapper(MemberMapper.class);
		memberMapper.deleteMember(id);
	}

	//�α��� ���μ���
	/*
	 ����ڰ� id, pw �Է�
	 id�� select ���� 
	 ���� ����� pw�� ����ڰ� �Է��� pw ��
	 * */
		@Override
	public MemberVO userCheck(MemberVO member) {
		// TODO Auto-generated method stub
			MemberMapper memberMapper=
					sqlSession.getMapper(MemberMapper.class);
			
		MemberVO vo=new MemberVO(); //��ü ���� 
		vo = memberMapper.getMember(member);
		
		int res = 0;
		
		System.out.println("vo"+ res);
	    
		return vo;
				
	}
	
}
