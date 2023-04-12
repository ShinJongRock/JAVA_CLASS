<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ page import="java.sql.*" %>
    
    <%@ page import="javax.sql.*" %>
    <%@ page import="javax.naming.*" %>

<%
Connection conn = null;
String sql = "INSERT INTO student (num, name) values (?,?)";

try {

	Context init = new InitialContext();
	DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	conn = ds.getConnection();
	PreparedStatement stmt = conn.prepareStatement(sql);
	String[] name = new String[] { "창훈짱", "종락짱", "재문짱", "연짱" };

	for (int i = 11; i <= 14; i++) {
		stmt.setInt(1, i);
		stmt.setString(2, name[i - 11]);

		if (stmt.executeUpdate() != 0) {
	out.println("<h3>" + i + "번 레크드를 등록하였습니다.</h3>");
		}

	}

} catch (Exception e) {
	out.println("<h3>레코드 등록에 실패하였습니다.</h3>");
	e.printStackTrace();
}
%>







