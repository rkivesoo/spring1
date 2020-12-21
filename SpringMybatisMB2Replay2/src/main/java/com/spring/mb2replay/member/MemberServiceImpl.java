package com.spring.mb2replay.member;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.BoardMapper;
import com.spring.mapper.MemberMapper;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private SqlSession sqlSession;//mybatis(ibatis)라이브러리가 제공하는 클래스 


	@Override
	public int insertMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		MemberMapper memberMapper=sqlSession.getMapper(MemberMapper.class);
		//memberMapper.boardInsert(board);
		int res = memberMapper.insertMember(memberVO);
		System.out.println("res="+res);
		return res;			
	}

	@Override
	public int userCheck(MemberVO memberVO) {
		// TODO Auto-generated method stub
		MemberMapper memberMapper=sqlSession.getMapper(MemberMapper.class);
		int res = memberMapper.userCheck(memberVO);
		return res ;
	}

	@Override
	public ArrayList<MemberVO> getMemberlist() {
		// TODO Auto-generated method stub
		MemberMapper memberMapper=sqlSession.getMapper(MemberMapper.class);
		ArrayList<MemberVO> member_list=new ArrayList<MemberVO>();
		member_list=memberMapper.getMemberlist();		
		return member_list;
	}

	@Override
	public MemberVO selectMember(MemberVO memberVO) {
		// TODO sqlSession객체 이용 객체 생성 
		MemberMapper memberMapper=sqlSession.getMapper(MemberMapper.class);
		MemberVO vo=memberMapper.selectMember(memberVO);
		
		return vo;
	}

	
	@Override
	public int deleteMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		MemberMapper memberMapper=sqlSession.getMapper(MemberMapper.class);
		int res=memberMapper.deleteMember(memberVO);
		return res;
	}

}
