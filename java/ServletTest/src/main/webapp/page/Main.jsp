<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>


<%
	HttpSession se = request.getSession();
	String id = (String)se.getAttribute("id");
%>
	

	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main page</title>
</head>
<body>
	<h3><%=id %> 어서 오시고!!!</h3>
	
	<%	if(id.equals("admin")){	%>
		<a href = "Member_list.jsp">admin mode access</a><br>
		
		
<% 	}	%>

	<a href = "loginForm.jsp" align = "center">logout</a>
</body>
</html>