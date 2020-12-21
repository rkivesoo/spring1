<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="java.sql.*" %>
  <%@page import="javax.sql.*" %>
  <%@page import="javax.naming.*" %>
    <%@page import="java.util.*" %>
  <%@page import="com.spring.springmvcsungjuk01.SungjukVO" %>
  
  <%
  String hakbun=null; 
//로그인 기능 생략.
// if((session.getAttribute("hakbun")==null)  ||
//  	  (!((String)session.getAttribute("hakbun")).equals("admin"))){
//  	out.println("<script>"); 
//  	out.println("location.href='loginform.me'"); //변경
  	
//  	out.println("</script>"); 	    
//  }       



 ArrayList<SungjukVO> sungjuk_list=
(ArrayList<SungjukVO>)request.getAttribute("sungjuk_list");

%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적관리 웹(성적 목록 보기)</title>
</head>
<body>
<form name="sungjuklistform" action="./sungjuklist.me"method="post">
<center>
<table border=1 width=300>
	<tr align=center><td colspan=2>성적목록</td> <td>	<a href="sungjuk_input.me">입력</a></td>
	 			 </tr>
	 			<%
	for(int i=0; i<sungjuk_list.size();i++)
	{ 
		SungjukVO vo=(SungjukVO)sungjuk_list.get(i);
		%>
				<tr align=center>
			<td>
			<a href="sungjuk_info.me?hakbun=<%=vo.getHakbun()%>"> <!-- 링크에 걸리는 파라미터값 -->
			<%=vo.getHakbun()%><!-- 화면에 출력되는 값 -->
			</a>
			</td>
			<td><a href="sungjuk_delete.me?hakbun=<%=vo.getHakbun()%>">삭제</a>
			</td>
			<td><a href="modifyform.me?hakbun=<%=vo.getHakbun()%>">수정</a><!--new one showed up modify -->
			<!-- member_updateform.jsp?id=  --> 
			</td>
			</tr>
			<%
			}
	 			%>
</table>
</center>
</form>
</body>
</html>