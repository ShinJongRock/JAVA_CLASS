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


<h3> c:if</h3>

<c:set value = "syperman" var ="msg"/>
msg : ${msg } <br>


<c:if test="${msg == '집가고싶다' }" var = "result">
	test result : ${result }
	</c:if>
</body>
</html>