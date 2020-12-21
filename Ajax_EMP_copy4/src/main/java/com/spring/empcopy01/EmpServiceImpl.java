package com.spring.empcopy01;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.EmpMapper;

@Service("empService")
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private SqlSession sqlSession;



	@Override
	//public List<EmpVO> getEmpEx() {//getEmpdata
		public List<EmpVO> getEmpdata() {	
		// TODO Auto-generated method stub
		List<EmpVO> empList=null;
		EmpMapper empMapper=sqlSession.getMapper(EmpMapper.class);
		//empList=empMapper.getEmpEx();
		empList=empMapper.getEmpdata();
		return empList;
	}



	
}
