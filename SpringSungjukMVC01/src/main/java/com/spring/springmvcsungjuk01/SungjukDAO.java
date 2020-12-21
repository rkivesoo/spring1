package com.spring.springmvcsungjuk01;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;


@Repository
public class SungjukDAO {
	private Connection conn= null;
	private PreparedStatement pstmt= null;
	private ResultSet rs= null;
	
	public int insertSungjuk(SungjukVO sungjukVO)
	{
	int result=0;
	
	try 
	{
		conn= JDBCUtil.getConnection();
		
		pstmt=conn.prepareStatement(
				"insert into sungjuk values(?,?,?,?,?,?,?,?)");
		pstmt.setString(1, sungjukVO.getHakbun());
		pstmt.setString(2, sungjukVO.getIrum());
		pstmt.setInt(3, sungjukVO.getKor());
		pstmt.setInt(4, sungjukVO.getEng());
		pstmt.setInt(5, sungjukVO.getMath());
		pstmt.setInt(6, sungjukVO.getTot());
		pstmt.setDouble(7, sungjukVO.getAvg());
		pstmt.setString(8, sungjukVO.getGrade());
		
		result=pstmt.executeUpdate();
	}
	catch(Exception ex)
	{
		System.out.println("���Կ���"+ex.getMessage());
		ex.printStackTrace();
	}
	finally
	{
		JDBCUtil.closeResource(pstmt, conn);
	}
	return result;
}
	//���� 
	public int modifySungjuk(SungjukVO sungjukVO)//modifyMember
	{
	int result=0;
	
	try 
	{
		conn= JDBCUtil.getConnection();
		
		pstmt=conn.prepareStatement(
				"Update sungjuk set irum=?, kor=?, eng=?, math=?,tot=?,avg=?,grade=?  WHERE hakbun=?");
		pstmt.setString(8, sungjukVO.getHakbun());
		pstmt.setString(1, sungjukVO.getIrum());
		pstmt.setInt(2, sungjukVO.getKor());
		pstmt.setInt(3, sungjukVO.getEng());
		pstmt.setInt(4, sungjukVO.getMath());
		pstmt.setInt(5, sungjukVO.getTot());
		pstmt.setDouble(6, sungjukVO.getAvg());
		pstmt.setString(7, sungjukVO.getGrade());
		
		result=pstmt.executeUpdate();
	}
	catch(Exception ex)
	{
		System.out.println("��������"+ex.getMessage());
		ex.printStackTrace();
	}
	finally
	{
		JDBCUtil.closeResource(pstmt, conn);
	}
	return result;
}

