<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.*" %>
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import ="javax.naming.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body align="center">
	<form action="DB_JDBC_HW1.jsp">
	<h1>이벤트 등록</h1>
	<hr>
	<br>
	등록이름 : 
	<input type="text" id="name" name="name">
	email주소 : 
	<input type="text" id="mail" name="mail">
	<button type="submit">등록</button>
	<hr>
	</form>
	<h3 align="left">#등록 목록</h3>
	<br>
	<%
    Connection conn=null;
    String sql = "SELECT * FROM whdfkr";
    
   	try{
   		Context init = new InitialContext();
   		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
   		conn=ds.getConnection();
   		
   		PreparedStatement stmt = conn.prepareStatement(sql);
   		ResultSet rs = stmt.executeQuery();
   		
   		int i=1;
   		while(rs.next()){
   			out.println("<h3 align='left'>"+i+" : "+rs.getString(1)+" , "+rs.getString(2)+"</h3>");
   			i++;
   		}
   		rs.close();
   		
   	}catch(Exception e ){
   		e.printStackTrace();
   	}
   	
    %>
</body>
</html>
