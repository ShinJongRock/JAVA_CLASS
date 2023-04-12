<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ page import="java.sql.*" %>
    
    <%@ page import="javax.sql.*" %>
    <%@ page import="javax.naming.*" %>
    
<%
	Connection conn = null;
	String sql = "INSERT INTO student (num,name) VALUES (6, '종락')";

	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		
		Statement stmt = conn.createStatement();
		
		int result = stmt.executeUpdate(sql);
		
		
		out.println("<h3>연결됨</h3>");
		
	}catch (Exception e){
		out.println("<h3> 연결 실패 함</h3>");
		e.printStackTrace();
		
	}



%>