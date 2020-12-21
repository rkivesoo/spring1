<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.sql.*" %>
  <%@page import="javax.sql.*" %>
  <%@page import="javax.naming.*" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*,com.spring.springmybatis.*" %>
  <%
  
  
  request.setCharacterEncoding("utf-8");
  String id=request.getParameter("id");//입력할 데이터를 받아 온다. 
  String pass=request.getParameter("pass");
  String name=request.getParameter("name");
  int age=Integer.parseInt(request.getParameter("age"));
  String gender=request.getParameter("gender");
  String email=request.getParameter("email");
  
  Connection conn=null;
  PreparedStatement pstmt=null;
  ResultSet rs=null;
  
try{
	Context init=new InitialContext();
	DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
	conn=ds.getConnection();
	
	String sql="Update member set password=?, name=?, age=?, ";
	sql += "gender=?, email=?  WHERE id=?";
   
		pstmt=conn.prepareStatement(sql); 
					
		pstmt.setString(1, pass);
		pstmt.setString(2, name);
		
		pstmt.setInt(3, age);
		pstmt.setString(4, gender);
		pstmt.setString(5, email);
		pstmt.setString(6, id); //where 조건식에 들어갈 데이터 
		
		int result=pstmt.executeUpdate();
		
		//점검하는 방법
		System.out.print("result: "+result);//+
		System.out.println();
		System.out.print("Id: "+id);//+
		
	    if(result!=0){//수정이 되면1이 반환. 
	    	out.println("<script>"); 
	    	out.println("alert('수정성공!!!');"); 
	    	out.println("location.href='member_list.jsp'");
	    	out.println("</script>"); 	  
	    }else{
	    	out.println("<script>"); 
	    	out.println("alert('수정실패!!!');"); 
	    	out.println("location.href='member_list.jsp'");
	    	out.println("</script>"); 	  		    	
	    }
	     	   		    
}catch(Exception e){		
	e.printStackTrace();
}  
  %>
   