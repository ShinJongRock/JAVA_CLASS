<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %> 
   
   
   
<%
Connection conn = null;
String sql="SELECT * FROM user_info1";

try{
	Context init = new InitialContext();
	DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	conn = ds.getConnection();
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	

	
%>



   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table align="center" border ="1">
 		<tr>
 			<td colspan ="2">
 				회원목록
 			</td>
 		</tr>
<%	while(rs.next()){  %>
		<tr>
			<td>
			<a href = "Member_into.jsp?id=<%=rs.getString(2)%>"><%=rs.getString(2) %></a>
			</td>
			
			<td>
			<a href = "Member_delete.jsp?id=<%=rs.getString(2)%>">삭제</a>
			</td>
		</tr>

		
<% 	
	
		
	}
	rs.close();
}catch(Exception e){

	e.printStackTrace();
}

%>   
	<tr>
		<td	align = "cetner" colspan = "2">
				<a href = "Main.jsp">move Main</a>
		</td>
	</tr>
</table>
</body>
</html>