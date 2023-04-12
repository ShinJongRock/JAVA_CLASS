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
	
	다음은 import 를 이용하여 포함한 것입니다.<hr>
	
	<c:import url="set.jsp" var ="myurl"></c:import>
	<c:out value = "${myurl }" escapeXml="false"/>
	<hr>

</body>
</html>