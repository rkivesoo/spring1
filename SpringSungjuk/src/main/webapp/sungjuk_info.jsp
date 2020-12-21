<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.sql.*" %>
  <%@page import="javax.sql.*" %>
  <%@page import="javax.naming.*" %>
  <%
  String hakbun=null; 
//로그인 생략
    	
	String info_hakbun=request.getParameter("hakbun");
	
	  Connection conn=null;
	  PreparedStatement pstmt=null;
	  ResultSet rs=null;	  
	//-----------------------------------------------------------------------------------
	  try{//연결 객체 할당 받는 작업
		Context init=new InitialContext();
		DataSource ds=
				(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn=ds.getConnection();		
		
		pstmt=conn.prepareStatement("SELECT * FROM sungjuk WHERE HAKBUN=?");		
    	pstmt.setString(1,info_hakbun);		
		rs=pstmt.executeQuery();		//
		rs.next();
}catch(Exception e){		
	e.printStackTrace();
}  
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적관리 시스템(성적 정보 보기)</title>
</head>
<body>
<center>
<table border=1 width=300>
	<tr align=center><td>학번:</td>   <td>  <%=rs.getString("HAKBUN") %>  </td></tr><!-- 읽어온 내용을 차례대로 출력하는 작업 -->
	<tr align=center><td>이름:</td>   <td>  <%=rs.getString("IRUM") %>  </td></tr>
	<tr align=center><td> 국어:</td>   <td>  <%=rs.getInt("KOR") %>  </td></tr>
	<tr align=center><td> 영어:</td>   <td>  <%=rs.getInt("ENG") %>  </td></tr>
	<tr align=center><td> 수학:</td>   <td>  <%=rs.getInt("MATH") %>  </td></tr>
	<tr align=center><td> 총점:</td>   <td>  <%=rs.getInt("TOT") %>  </td></tr>
	<tr align=center><td> 평균:</td>   <td>  <%=rs.getDouble("AVG") %>  </td></tr>
	<tr align=center><td>등급:</td>   <td>  <%=rs.getString("GRADE") %>  </td></tr>
	<tr align=center>
	<td colspan=2><a href="sungjuk_list.jsp">리스트로 돌아가기</a></td>
	</tr>
</table>
</center>
</body>
</html>

