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
	<h3>c: catch</h3>
	
	
	<c:catch var="errMsg">
		<%=9/0 %>
		</c:catch>
		
		error mssage : ${errMsg}
</body>
</html>