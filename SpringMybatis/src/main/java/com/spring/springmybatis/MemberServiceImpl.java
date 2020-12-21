package com.spring.springmybatis;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired 
	private SqlSession sqlSession; //의존성 주입 sql세션 객체 만들어서
	
	@Override
	public ArrayList<MemberVO> getMembers(){
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		MemberMapper memberMapper=
				sqlSession.getMapper(MemberMapper.class);
		//getMember()의 메소드명과 mapper.xml의 id는 동일해야 한다.
		memberList=memberMapper.getMembers();
		System.out.println(memberMapper.getCount());
	    //memberList=memverMapper.getmembers("tab_mybatits");
		return memberList;
	}
	
	@Override 
	public void insertMember(MemberVO member) {
		
		MemberMapper memberMapper=
				sqlSession.getMapper(MemberMapper.class);
		int res=memberMapper.insertMember(member);
		System.out.println("res"+ res);
		
	}
	
	@Override
	public void insertMember2(HashMap <String, String> map) {
		System.out.println("hashmap");
		MemberMapper memberMapper= 
				sqlSession.getMapper(MemberMapper.class);
		memberMapper.insertMember2(map);
	}
	@Override
	public MemberVO getMember(String id) {
		MemberVO member= new MemberVO();
		HashMap<String, String> vo =new HashMap<String, String>(); // ha~~
		MemberMapper memberMapper=
				sqlSession.getMapper(MemberMapper.class);
		//member=memberMapper.getMember(id);
		vo=memberMapper.getMember(id); //hashmap이용시 ....
		System.out.println("vo.id="+vo.get("id"));
		member.setId(vo.get("id"));
		member.setName(vo.get("name"));
		member.setEmail(vo.get("email"));
		member.setPhone(vo.get("phone"));
		
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

}
