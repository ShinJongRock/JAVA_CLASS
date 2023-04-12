<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
       <%@ page import="java.sql.*" %>
    
    <%@ page import="javax.sql.*" %>
    <%@ page import="javax.naming.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8");%>


	<%
	String id = request.getParameter("name");
	String mail = request.getParameter("mail");
	
	
	
	Connection conn = null;
	String sql="Select * from whdfkr";
    try{
        Context init = new InitialContext();
        DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
        conn=ds.getConnection();
        PreparedStatement pstmt=conn.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        out.println("<h3>등록 목록</h3>");
            int i = 1;
            while(rs.next()) {
                out.println("<h3>"+ i++ + ": " + rs.getString(1)+","+rs.getString(2)+"</h3>");
            }
            rs.close();

	} catch (Exception e) {
		out.println("<h3>레코드 등록에 실패하였습니다.</h3>");
		e.printStackTrace();
	}
	%>
	
	
	
	
</body>
</html>