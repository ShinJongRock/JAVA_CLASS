<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <% request.setCharacterEncoding("euc-kr");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<h2>ford</h2>

  
<body>


		<form method="post" action="fordard_tel.jsp">
           forward action : <input type="test" name="name">
           <input type="submit" value="확인">
        </form>
        
        <form method="post" action="respon.jsp">
          response,sendRedirect : <input type="test" name="name">
           <input type="submit" value="확인">
        </form>
      
       
</body>
</html>