<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적관리 시스템 성적입력 페이지</title>
</head>
<body>
<form name="sungjuk_input" action="./inputprocess.me" method="post">
<center>
<table border=1>
	<tr>
		<td colspan="2" align=center>
			<b> <font=5>성적입력 페이지</font></b>
			</td>
			</tr>
			<tr><td>학번: </td><td><input type="text" name="hakbun"/></td></tr>		
			<tr><td>이름: </td><td><input type="text" name="irum"/></td></tr>
			<tr><td> 국어:</td>   <td> <input type="text" name="kor"/>   </td></tr>
	         <tr><td> 영어:</td>   <td>  <input type="text" name="eng"/>  </td></tr>
	          <tr><td> 수학:</td>   <td>  <input type="text" name="math"/>  </td></tr>
   			<!--  	<tr><td> 총점:</td>   <td>  <input type="text" name="tot"/>  </td></tr>
                 <tr><td> 평균:</td>   <td>  <input type="text" name="avg"/>  </td></tr>
                   <tr><td> 등급:</td>   <td>  <input type="text" name="grade"/>  </td></tr>			-->
	
				<tr>
					<td colspan="2" align=center>
					<a href="javascript:sungjuk_input.submit()">성적입력</a>&nbsp;&nbsp;
					 <a href="javascript:sungjuk_input.reset()">다시작성</a>
				</td>
				</tr>					
</table>
</center>
</body>