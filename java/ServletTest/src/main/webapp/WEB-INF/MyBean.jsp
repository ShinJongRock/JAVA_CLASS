<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <jsp:useBean id="Bean_test" class="test.Bean_test" scop="page"/>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<b>�ڹٹ� ��뿹��</b>
<h3><%=Bean_test.getName() %></h3>


<%--�ڹٹ� ��ü�� ��� ������ ���� �ϴ� ���� �ƴ϶� gertterȣ�� --%>
<%-- <h3><jsp:getProperty neam="beabtest" pepperty="naem/></h3> --%>

</body>
</html>