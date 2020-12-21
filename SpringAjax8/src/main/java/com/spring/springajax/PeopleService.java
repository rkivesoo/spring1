package com.spring.springajax;

import java.util.List;




public interface PeopleService {
	List<PeopleVO> getPeoplejson(); //데이터 여러개 받을 수 있도록
	void insertPeople(PeopleVO vo); //더 안 쓸 거라 void로 전환.
	void deletePeople(String id);
	void updatePeople(PeopleVO vo);

}
