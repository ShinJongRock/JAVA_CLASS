<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="Eltest" class="test.Eltest" />
<%
   String product = request.getParameter("box");
   int num1 = Eltest.getNum1();
   int num2 = Eltest.getNum2();
   int sum = num1 + num2;
%>

1. ������ ��ǰ : <%=product %><br>
2. num1 �� : <%=num1 %><br>
3. num2 �� : <%=num2 %><br>
4. num1 + num2 = <%=sum %><br>k

</body>
</html>