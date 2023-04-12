<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>


<%

	Connection conn = null;
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String sql="SELECT * FROM member2 WHERE id = ? AND pw = ?";
	HttpSession se = request.getSession();
	se.setAttribute("id",id);
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setString(2,pw);
		ResultSet rs = pstmt.executeQuery();
		

		while(rs.next()){

			if(id.equals(rs.getString(2)) && pw.equals(rs.getString(3))){
				out.println("<script>alert('login success')</script>");
				out.println("<script>location.href='Main.jsp'</script>");
			}
			
			out.println("<script>alert('회원가입 해주세요')</script>");

			out.println("<script>location.href='loginForm.jsp'</script>");
			
		}
		rs.close();
	}catch(Exception e){
		out.println("<script>");
		out.println("alert('오류 발생');");
		out.println("</script>");
		out.println("<script>location.href='loginForm.jsp'</script>");
		e.printStackTrace();
	}
%>