<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %> 
    
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	Connection conn = null;
	String sql="DELETE FROM user_info1 WHERE id = ?";

	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);
		ResultSet rs = pstmt.executeQuery();
		
		rs.close();
		out.print("<script>alert('Delete success')</script>");
		out.print("<script>location.href='1011Member_list.jsp'</script>");
				
	
	}catch(Exception e){		
		e.printStackTrace();
		out.print("<script>alert('system error')</script>");
	}


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제 페이지</title>
</head>
<body>

</body>
</html>