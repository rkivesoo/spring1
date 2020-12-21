<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="java.sql.*" %>
  <%@page import="javax.sql.*" %>
  <%@page import="javax.naming.*" %>
  <%
  String hakbun=null; 
//로그인 기능 생략.
    Connection conn=null;
	  PreparedStatement pstmt=null;
	  ResultSet rs=null;	  
	try{//연결 객체 할당 받는 작업
		Context init=new InitialContext();
		DataSource ds=
				(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn=ds.getConnection();		
		
		pstmt=conn.prepareStatement("SELECT * FROM  mvc_sungjuk");		
    	rs=pstmt.executeQuery();		//결과를 저장하고 순차적으로 화면에 이제 뿌려주면 된다.
    	System.out.print("rs >>>> " + rs);
    	
}catch(Exception e){		
	e.printStackTrace();
}  
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적관리 웹(성적 목록 보기)</title>
</head>
<body>
<center>
<table border=1 width=300>
	<tr align=center><td colspan=2>성적목록</td> <td>	<a href="sungjuk_input.jsp">입력</a></td>
	 			 </tr>
	 			<%while(rs.next()) { %>   <!-- 결과가 참이면 다음행에 접근 -->
				<tr align=center>
			<td>
			<a href="sungjuk_info.jsp?hakbun=<%=rs.getString("HAKBUN") %>"> <!-- 링크에 걸리는 파라미터값 -->
			<%=rs.getString("HAKBUN")  %><!-- 화면에 출력되는 값 -->
			</a>
			</td>
			<td><a href="sungjuk_delete.jsp?hakbun=<%=rs.getString("HAKBUN") %>">삭제</a>
			</td>
			<td><a href="modifyform.jsp?hakbun=<%=rs.getString("HAKBUN") %>">수정</a><!--new one showed up modify -->
			<!-- member_updateform.jsp?id=  --> 
			</td>
			</tr>
			<%} %>
</table>
</center>
</body>
</html>