<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>session.jsp</title>
</head>
<body>
<center>
   <h2>session ����</h2>
   <hr>
   <%
      // isNew() �޼��带 �̿��� �֤Ǽ��Ǽ����� Ȯ���ϰ� �ִ�.
      if(session.isNew()){
         out.println("<script> alert('������ �����Ǿ� �ٽ� �����մϴ�.') </script>");
         session.setAttribute("login", "ȫ�浿");
      }
   %>
   
   # <%= session.getAttribute("login") %> �� ȯ�� �մϴ�.!!! <BR>
   1. ���� ID : <%=session.getId() %> <BR>
   2. ���� �����ð� : <%= session.getMaxInactiveInterval() %><BR>
</center>
</body>
</html>