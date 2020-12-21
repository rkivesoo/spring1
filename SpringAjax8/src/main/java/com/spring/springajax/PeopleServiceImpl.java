package com.spring.springajax;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.PeopleMapper;

@Service("peopleService")
public class PeopleServiceImpl implements PeopleService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<PeopleVO> getPeoplejson() {
		// TODO Auto-generated method stub
		List<PeopleVO> peopleList = null;
		PeopleMapper memberMapper=
				sqlSession.getMapper(PeopleMapper.class);
		peopleList= memberMapper.getPeoplelist();
		return peopleList;
	}

	@Override
	public void insertPeople(PeopleVO vo) {
		// TODO Auto-generated method stub
		PeopleMapper memberMapper=
				sqlSession.getMapper(PeopleMapper.class);
		memberMapper.insertPeople(vo);
		return;
		}

	@Override
	public void deletePeople(String id) {
		// TODO Auto-generated method stub
		PeopleMapper memberMapper=
				sqlSession.getMapper(PeopleMapper.class);
		memberMapper.deletePeople(id);
		return;
	}

	@Override
	public void updatePeople(PeopleVO vo) {
		// TODO Auto-generated method stub
		PeopleMapper memberMapper=
				sqlSession.getMapper(PeopleMapper.class);
		memberMapper.updatePeople(vo);
		return;
		
	}

}
