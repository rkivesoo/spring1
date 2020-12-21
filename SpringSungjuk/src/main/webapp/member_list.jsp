<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="java.sql.*" %>
  <%@page import="javax.sql.*" %>
  <%@page import="javax.naming.*" %>
  <%@page import="java.util.*" %>
  <%@page import="com.spring.springsungjuk.SungjukVO" %>
  <%
  String id=null; 
//로그인 한 상태에서 admin(id가)일경우만 접근이 가능해야 한다. 
  if((session.getAttribute("hakbun")==null)  ||
  	  (!((String)session.getAttribute("hakbun")).equals("admin"))){
  	out.println("<script>"); 
  	out.println("location.href='loginform.me'"); //변경
  	
  	out.println("</script>"); 	    
  }       


ArrayList<SungjukVO> member_list=
(ArrayList<SungjukVO>)request.getAttribute("member_list");


	
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
</head>
<body>
<center>
<table border=1 width=300>
	<tr align=center><td colspan=3>회원목록</td></tr>
	<%
	for(int i=0; i<member_list.size();i++)
	{ 
		SungjukVO vo=(SungjukVO)member_list.get(i);
		%>
			<tr align=center>
			<td><a href="memberinfo.me?id=<%=vo.getHakbun() %>"><%=vo.getHakbun() %> </a>
			</td>
			
			<td><a href="memberdelete.me?id=<%=vo.getHakbun() %>">삭제</a>
			</td>
			
			<td><a href="modifyform.me?id=<%=vo.getHakbun() %>">수정</a>
			</td>
			</tr>
	<%
	}	
	%>
	
</table>
</center>
</body>
</html>

