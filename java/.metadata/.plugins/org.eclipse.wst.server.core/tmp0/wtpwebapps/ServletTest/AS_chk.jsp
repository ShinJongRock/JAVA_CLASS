<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h2>���� �Ӽ� �׽�Ʈ</h2>
	
	<%= session.getAttribute("name") %> ������ ��� ����Ǿ����ϴ�.
	
	<a href ="AS_res.jsp">Ȯ�� �Ϸ�����</a>

</body>
</html>