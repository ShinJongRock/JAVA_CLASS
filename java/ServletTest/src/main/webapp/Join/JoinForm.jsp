<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<jsp:useBean id="Bean" class="test.JoinBean" scope="page" />

<body>

	<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String sex = request.getParameter("sex");
	String mail = request.getParameter("mail");
	%>
	
	
 <jsp:setProperty property="*" name="Bean"/>
	


	<table table border = "1" align="center">

	<tr>
		<td>아이디:</td>
		<td><jsp:getProperty name = "Bean" property="id"/></td>
	</tr>
s
	<tr>
		<td>비밀번호:</td>
		<td><jsp:getProperty name = "Bean" property="pwd"/></td>
	</tr>

	<tr>
		<td>이름</td>
		<td><jsp:getProperty name = "Bean" property="name"/></td>
	</tr>

	<tr>
		<td>성별</td>
		<td><jsp:getProperty name = "Bean" property="sex"/></td>
	</tr>

	<tr>
		<td>나이</td>
		<td><jsp:getProperty name = "Bean" property="age"/></td>
	</tr>

	<tr>
		<td>이메일주소</td>
		<td><jsp:getProperty name = "Bean" property="mail"/></td>
	</tr>

	</table>

</body>
</html>