<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% 
    String id=null; 
    //로그인 상태를 확인 한다. ; 아니라면 이페이지의 내용을 더 이상 볼 수 없도록 한다. 
    //id가 null과 같지 않다= 정상적 로그인 -> else-> 비정상-> 로그인으로 이동 
   
    if(session.getAttribute("id")!=null){
    	id=(String)session.getAttribute("id");
    }else{
    	out.println("<script>"); 
    	out.println("location.href='loginform.me'");
    	out.println("</script>"); 	    
    }       
    %>    
    
<html>
<head>
<title> 회원관리 시스템 메인 페이지</title>
</head>
<body><!-- id가 admin일때만 관리자 모드로 ...  -->
<h3><%=id %>로 로그인하셨습니다.</h3>
<%if(id.equals("admin")) {%>
<a href="memberlist.me">관리자모드 접속(화면 목록보기)</a>
<%} %>
</body>
</html>