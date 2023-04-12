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
   <h2>session 예제</h2>
   <hr>
   <%
      // isNew() 메서드를 이용해 최ㅗ세션설정을 확인하고 있다.
      if(session.isNew()){
         out.println("<script> alert('세션이 해제되어 다시 설정합니다.') </script>");
         session.setAttribute("login", "홍길동");
      }
   %>
   
   # <%= session.getAttribute("login") %> 님 환영 합니다.!!! <BR>
   1. 세션 ID : <%=session.getId() %> <BR>
   2. 세션 유지시간 : <%= session.getMaxInactiveInterval() %><BR>
</center>
</body>
</html>