<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <% request.setCharacterEncoding("EUC-KR"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<body  align="center">

<%
//세션 초기화 메서드
session.invalidate();
%>
	
     <h2>
            로그인
        </h2>
        <hr>
        <form action="Test_setProduct.jsp" method="post">
        <tr>
            <td>
            	로그인
                <input type="text" nema="name">
                <input type="submit"  value="로그인" >
            </td>
        </tr>
        </form>
   
</body>
</html>