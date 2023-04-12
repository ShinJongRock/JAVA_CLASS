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


<h3> c:for</h3>

<c:forTokens items="123-123-123" delims="-" var="sel">
	${sel }<br>
	</c:forTokens>

</body>
</html>