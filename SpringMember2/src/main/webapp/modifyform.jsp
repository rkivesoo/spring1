<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*" %>
  <%@page import="javax.sql.*" %>
  <%@page import="javax.naming.*" %>
    <%@page import="java.util.*" %>
  <%@page import="com.spring.springmember.MemberVO" %>
  <%
  String id=null; 
  
  
//로그인 한 상태에서 admin(id가)일경우만 접근이 가능해야 한다. //
  if((session.getAttribute("id")==null)  ||
  	  (!((String)session.getAttribute("id")).equals("admin"))){
  	out.println("<script>"); 
  	out.println("location.href='loginForm.jsp'");
  	out.println("</script>"); 	    
  }       	
   
  MemberVO vo = (MemberVO)request.getAttribute("memberVO");

%>  
     
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 회원정보 수정 페이지</title>
<!--  -->
</head>
<body>
<form name="modifyform" action="./modifyprocess.me" method="post">
<!-- <form name="updateform" action="member_update.jsp" method="post"> -->
<center>
<table border=1>
<!-- <table border=1 width=400> -->
	<tr>
		<td colspan="2" align=center>
			<b> <font=5>회원정보 수정 페이지</font></b>
			</td>
			</tr>
			<tr><td>아이디: </td><td> <%=vo.getId() %>  </td><!-- 아이디는 고정값이어야 -->
		
			<input type="hidden" name="id" value= <%=vo.getId() %> ></tr>			
								
			<tr>
			<td>비밀번호: </td>
			<td><input type="password"  name="password"
			 value= <%=vo.getPassword() %>></td>
			 </tr> 			
			
			<tr>
			<td>이름: </td>
			<td><input type="text" name="name"  value= <%=vo.getName() %>></td>
			</tr>
			  
			<tr><td>나이:</td>
			<td><input type="text" name="age"  value= <%=vo.getAge() %>></td>
			</tr>
			
			<tr>
				<td>성별: </td>
				<td>
				    <%
				   // if (rs.getString("gender").equals("남") )
				    if(vo.getGender().equals("남"))
				    {
				    	%>
				  <!--  }		  -->	   
				 	    <input type="radio" name="gender" value="남" checked/>남자
						<input type="radio" name="gender" value="여" />여자
						<%
						}
						else
						{
						%>
						<input type="radio" name="gender" value="남" />남자
						<input type="radio" name="gender" value="여" checked />여자
						<%
						}
						%>		
						
		       </td>
				</tr>
				
				<tr>
				<td>이메일주소:</td>
				<td> <input type="text" name="email" size=30  value= <%=vo.getEmail() %>></td>
				</tr> 
				
				
					<tr align=center>
					<td colspan="2">
					<a href="javascript:modifyform.submit()">정보수정</a>&nbsp;&nbsp;
					<!-- <a href="javascript:updateform.submit()">정보수정</a> -->
					 <a href="member_list.jsp">리스트로 돌아가기</a>
				</td>
				</tr>					
</table>
</center>
</body>
</html>