<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
  <%@page import="javax.sql.*" %>
  <%@page import="javax.naming.*" %>
   <%@page import="java.util.*" %>
  <%@page import="com.spring.springmvcsungjuk01.SungjukVO" %>
  <%
  
  String hakbun=null; 
  //다시 새롭게 만들었음. 202011181500
   
  
//로그인 한 상태에서 admin(id가)일경우만 접근이 가능해야 한다. //
 // if((session.getAttribute("hakbun")==null)  ||
 // 	  (!((String)session.getAttribute("hakbun")).equals("admin"))){
 // 	out.println("<script>"); 
//  	out.println("location.href='loginForm.me'");
//  	out.println("</script>"); 	    
//  }       	
   
  SungjukVO vo = (SungjukVO)request.getAttribute("sungjukVO");
 
	
%>      
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적정보 수정 페이지</title>

</head>
<body>
<form name="modifyform" action="./modifyprocess.me" method="post">
<!-- <form name="updateform" action="member_update.jsp" method="post"> -->
<center>
<table border=1>
<!-- <table border=1 width=400> -->
	<tr>
		<td colspan="2" align=center>
			<b> <font=5>성적정보 수정 페이지</font></b>
			</td>
			</tr>
			<tr><td>학번: </td><td> <%=vo.getHakbun()%>  </td><!-- 아이디는 고정값이어야 -->

			<input type="hidden" name="hakbun" value= <%=vo.getHakbun() %>></tr>							
			<tr>
			<td>이름: </td>
			<td><input type="text" name="irum"  value= <%=vo.getIrum() %>></td>
			</tr>			  
			<tr><td>국어:</td>
			<td><input type="text" name="kor"  value= <%=vo.getKor() %>></td>
			</tr>
			<tr><td>영어:</td>
			<td><input type="text" name="eng"  value= <%=vo.getEng() %>></td>
			</tr>
			<tr><td>수학:</td>
			<td><input type="text" name="math"  value= <%=vo.getMath()%>></td>
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