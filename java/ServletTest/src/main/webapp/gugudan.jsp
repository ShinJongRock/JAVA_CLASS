<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">구구단</h2>

<table align="center" border="1">
	<tr bgcolor="#a4b0be">
		<td ></td>
         <%
             for (int i = 2; i < 10; i++) {
         %>
         	<td align="center" width="80"><%=i%></td>
         <%
             }
         %>
         <%
             for (int i = 1; i < 10; i++) {
         %>
         
     <tr>
         <td align="center"  width="50" bgcolor="#a4b0be" >
         	<%=i%>
         </td>
         <%
             for (int j = 2; j < 10; j++) {
         %>
         <td align="center">
         	<%=j%> * <%=i%>= <%=j * i%>
         </td>
         <%
             }
         %>
     </tr>
     <%
         }
     %>
     </tr>




</table>

</body>
</html>