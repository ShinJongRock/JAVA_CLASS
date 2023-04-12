<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2> include 지시어</h2>
<HR>

<%@ include file ="test_1.jsp" %>
<p>
<br>
<table>
	<tr>
		<td><%@ include file ="test_2.jsp" %></td>
		<td><%@ include file ="test_3.jsp" %></td>
		<td><%@ include file ="NewFile.jsp" %></td>
		
	</tr>
</table>
</body>
</html>