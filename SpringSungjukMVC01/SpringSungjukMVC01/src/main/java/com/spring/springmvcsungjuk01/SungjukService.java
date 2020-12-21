package com.spring.springmvcsungjuk01;
import java.util.ArrayList;


public interface SungjukService {
	
	public int insertSungjuk(SungjukVO sungjukVO);
	public int userCheck(SungjukVO sungjukVO);
	public ArrayList<SungjukVO> getSungjuklist();
	public SungjukVO selectSungjuk(SungjukVO sungjukVO);
	public int deleteSungjuk(SungjukVO sungjukVO);
	public int modifySungjuk(SungjukVO sungjukVO);
}
