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
jumin1: ${jumin1}<br>
jumin2: ${jumin2}<br><br>
gender: ${gender}<br>
tel1: ${tel1}<br><br>
tel2: ${tel2}<br>
tel3: ${tel3}<br><br>
email1: ${email1}<br>
email2: ${email2}<br><br>
hobby: ${hobby}<br>
intro: ${intro}<br><br>


id: <%=request.getAttribute("id") %><br>
pw: <%=request.getAttribute("pw") %><br>
jumin1: <%=request.getAttribute("jumin1") %><br>
jumin2: <%=request.getAttribute("jumin2") %><br>
gender: <%=request.getAttribute("gender") %><br>
tel1: <%=request.getAttribute("tel1") %><br>
tel2: <%=request.getAttribute("tel2") %><br>
tel3: <%=request.getAttribute("tel3") %><br>
email1: <%=request.getAttribute("email1") %><br>
email2: <%=request.getAttribute("email2") %><br>
hobby: <%=request.getAttribute("hobby") %><br>
intro: <%=request.getAttribute("intro") %><br>

</body>
</html>