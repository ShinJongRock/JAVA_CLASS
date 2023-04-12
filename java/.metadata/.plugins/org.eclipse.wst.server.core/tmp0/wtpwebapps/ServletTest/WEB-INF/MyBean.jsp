<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <jsp:useBean id="Bean_test" class="test.Bean_test" scop="page"/>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<b>자바번 사용예제</b>
<h3><%=Bean_test.getName() %></h3>


<%--자바번 객체의 멤버 변수를 접근 하는 것이 아니라 gertter호출 --%>
<%-- <h3><jsp:getProperty neam="beabtest" pepperty="naem/></h3> --%>

</body>
</html>