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

1. 선택한 상품 : <%=product %><br>
2. num1 값 : <%=num1 %><br>
3. num2 값 : <%=num2 %><br>
4. num1 + num2 = <%=sum %><br>k

</body>
</html>