<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 
<%@ page import="java.util.*" %>
    
 <%
 request.setCharacterEncoding("utf-8");
 ArrayList<String> orgfile_list = (ArrayList<String>)request.getAttribute("orgfile_list");
ArrayList<String> storedfile_list=(ArrayList<String>)request.getAttribute("storedfile_list");
ArrayList<Long> filesize_list=(ArrayList<Long>)request.getAttribute("filesize_list"); 
 %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>home</title>
</head>
<body>
<h1>업로드 완료 </h1>
이름: ${name} <br><br>
<%
for (int i=0;i<orgfile_list.size(); i++){//다운로드 받기 위한 링크를 만들어 주는 과정 
	String downlink = "fileDownload.bo?of="+storedfile_list.get(i)+"&of2=" + orgfile_list.get(i);
	String storedfile=storedfile_list.get(i);
%>
	파일명: <%=orgfile_list.get(i) %><br>
	파일사이즈:<%=filesize_list.get(i) %><br>
	<a href=<%=downlink %> > 다운로드</a><br>
	<img src="/springfileupload1/upload/<%=storedfile_list.get(i) %>"/><!-- 실제 저장된 이미지 로 ~다운 -->
	<br><br>
<%
}
%>
<br>
</body>
</html>