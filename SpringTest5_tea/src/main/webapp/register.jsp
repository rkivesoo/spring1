<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ����</title>

<link href="./resources/css/register.css" rel="stylesheet" type="text/css">

</head>
<body>
<form>
<fieldset>
<legend>ȸ�� �⺻ ����</legend>
<ol>
  <li>
    <label for="userid">���̵�</label>
    <input type="text" id="userid" name="userid" required autofocus 
			placeholder="����,���� ���. 10�ڹ̸�">
  </li>
  <li>
    <label for="pwd1">��й�ȣ</label>
    <input type="password" id="pwd1" name="pwd1" required 
			placeholder="����,���� ���. 6~10�ڸ�">
  </li>
  <li>
    <label for="pwd2">��й�ȣ Ȯ��</label>
    <input type="password" id="pwd2" name="pwd2" required>
  </li> 
	
	<li>
    <label for="fullname">�̸�</label>
    <input type="text" id="fullname" name="fullname"  required>
  </li>
	<li>		<label for="age">����</label>
    <input id="age" name="age" type="number" min="1" max="65" step="1">
  </li> 
	<li>
		<label for="birth">����</label>
    <input id="birth" name="birth" type="date">
  </li> 
  <li>
    <label for="email">�̸��� �ּ�</label>
    <input id="email" name="email" type="email" autocomplete="off" 
			placeholder="zoca01@icore.com" required >
  </li>
  <li>
    <label for="tel">�ڵ���</label>
    <input id="tel" name="tel" type="tel" autocomplete="off">
  </li>
</ol>
</fieldset>

<fieldset>
<legend>ȸ�� �߰� ����</legend>
<ol>
 <li>
    <label for="job">����</label>
    <input list="job" name="job" >
		<datalist id="job">
			<option value="ȸ���">
			<option value="����">
			<option value="���α׷���">
			<option value="�ڿ���">
			<option value="��Ÿ">
		</datalist>
  </li>
  <li>
		<label for="office">���ǽ� Ȱ��</label>
    <input id="office" name="com" type="range" min="1" max="5" step="1">
  </li>  
</ol>
</fieldset>
<fieldset>
  <button type="submit"> �Է� </button> 
</fieldset>
</form>
</body>
</html>
