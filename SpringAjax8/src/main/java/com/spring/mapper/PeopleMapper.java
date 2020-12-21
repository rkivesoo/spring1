package com.spring.mapper;
import java.util.List;

import com.spring.springajax.PeopleVO;

public interface PeopleMapper {
	
	List<PeopleVO> getPeoplelist(); //데이터 여러개 받을 수 있도록
	int insertPeople(PeopleVO vo); //인서트한 삽입한 데이터 받아오고 싶어서 리턴타입 int 반영
	void deletePeople(String id);
	int updatePeople(PeopleVO vo);
}
