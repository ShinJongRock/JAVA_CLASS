<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h3> c:ur;</h3>


<c:url value="/JSTL/Choose.jsp" var="target">
	<c:param name = "sel">a</c:param>
</c:url>

<hr>

�ܼ����: ${rarget }<br>
��ũ����: <a href= "${target }"> Choose.jsp</a>
</body>
</html>