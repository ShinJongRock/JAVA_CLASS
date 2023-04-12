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

<form>
	<select name= "sel">
		<option>-</option>
		<option>a</option>
		<option>b</option>
		<option>c</option>
		<option>d</option>
		
	</select>
	<input type=submit value="선택">
</form>

<c:choose>
	<c:when test = "${param.sel == 'a' }">
		a를선택
	</c:when>
	<c:when test = "${param.sel == 'b' }">
		b를선택
	</c:when>
	<c:when test = "${param.sel == 'c' }">
		c를선택
	</c:when>
	<c:otherwise>
	
		a,b,c의외의 것을 선택
	</c:otherwise>
	
</c:choose>

</body>
</html>