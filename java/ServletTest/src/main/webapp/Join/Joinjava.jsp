<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
   <h1>이벤트 등록</h1>
   <hr>
   <br>
   등록이름 : 
   <input type="text" id="name">
   email주소 : 
   <input type="text" id="mail">
   <button>등록</button>
   <hr>
   
   

 <%
Connection conn = null;
String sql ="select * from student";

try {

	Context init = new InitialContext();
	DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	conn = ds.getConnection();
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	
	
	while(rs.next()){
		out.println("<h3>"+rs.getInt(1)+","+rs.getString(2)+"</h3>");
	}
	rs.close();
	

} catch (Exception e) {
	out.println("<h3>레코드 등록에 실패하였습니다.</h3>");
	e.printStackTrace();
}
%>

   
 
</body>

</html>

   