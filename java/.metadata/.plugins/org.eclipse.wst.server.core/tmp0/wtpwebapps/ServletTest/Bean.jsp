<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<jsp:useBean id="Bean" class="test.Bean_test" scope="page" />

<%--jsp:useBean id="Bean"= ���̵�� ����� ���ص���  class="test.Bean_test"  = test. �ڹ����ϸ�  scope="page"  = ���������� ���̰� --%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<b>�ڹٹ� ��뿹��</b>
	<h3><%=Bean.getName() %></h3>


	<%--�ڹٹ� ��ü�� ��� ������ ���� �ϴ� ���� �ƴ϶� gertterȣ�� --%>
	<%-- <h3><jsp:getProperty neam="beabtest" pepperty="naem/></h3> --%>

</body>
</html>