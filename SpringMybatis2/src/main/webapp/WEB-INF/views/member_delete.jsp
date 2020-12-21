<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="java.sql.*" %>
  <%@page import="javax.sql.*" %>
  <%@page import="javax.naming.*" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*,com.spring.springmybatis.*" %>
  <%
  String id=null; 
//로그인 한 상태에서 admin(id가)일경우만 접근이 가능해야 한다. 
  if((session.getAttribute("id")==null)  ||
  	  (!((String)session.getAttribute("id")).equals("admin"))){
  	out.println("<script>"); 
  	out.println("location.href='loginForm.jsp'");
  	out.println("</script>"); 	    
  }       	
	String delete_id=request.getParameter("id");
	
	  Connection conn=null;
	  PreparedStatement pstmt=null;
	  ResultSet rs=null;	  
	//-----------------------------------------------------------------------------------
	  try{//연결 객체 할당 받는 작업
		Context init=new InitialContext();
		DataSource ds=
				(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn=ds.getConnection();		
		
		pstmt=conn.prepareStatement("DELETE  FROM member WHERE id=?");		
    	pstmt.setString(1,delete_id);
    	pstmt.executeQuery();	   	     	

    	out.println("<script>"); 
    	out.println("location.href='member_list.jsp'");
    	out.println("</script>"); 	     	

}catch(Exception e){		
e.printStackTrace();
}  
%>
