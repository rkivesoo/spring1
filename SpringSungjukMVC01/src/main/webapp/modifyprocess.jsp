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
	DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
	conn=ds.getConnection();
	
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
			
	String sql="Update sungjuk set irum=?, kor=?, eng=?, ";
	sql += "math=?, tot=?, avg=?, grade=?  WHERE hakbun=?";
	
	System.out.println( "sql:   " + sql     );
   
	pstmt=conn.prepareStatement(sql);
	
	pstmt.setString(1, irum);			
	pstmt.setInt(2, kor);
	pstmt.setInt(3, eng);
	pstmt.setInt(4, math);
	pstmt.setInt(5, tot);
	pstmt.setDouble(6, avg);
	pstmt.setString(7, grade);
	pstmt.setString(8, hakbun);

	int result=pstmt.executeUpdate();
	
		System.out.print("result: "+result);//+0
		System.out.println();
		System.out.print("hakbun: "+hakbun);//+
		System.out.println();

	    if(result!=0){//수정이 되면1이 반환. 
	    	out.println("<script>"); 
	    	out.println("alert('수정성공!!!');"); 
	    	out.println("location.href='sungjuk_list.me'");
	    	out.println("</script>"); 	  
	    }else{
	    	out.println("<script>"); 
	    	out.println("alert('수정실패!!!');"); 
	    	out.println("location.href='sungjuk_list.me'");
	    	out.println("</script>"); 	  		    	
	    }
	     	   		    
}catch(Exception e){		
	e.printStackTrace();
}  
  %>
   