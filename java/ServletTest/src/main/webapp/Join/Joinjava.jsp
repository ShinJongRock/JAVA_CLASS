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
   <h1>�̺�Ʈ ���</h1>
   <hr>
   <br>
   ����̸� : 
   <input type="text" id="name">
   email�ּ� : 
   <input type="text" id="mail">
   <button>���</button>
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
	out.println("<h3>���ڵ� ��Ͽ� �����Ͽ����ϴ�.</h3>");
	e.printStackTrace();
}
%>

   
 
</body>

</html>

   