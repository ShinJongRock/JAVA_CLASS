<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
String email = request.getParameter("mail");
Connection conn = null;
String sql = "INSERT INTO whdfkr (Name, Mail) values (?,?)";

try {
	
	Context init = new InitialContext();
	DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	conn = ds.getConnection();
	PreparedStatement stmt = conn.prepareStatement(sql);

	stmt.setString(1,name);
	stmt.setString(2,email);
	
	if (stmt.executeUpdate()!=0){
		response.sendRedirect("DB_JDBC_HW.jsp");
	}
}

catch (Exception e) {
	out.println("<h3>레코드 등록에 실패하였습니다.</h3>");
	e.printStackTrace();
}
%>
