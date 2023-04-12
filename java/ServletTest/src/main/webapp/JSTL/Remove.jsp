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
<h3> c:remove</h3>

<c:set value="batman" var="msg"/>

msg : <c:out value="${msg }"/> <br>
msg : ${msg }

<c:remove var="msg"/>

agter remove : <c:out value= "${msg }"/>



</body>
</html>