<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<jsp:useBean id="Bean" class="test.JoinBean" scope="page" />
<jsp:setProperty  name="login" property="*"/>


<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="JoinForm.jsp">
	<table border = "1" align="center" >

	<tr border = "1">
		<td>���̵�:</td>
		<td> <input type= "text" name="id"></td>
	</tr>

	<tr border = "1">
		<td>��й�ȣ:</td>
		<td><input type= "text" name="pwd"></td>
	</tr>
	
	<tr border = "1">
		<td>�̸�</td>
		<td><input type= "text" name="repwd"></td>
	</tr>

	<tr border = "1">
		<td>����</td>
		<td><input type= "text" name="age"></td>
	</tr>

	<tr border = "1">
		<td>����</td>
		<td><input type= "text" name="sex"></td>
	</tr>
	
	<tr border = "1">
		<td>�̸����ּ�</td>
		<td><input type= "text" name="mail"></td>
	</tr>
	<tr>
		<td><input type="submit"></td>
	
	</tr>

	</table>
	</form>

</body>
</html>