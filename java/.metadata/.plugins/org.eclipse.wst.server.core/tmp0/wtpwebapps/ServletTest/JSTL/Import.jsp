<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body bgcolor="#FFFFF">

	<h3>c:import</h3>
	
	������ import �� �̿��Ͽ� ������ ���Դϴ�.<hr>
	
	<c:import url="set.jsp" var ="myurl"></c:import>
	<c:out value = "${myurl }" escapeXml="false"/>
	<hr>

</body>
</html>