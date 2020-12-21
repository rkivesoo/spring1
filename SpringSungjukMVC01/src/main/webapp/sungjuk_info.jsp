<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.sql.*" %>
  <%@page import="javax.sql.*" %>
  <%@page import="javax.naming.*" %>
   <%@page import="java.util.*" %>
  <%@page import="com.spring.springmvcsungjuk01.SungjukVO" %>
  <%
  String hakbun=null; 
//로그인 생략

//로그인 한 상태에서 admin(id가)일경우만 접근이 가능해야 한다. 
//  if((session.getAttribute("hakbun")==null)  ||
//  	  (!((String)session.getAttribute("hakbun")).equals("admin"))){
//  	out.println("<script>"); 
//  	out.println("location.href='loginform.me'");
//  	out.println("</script>"); 	    
//  }       

	
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적관리 시스템(성적 정보 보기)조심 조심 값을 끌어 오는 페이지임</title>
</head>
<body>
<!--  <form name="sungjuk_info" action="./sungjukinfo.me"method="post">-->
<center>
<table border=1 width=300>
	<tr align=center><td>학번:</td>   <td>  ${memberVO.getHakbun()}</td></tr><!-- 읽어온 내용을 차례대로 출력하는 작업 -->
	<tr align=center><td>이름:</td>   <td>  ${memberVO.getIrum()} </td></tr>
	<tr align=center><td> 국어:</td>   <td>  ${memberVO.getKor()}  </td></tr>
	<tr align=center><td> 영어:</td>   <td>  ${memberVO.getEng()}  </td></tr>
	<tr align=center><td> 수학:</td>   <td>  ${memberVO.getMath()}  </td></tr>
	<tr align=center><td> 총점:</td>   <td>  ${memberVO.getTot()} </td></tr>
	<tr align=center><td> 평균:</td>   <td>  ${memberVO.getAvg()} </td></tr>
	<tr align=center><td>등급:</td>   <td>  ${memberVO.getGrade()} </td></tr>
	<tr align=center>
	<td colspan=2><a href="sungjuk_list.me">리스트로 돌아가기</a></td>
	</tr>
</table>
</center>
<!--  </form> -->
</body>
</html>

