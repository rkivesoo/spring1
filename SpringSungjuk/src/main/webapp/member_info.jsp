<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.sql.*" %>
  <%@page import="javax.sql.*" %>
  <%@page import="javax.naming.*" %>
  <%
  //String id=null; 
//로그인 한 상태에서 admin(id가)일경우만 접근이 가능해야 한다. 
  if((session.getAttribute("hakbun")==null)  ||
  	  (!((String)session.getAttribute("hakbun")).equals("admin"))){
  	out.println("<script>"); 
  	out.println("location.href='loginform.me'");
  	out.println("</script>"); 	    
  }       

%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 관리자모드(회원 정보 보기)</title>
</head>
<body>
<center>
<table border=1 width=300>
	<tr align=center><td>아이디:</td>   <td>${memberVO.getHakbun}</td></tr>  	
	<tr align=center><td>비밀번호:</td>  <td>${memberVO.getPassword()}</td></tr> 	
	<tr align=center><td>이름:</td>   <td>${memberVO.getName()}</td></tr>  	
	<tr align=center><td>나이:</td>  <td>${memberVO.getAge()}</td></tr>  	
	<tr align=center><td>성별:</td>  <td>${memberVO.getGender()}</td></tr>  	
	<tr align=center><td>이메일 주소:</td>   <td>${memberVO.getEmail()}</td></tr>  	
	<tr align=center>
	<td colspan=2><a href="memberlist.me">리스트로 돌아가기</a></td>
	</tr>
</table>
</center>
</body>
</html>










