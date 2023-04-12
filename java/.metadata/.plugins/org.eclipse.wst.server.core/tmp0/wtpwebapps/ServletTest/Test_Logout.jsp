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
<h1>구매내역</h1>
<hr>
<script>
<%
	session.invalidate();
%>
alert('로그아웃되었습니다');
document.location.href="TextLogin.jsp";
</script>

</body>
</html>