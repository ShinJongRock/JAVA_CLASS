<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.sql.* " %>
<%@ page import = "javax.sql.* " %>
<%@ page import = "javax.naming.* " %>  
<%@ page import = "java.util.* " %>
<%@ page import="net.member.db.*" %>
<%
request.setCharacterEncoding("UTF-8");
String id = (String) session.getAttribute("id");

ArrayList <String> array = new ArrayList<>();

array = (ArrayList)request.getAttribute("array");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<div align = "center">
<a href="./BoardList.bo">뒤로가기</a><br>
<h3>회원목록보기 </h3>


<table align ="center" border = "2">
	<tr>
		<td colspan ="2">
			info
		</td>
	</tr>
<% for(int i =0;i<array.size();i++){ %>

	<tr>
		<td>
			<a href ="./MemberInfo.lg?id=<%=array.get(i)%>"> <%=array.get(i) %></a>
		</td>
		<td>
			<a href ="./MemberDeleteAction.lg?id=<%=array.get(i)%>">삭제</a>
		</td>
	</tr>
	


	
	
<% } %>

</table>

</div>


<%@ include file="../template/logout.jsp" %>

</body>
</html>