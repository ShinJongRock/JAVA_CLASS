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
	<h2>������ �Ӽ� �׽�Ʈ</h2>
	<HR>
	<% 
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	%>
	
	<%= name %> �ݰ����ϴ�.
	<%= name %> ���̵�� <%= id %> �Դϴ�.


	<form action="chk.jsp">
		<table border=2>
			<tr>
				<td border=2>Application ������ ������ �����</td>
			</tr>

			<tr>
				<td>e-mail �ּ�</td>
				<td><input type="test" name= "email"></td>
			</tr>

			<tr>
				<td>�� �ּ�</td>
				<td><input type="test" name="address" ></td>
			</tr>


			<tr>
				<td>��ȭ��ȣ</td>
				<td><input type="test" name= "tel"></td>
			</tr>
			<td border=2><input type="submit" value="����"></td>
			<tr>
				<input>
			</tr>
		</table>

	</form>

</body>

</body>
</html>