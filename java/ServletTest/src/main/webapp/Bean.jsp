<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<jsp:useBean id="Bean" class="test.Bean_test" scope="page" />

<%--jsp:useBean id="Bean"= 아이디는 맘대로 정해도됨  class="test.Bean_test"  = test. 자바파일명  scope="page"  = 내패이지에 보이게 --%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<b>자바번 사용예제</b>
	<h3><%=Bean.getName() %></h3>


	<%--자바번 객체의 멤버 변수를 접근 하는 것이 아니라 gertter호출 --%>
	<%-- <h3><jsp:getProperty neam="beabtest" pepperty="naem/></h3> --%>

</body>
</html>