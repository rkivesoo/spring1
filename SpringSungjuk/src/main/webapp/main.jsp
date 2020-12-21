<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    <% 
    String id=null; 
    //로그인 상태를 확인 한다. ; 아니라면 이페이지의 내용을 더 이상 볼 수 없도록 한다. 
    //id가 null과 같지 않다= 정상적 로그인 -> else-> 비정상-> 로그인으로 이동 
   
    if(session.getAttribute("hakbun")!=null){
    	id=(String)session.getAttribute("hakbun");
    }else{
    	out.println("<script>"); 
    	out.println("location.href='loginform.me'");
    	out.println("</script>"); 	    
    }       
    %>    
    
<html>
<head>
<title> 관리 시스템 메인 페이지</title>
</head>
<body><!-- id가 admin일때만 관리자 모드로 ...  -->
<h3><%=id %>로 로그인하셨습니다.</h3>
<%if(id.equals("admin")) {%>

<a href="memberlist.me"> 학생 등록 관리 모드 접속(화면 목록보기)</a>
<!-- 추가 부분. 하단.202011271535 -->
<a href="sungjuklist.me">성적 관리 모드 접속(화면 목록보기)</a> <!-- C.S.D+VO 모두 확인   -->
<!-- 추가 주의 사항  
DB테이블이 2개 이고 성적의 경우 기존 스타일과 동일 하고+ 테이블 이름만 새롭다 [ mvc_sungjuk ] 
또하나의 DB는 [mvc_member ] ... 기존의 로그인과 회원 가입시에 사용하던 테이블의 형식을 사용하며 컬럼명 id를 성적테이블의 학번과 같이 hakbun으로 변경함. 
(Soo: 1차 목표는 돌아 가도록, 2차 목표는 중요포인트 클리어하기, 3차 목표는 테이블 구조를 다시 보고 참조키를 활용해보기. Or.... 홈페이지 스프링에서 구현으로 넘어 갈 것. 202011271701
 -->

<%} %>
</body>
</html>