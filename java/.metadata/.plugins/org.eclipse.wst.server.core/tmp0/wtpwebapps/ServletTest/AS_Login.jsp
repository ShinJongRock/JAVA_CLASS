<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body align="center">
	<h2>영역과 속성 테스트</h2>
	<HR>
	<form action="AS_address.jsp">
	<table border=1>
	<tr>
		<td colspan"2">Application 영역에 저장할 내용들</td>
	</tr>

	<tr>
		<td>이름</td>
		<td><input type="test" name="name"></td>
	</tr>

	<tr>
		<td>아이디</td>
		<td><input type="test" name="id"></td>
			
		</td>
	</tr>
		<td  border=2><input type="submit"  value="전송"></td>
	<tr>
		<input >
	</tr>
	</table>
	
	<!--  %	
	Enumeration e = session.getAtttbuteNames();
	
	
	%>-->
	
</form>

</body>

</html>