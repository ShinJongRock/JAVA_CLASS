<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body align="center">
<h1>���ų���</h1>
<hr>
<script>
<%
	session.invalidate();
%>
alert('�α׾ƿ��Ǿ����ϴ�');
document.location.href="TextLogin.jsp";
</script>

</body>
</html>