	/*
//�����Ϸ�//�̱���� ���� ����...
	public int userCheck(SungjukVO sungjukVO)
	{
		String dbpasswd="";
		int x = -1;
		try
		{
		conn=JDBCUtil.getConnection();	
		
		pstmt=conn.prepareStatement("select*from smember where id=?");
		pstmt.setString(1, sungjukVO.getHakbun());
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			dbpasswd=rs.getString("password");
			if(dbpasswd.equals(sungjukVO.getPassword()))
				x=1; //�����ġ
			else
				x=0;//��� ����ġ
	}
	else 
		x=-1; //���̵� ����ġ
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	finally
	{
		JDBCUtil.closeResource(rs,pstmt,conn);
	}
	return x;
	}
*/
	
	
	//
	//��ȸ
	public ArrayList<SungjukVO> getSungjuklist()
	{
		SungjukVO vo=null;
		ArrayList<SungjukVO> sungjuk_list=null;
		
		try {
			conn= JDBCUtil.getConnection();
			
			pstmt= conn.prepareStatement("select * from sungjuk order by id");
			rs=pstmt.executeQuery();
			
			if (rs.next())
			{
				sungjuk_list=new ArrayList<SungjukVO>();
				do
				{
					vo=new SungjukVO();
					//vo.setId(rs.getString("id"));
					vo.setHakbun(rs.getString("hakbun"));
					//vo.setPassword(rs.getString("password"));
					//vo.setName(rs.getString("name"));
					vo.setIrum(rs.getString("irum"));
					vo.setKor(rs.getInt("kor"));
					vo.setEng(rs.getInt("eng"));
					vo.setMath(rs.getInt("math"));
					vo.setTot(rs.getInt("tot"));
					vo.setAvg(rs.getDouble("avg"));
					vo.setGrade(rs.getString("grade"));
					//vo.setAge(rs.getInt("age"));
					//vo.setGender(rs.getString("gender"));
					//vo.setEmail(rs.getString("email"));
					
					sungjuk_list.add(vo);
				}while(rs.next());
				
			}
		}
	catch(Exception ex)
		{
		ex.printStackTrace();
		}
		finally
		{
			JDBCUtil.closeResource(rs,pstmt,conn);
		}
		return sungjuk_list;
	}
	//���̵� �˻�
	public SungjukVO selectSungjuk(SungjukVO sungjukVO)
	{
		SungjukVO vo=null;
		
		try {
			conn=JDBCUtil.getConnection();
			
			pstmt=conn.prepareStatement("select * from sungjuk where hakbun=?");
			pstmt.setString(1,  sungjukVO.getHakbun());
			rs=pstmt.executeQuery();
			rs.next();
			
			vo=new SungjukVO();
			//vo.setId(rs.getString("id"));
			vo.setHakbun(rs.getString("hakbun"));
			//vo.setPassword(rs.getString("password"));
			//vo.setName(rs.getString("name"));
			vo.setIrum(rs.getString("irum"));
			vo.setKor(rs.getInt("kor"));
			vo.setEng(rs.getInt("eng"));
			vo.setMath(rs.getInt("math"));
			vo.setTot(rs.getInt("tot"));
			vo.setAvg(rs.getDouble("avg"));
			vo.setGrade(rs.getString("grade"));
			//vo.setAge(rs.getInt("age"));
			//vo.setGender(rs.getString("gender"));
			//vo.setEmail(rs.getString("email"));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			JDBCUtil.closeResource(rs, pstmt, conn);
		}
		return vo;
	}
	//���� 

	
	
	
	
	
	//��ȸ
		public ArrayList<SungjukVO> modifySungjuklist()
		{
			SungjukVO vo=null;
			ArrayList<SungjukVO> sungjuk_list=null;
			
			try {
				conn= JDBCUtil.getConnection();
				
				pstmt= conn.prepareStatement("SELECT * FROM sungjuk WHERE hakbun=?"  );
				rs=pstmt.executeQuery();
				
				if (rs.next())
				{
					sungjuk_list=new ArrayList<SungjukVO>();
					do
					{
						vo=new SungjukVO();
						//vo.setId(rs.getString("id"));
						//vo.setId(rs.getString("id"));
						vo.setHakbun(rs.getString("hakbun"));
						//vo.setPassword(rs.getString("password"));
						//vo.setName(rs.getString("name"));
						vo.setIrum(rs.getString("irum"));
						vo.setKor(rs.getInt("kor"));
						vo.setEng(rs.getInt("eng"));
						vo.setMath(rs.getInt("math"));
						vo.setTot(rs.getInt("tot"));
						vo.setAvg(rs.getDouble("avg"));
						vo.setGrade(rs.getString("grade"));
						//vo.setAge(rs.getInt("age"));
						//vo.setGender(rs.getString("gender"));
						//vo.setEmail(rs.getString("email"));					
						
						sungjuk_list.add(vo);
					}while(rs.next());
					
				}
			}
		catch(Exception ex)
			{
			ex.printStackTrace();
			}
			finally
			{
				JDBCUtil.closeResource(rs,pstmt,conn);
			}
			return sungjuk_list;
		}
	
	
	//����
	public int deleteSungjuk(SungjukVO sungjukVO)
	{
		int result = 0;
		
		try {
			conn=JDBCUtil.getConnection();
			pstmt=conn.prepareStatement("delete from sungjuk where hakbun=?");
			pstmt.setString(1, sungjukVO.getHakbun());
			result=pstmt.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			JDBCUtil.closeResource(pstmt, conn);
		}
		return result;
	}

	}

