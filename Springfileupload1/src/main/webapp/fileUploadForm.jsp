<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<% request.setCharacterEncoding("utf-8"); %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home</title>
</head>
<body>
<h1>Hello world! File Upload!!</h1>
<form id="multiform" action="fileUpload2.bo" method="post"
	enctype="multipart/form-data"> <!-- =>파일을 업로드 할 때 반드시 필요한 속성 정의enctype="multipart/form-data">  -->
	이름: <input type="text" name="name"/><br/><br/>
	<!-- multiple="multiple":다중파일 업로드를 위해서 사용 -->
	파일: <input type="file" name="file" multiple="miltiple"/></br></br> <!-- 다중업로드 -->
	<input type="button"value="다중업로드1"	onclick="fnAction('fileUpload1.bo')"/>
	<input type="button"value="다중업로드2"	onclick="fnAction('fileUpload2.bo')"/> 
</form>
<script>
	function fnAction(url){//함수 호출을 위해서
		var frm=document.getElementById("multiform");
		frm.action=url;
		frm.submit();
	}
</script>
</body>
</html>