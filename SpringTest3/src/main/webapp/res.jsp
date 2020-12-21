<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
id: ${id}<br>
pw: ${pw}<br><br>

id: <%=request.getAttribute("id") %><br>
pw: <%=request.getAttribute("pw") %><br>

</body>
</html>