package com.spring.mapper;
import java.util.List;

import com.spring.springajax.PeopleVO;

public interface PeopleMapper {
	
	List<PeopleVO> getPeoplelist(); //������ ������ ���� �� �ֵ���
	int insertPeople(PeopleVO vo); //�μ�Ʈ�� ������ ������ �޾ƿ��� �; ����Ÿ�� int �ݿ�
	void deletePeople(String id);
	int updatePeople(PeopleVO vo);
}
