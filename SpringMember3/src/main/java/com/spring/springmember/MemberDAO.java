package com.spring.springmember;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class  MemberDAO {
	private Connection conn= null;
	private PreparedStatement pstmt= null;
	private ResultSet rs= null;
	
	public int insertMember(MemberVO memberVO)
	{
	int result=0;
	
	try 
	{
		conn= JDBCUtil.getConnection();
		
		pstmt=conn.prepareStatement(
				"insert into smember values(?,?,?,?,?,?)");
		pstmt.setString(1, memberVO.getId());
		pstmt.setString(2, memberVO.getPassword());
		pstmt.setString(3, memberVO.getName());
		pstmt.setInt(4, memberVO.getAge());
		pstmt.setString(5, memberVO.getGender());
		pstmt.setString(6, memberVO.getEmail());
		result=pstmt.executeUpdate();
	}
	catch(Exception ex)
	{
		System.out.println("가입오류"+ex.getMessage());
		ex.printStackTrace();
	}
	finally
	{
		JDBCUtil.closeResource(pstmt, conn);
	}
	return result;
}
	//수정 
	public int modifyMember(MemberVO memberVO)//modifyMember
	{
	int result=0;
	
	try 
	{
		conn= JDBCUtil.getConnection();
		
		pstmt=conn.prepareStatement(
				"Update smember set password=?, name=?, age=?, gender=?, email=?  WHERE id=?");
		pstmt.setString(6, memberVO.getId());
		pstmt.setString(1, memberVO.getPassword());
		pstmt.setString(2, memberVO.getName());
		pstmt.setInt(3, memberVO.getAge());
		pstmt.setString(4, memberVO.getGender());
		pstmt.setString(5, memberVO.getEmail());
		result=pstmt.executeUpdate();
	}
	catch(Exception ex)
	{
		System.out.println("수정오류"+ex.getMessage());
		ex.printStackTrace();
	}
	finally
	{
		JDBCUtil.closeResource(pstmt, conn);
	}
	return result;
}

	
//수정완료
	public int userCheck(MemberVO memberVO)
	{
		String dbpasswd="";
		int x = -1;
		try
		{
		conn=JDBCUtil.getConnection();	
		
		pstmt=conn.prepareStatement("select*from smember where id=?");
		pstmt.setString(1, memberVO.getId());
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			dbpasswd=rs.getString("password");
			if(dbpasswd.equals(memberVO.getPassword()))
				x=1; //비번일치
			else
				x=0;//비번 불일치
	}
	else 
		x=-1; //아이디 불일치
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
	//조회
	public ArrayList<MemberVO> getMemberlist()
	{
		MemberVO vo=null;
		ArrayList<MemberVO> member_list=null;
		
		try {
			conn= JDBCUtil.getConnection();
			
			pstmt= conn.prepareStatement("select * from smember order by id");
			rs=pstmt.executeQuery();
			
			if (rs.next())
			{
				member_list=new ArrayList<MemberVO>();
				do
				{
					vo=new MemberVO();
					vo.setId(rs.getString("id"));
					vo.setPassword(rs.getString("password"));
					vo.setName(rs.getString("name"));
					vo.setAge(rs.getInt("age"));
					vo.setGender(rs.getString("gender"));
					vo.setEmail(rs.getString("email"));
					
					member_list.add(vo);
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
		return member_list;
	}
	//아이디 검색
	public MemberVO selectMember(MemberVO memberVO)
	{
		MemberVO vo=null;
		
		try {
			conn=JDBCUtil.getConnection();
			
			pstmt=conn.prepareStatement("select * from smember where id=?");
			pstmt.setString(1,  memberVO.getId());
			rs=pstmt.executeQuery();
			rs.next();
			
			vo=new MemberVO();
			vo.setId(rs.getString("id"));
			vo.setPassword(rs.getString("password"));
			vo.setName(rs.getString("name"));
			vo.setAge(rs.getInt("age"));
			vo.setGender(rs.getString("gender"));
			vo.setEmail(rs.getString("email"));
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
	//수정 

	
	
	
	
	
	//조회
		public ArrayList<MemberVO> modifyMemberlist()
		{
			MemberVO vo=null;
			ArrayList<MemberVO> member_list=null;
			
			try {
				conn= JDBCUtil.getConnection();
				
				pstmt= conn.prepareStatement("SELECT * FROM smember WHERE id=?"  );
				rs=pstmt.executeQuery();
				
				if (rs.next())
				{
					member_list=new ArrayList<MemberVO>();
					do
					{
						vo=new MemberVO();
						//vo.setId(rs.getString("id"));
						vo.setPassword(rs.getString("password"));
						vo.setName(rs.getString("name"));
						vo.setAge(rs.getInt("age"));
						vo.setGender(rs.getString("gender"));
						vo.setEmail(rs.getString("email"));
						
						member_list.add(vo);
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
			return member_list;
		}
	
	
	//삭제
	public int deleteMember(MemberVO memberVO)
	{
		int result = 0;
		
		try {
			conn=JDBCUtil.getConnection();
			pstmt=conn.prepareStatement("delete from smember where id=?");
			pstmt.setString(1, memberVO.getId());
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
