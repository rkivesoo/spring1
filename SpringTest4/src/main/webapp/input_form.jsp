<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<form action="input.bo" method="post">
 
<!--   
<form name="input_form" action="input_form.jsp" method="post" >
-->
<table align="center" border="1">
<tr>
	<td width="110">���̵�</td>
	<td width="400">
		<input type="text" name="id" size="30" style="ime-mode:inactive" 
			required placeholder="�ּ�6~�ִ�10, ���ڿ;��ĺ��� ���">
	</td>
</tr>
<tr>
	<td width="110">��й�ȣ</td>
	<td width="400">
		<input type="password" name="pw" size="30" style="ime-mode:inactive"
			placeholder="�ּ�6~�ִ�10, ���ڿ;��ĺ��� ���">
	</td>
</tr>
<tr>
	<td width="110">��й�ȣ Ȯ��</td>
	<td width="400">
		<input type="password" name="pw2" size="30" style="ime-mode:inactive"
			placeholder="�ּ�6~�ִ�10, ���ڿ;��ĺ��� ���">
	</td>
</tr>
<tr>
	<td width="110">�ֹι�ȣ</td>
	<td width="400"><input type="text" name="jumin1" size="6" maxlength="6"> - 
	    <input type="text" name="jumin2" size="7" maxlength="7" 
	    onblur="set_gender();">
	</td>
</tr>
<tr>
	<td width="110">����</td>
	<td width="400"><input type="radio" name="gender" value="����">���� 
		<input type="radio" name="gender" value="����">���� 
	</td>
</tr>
<tr>
	<td>��ȭ��ȣ</td>
	<td><input type="tel" name="tel1" size="3" maxlength="3"> -
		<input type="tel" name="tel2" size="4" maxlength="4"> -
		<input type="tel" name="tel3" size="4" maxlength="4">
	</td>
</tr>
<tr>
	<td width="110">�̸���</td>
	<td width="400"><input type="text" name="email1" size="10" 
		style="ime-mode:inactive"> @ 
	    <select name="email2">
	    	<option value="" >�����ּҼ���</option>
	    	<option value="hanmail.net">hanmail.net
	    	<option value="naver.com">naver.com
	    	<option value="nate.com">nate.com
	    </select>
	</td>
</tr>
<tr>
	<td width="110">���</td>
	<td width="400">
		<input type="checkbox" name="hobby" value="���">��� 
		<input type="checkbox" name="hobby" value="����">���� 
		<input type="checkbox" name="hobby" value="��Ű">��Ű 
		<input type="checkbox" name="hobby" value="����">���� 
		<input type="checkbox" name="hobby" value="��ȭ">��ȭ 
	</td>
</tr>
<tr>
	<td width="110">�ڱ�Ұ�</td>
	<td width="400"><textarea name="intro" rows="5" cols="50" style="ime-mode:active"></textarea></td>
</tr>
<tr>
	<td colspan="2" align="center" width="500">
		 <input type="submit" value="�Է�"> 
		
		<input type="reset" name="reset" value="���">
	</td>
</tr>
</table>
</form>
</body>
</html>