<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


	<jsp:include page = "test_5.jsp"/>
	
	
	<jsp:include page = "include_2.jsp">
	<jsp:param value="test@test.com" name="email"/>
	<jsp:param value="010-5063-1870" name="tel"/>
	</jsp:include>


</body>
</html>