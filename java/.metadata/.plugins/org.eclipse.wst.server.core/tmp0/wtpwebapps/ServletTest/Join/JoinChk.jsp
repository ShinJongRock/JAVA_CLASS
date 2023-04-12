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
		<td>아이디:</td>
		<td> <input type= "text" name="id"></td>
	</tr>

	<tr border = "1">
		<td>비밀번호:</td>
		<td><input type= "text" name="pwd"></td>
	</tr>
	
	<tr border = "1">
		<td>이름</td>
		<td><input type= "text" name="repwd"></td>
	</tr>

	<tr border = "1">
		<td>성별</td>
		<td><input type= "text" name="age"></td>
	</tr>

	<tr border = "1">
		<td>나이</td>
		<td><input type= "text" name="sex"></td>
	</tr>
	
	<tr border = "1">
		<td>이메일주소</td>
		<td><input type= "text" name="mail"></td>
	</tr>
	<tr>
		<td><input type="submit"></td>
	
	</tr>

	</table>
	</form>

</body>
</html>