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
	String[] name = new String[] { "â��¯", "����¯", "�繮¯", "��¯" };

	for (int i = 11; i <= 14; i++) {
		stmt.setInt(1, i);
		stmt.setString(2, name[i - 11]);

		if (stmt.executeUpdate() != 0) {
	out.println("<h3>" + i + "�� ��ũ�带 ����Ͽ����ϴ�.</h3>");
		}

	}

} catch (Exception e) {
	out.println("<h3>���ڵ� ��Ͽ� �����Ͽ����ϴ�.</h3>");
	e.printStackTrace();
}
%>







