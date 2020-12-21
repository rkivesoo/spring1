<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="java.sql.*" %>
  <%@page import="javax.sql.*" %>
  <%@page import="javax.naming.*" %>
  <%
  String hakbun=null; 

   	
	String delete_hakbun=request.getParameter("hakbun");
	
	  Connection conn=null;
	  PreparedStatement pstmt=null;
	  ResultSet rs=null;	  

	  try{//연결 객체 할당 받는 작업
		Context init=new InitialContext();
		DataSource ds=
				(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn=ds.getConnection();		
		
		pstmt=conn.prepareStatement("DELETE  FROM  mvc_sungjuk WHERE hakbun=?");		
    	pstmt.setString(1,delete_hakbun);
    	pstmt.executeQuery();	   	     	

    	out.println("<script>"); 
    	out.println("location.href='sungjuk_list.jsp'");
    	out.println("</script>"); 	     	

}catch(Exception e){		
e.printStackTrace();
}  
%>