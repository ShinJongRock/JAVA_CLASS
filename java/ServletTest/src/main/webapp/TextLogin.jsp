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
//���� �ʱ�ȭ �޼���
session.invalidate();
%>
	
     <h2>
            �α���
        </h2>
        <hr>
        <form action="Test_setProduct.jsp" method="post">
        <tr>
            <td>
            	�α���
                <input type="text" nema="name">
                <input type="submit"  value="�α���" >
            </td>
        </tr>
        </form>
   
</body>
</html>