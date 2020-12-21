<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.sql.*" %>
  <%@page import="javax.sql.*" %>
  <%@page import="javax.naming.*" %>
  <%
  request.setCharacterEncoding("utf-8");
  String hakbun=request.getParameter("hakbun");
  String irum=request.getParameter("irum");
  int kor=Integer.parseInt(request.getParameter("kor"));
  int eng=Integer.parseInt(request.getParameter("eng"));
  int math=Integer.parseInt(request.getParameter("math"));
  
 
  int tot;

double avg;

  String grade;
  
  Connection conn=null;
  PreparedStatement pstmt=null;
  ResultSet rs=null;
  
try{
	Context init=new InitialContext();
	DataSource de=(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
	conn=de.getConnection();
	
	tot = kor + eng + math;
	 avg = tot / 3;
	
	switch ((int)(avg/10)) {
		case 10:
		case 9:
			grade = "수";
			break;
		case 8:
			grade = "우";
			break;
		case 7:
			grade = "미";
			break;
		case 6:
			grade = "양";
			break;
		default:
			grade = "가";
			break;
	}	
	
	String sql="Insert Into sungjuk (hakbun, irum,kor,eng,math,"
			+ "tot,avg,grade) Values(?,?,?,?,?,?,?,?)";
	
	pstmt=conn.prepareStatement(sql);
			
		pstmt.setString(1, hakbun);
		pstmt.setString(2, irum);				
		pstmt.setInt(3, kor);
		pstmt.setInt(4, eng);
		pstmt.setInt(5, math);
		pstmt.setInt(6, tot);
		pstmt.setDouble(7, avg);
		pstmt.setString(8, grade);
	    		
		int result=pstmt.executeUpdate();
		
		
	    if(result!=0){
	    	out.println("<script>"); 
	    	out.println("location.href='sungjuk_list.jsp'");
	    	out.println("</script>"); 	  
	    }else{
	    	out.println("<script>"); 
	    	out.println("location.href='sungjuk_list.jsp'");
	    	out.println("</script>"); 	  		    	
	    }
	     	   		    
}catch(Exception e){		
	e.printStackTrace();
}  
  %>