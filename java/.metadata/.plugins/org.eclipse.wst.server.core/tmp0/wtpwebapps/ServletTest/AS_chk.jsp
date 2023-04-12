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

	<h2>영역 속성 테스트</h2>
	
	<%= session.getAttribute("name") %> 정보가 모두 저장되었습니다.
	
	<a href ="AS_res.jsp">확인 하러가기</a>

</body>
</html>