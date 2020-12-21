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
	private SqlSession sqlSession; //의존성 주입 sql세션 객체 만들어서
	
	@Override
	public ArrayList<MemberVO> getMembers(){
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		MemberMapper memberMapper=
				sqlSession.getMapper(MemberMapper.class);
		//getMember()의 메소드명과 mapper.xml의 id는 동일해야 한다.
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
		vo=memberMapper.getMember(id); //hashmap이용시 ....
		System.out.println("vo.id="+vo.get("id"));
		member.setId(vo.get("id"));
		member.setPassword(vo.get("password"));
		member.setName(vo.get("name"));
		member.setAge(vo.get("age")); m.m parseInt 맞는데 ㅡ.ㅡ ;;;
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

	//로그인 프로세스
	/*
	 사용자가 id, pw 입력
	 id로 select 쿼리 
	 쿼리 결과의 pw와 사용자가 입력한 pw 비교
	 * */
		@Override
	public MemberVO userCheck(MemberVO member) {
		// TODO Auto-generated method stub
			MemberMapper memberMapper=
					sqlSession.getMapper(MemberMapper.class);
			
		MemberVO vo=new MemberVO(); //객체 생성 
		vo = memberMapper.getMember(member);
		
		int res = 0;
		
		System.out.println("vo"+ res);
	    
		return vo;
				
	}
	
}
