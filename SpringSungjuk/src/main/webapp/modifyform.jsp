<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
  <%@page import="javax.sql.*" %>
  <%@page import="javax.naming.*" %>
  <%
  String hakbun=null; 
  //다시 새롭게 만들었음. 202011181500
  	
	String modify_hakbun=request.getParameter("hakbun");
	//String update_id=request.getParameter("id");	
	  Connection conn=null;
	  PreparedStatement pstmt=null;
	  ResultSet rs=null;	  
	//-----------------------------------------------------------------------------------
	  try{//연결 객체 할당 받는 작업
		Context init=new InitialContext();
		DataSource ds=
				(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");//-----------------------------------------
		conn=ds.getConnection();		
		
		pstmt=conn.prepareStatement("SELECT * FROM sungjuk WHERE hakbun=?");		
    	pstmt.setString(1,modify_hakbun);	
    	//pstmt.setString(1,update_id);	
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
<title>성적정보 수정 페이지</title>

</head>
<body>
<form name="modifyform" action="modifyprocess.jsp" method="post">
<!-- <form name="updateform" action="member_update.jsp" method="post"> -->
<center>
<table border=1>
<!-- <table border=1 width=400> -->
	<tr>
		<td colspan="2" align=center>
			<b> <font=5>성적정보 수정 페이지</font></b>
			</td>
			</tr>
			<tr><td>학번: </td><td> <%=rs.getString("hakbun") %>  </td><!-- 아이디는 고정값이어야 -->

			<input type="hidden" name="hakbun" value= <%=rs.getString("hakbun") %>></tr>							
			<tr>
			<td>이름: </td>
			<td><input type="text" name="irum"  value= <%=rs.getString("irum") %>></td>
			</tr>			  
			<tr><td>국어:</td>
			<td><input type="text" name="kor"  value= <%=rs.getInt("kor") %>></td>
			</tr>
			<tr><td>영어:</td>
			<td><input type="text" name="eng"  value= <%=rs.getInt("eng") %>></td>
			</tr>
			<tr><td>수학:</td>
			<td><input type="text" name="math"  value= <%=rs.getInt("math") %>></td>
			</tr>						
					<tr align=center>
					<td colspan="2">
					<a href="javascript:modifyform.submit()">정보수정</a>&nbsp;&nbsp;
					
					 <a href="sungjuk_list.jsp">리스트로 돌아가기</a>
			</td>
			</tr>					
</table>
</center>
</body>
</html>