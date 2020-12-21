package com.spring.springmvcsungjuk01;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//
import com.spring.springmvcsungjuk01.SungjukDAO;
@Service("sungjukService")
public abstract class SungjukServiceImpl implements SungjukService{

	@Autowired(required=false) // 자주 보게 될것. @Autowired(required;
	private SungjukDAO sungjukDAO=null;
	
	
	
	@Override
	public int insertSungjuk(SungjukVO sungjukVO) {
		// TODO Auto-generated method stub
		int res=sungjukDAO.insertSungjuk(sungjukVO);
		return res;
	}

	@Override
	public int userCheck(SungjukVO sungjukVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<SungjukVO> getSungjuklist() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SungjukVO selectSungjuk(SungjukVO sungjukVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteSungjuk(SungjukVO sungjukVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifySungjuk(SungjukVO sungjukVO) {
		// TODO Auto-generated method stub
		return 0;
	}

}
