<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<body align="center">
	<h2>영역과 속성 테스트</h2>
	<HR>
	<% 
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	%>
	
	<%= name %> 반갑습니다.
	<%= name %> 아이디는 <%= id %> 입니다.


	<form action="chk.jsp">
		<table border=2>
			<tr>
				<td border=2>Application 영역에 저장할 내용들</td>
			</tr>

			<tr>
				<td>e-mail 주소</td>
				<td><input type="test" name= "email"></td>
			</tr>

			<tr>
				<td>집 주소</td>
				<td><input type="test" name="address" ></td>
			</tr>


			<tr>
				<td>전화번호</td>
				<td><input type="test" name= "tel"></td>
			</tr>
			<td border=2><input type="submit" value="전송"></td>
			<tr>
				<input>
			</tr>
		</table>

	</form>

</body>

</body>
</html>