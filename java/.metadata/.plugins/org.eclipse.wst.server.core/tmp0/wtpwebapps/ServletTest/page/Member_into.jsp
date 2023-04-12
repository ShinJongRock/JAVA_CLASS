<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %> 


<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String rname ="";
	String rid="";
	String rpw="";
	String remail="";
	Connection conn = null;
	String sql="SELECT * FROM user_info1 WHERE id = ?";

	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);
	
		ResultSet rs = pstmt.executeQuery();
		

		while(rs.next()){
			rname = rs.getString(1);
			rid = rs.getString(2);
			rpw = rs.getString(3);
			remail = rs.getString(4);
		}
		rs.close();
	}catch(Exception e){		
		e.printStackTrace();
	}



%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align = "center" border = "1">
		<tr>
			<td align = "center" colspan="2">
				user info
			</td>
		</tr>
			<tr>
			<td>
				¿Ã∏ß :
			</td>
			<td>
				<%=rname %>
			</td>
		</tr>
			<tr>
			<td>
				ID :
			</td>
			<td>
				<%=rid %>
			</td>
		</tr>
			<tr>
			<td>
				PW :
			</td>
			<td>
				<%=rpw %>
			</td>
		</tr>
			<tr>
			<td>
				EMAIL :
			</td>
			<td>
				<%=remail %>
			</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<a href = "Member_list.jsp">move memberlist</a>
			</td>
		</tr>
	</table>
</body>
</html>