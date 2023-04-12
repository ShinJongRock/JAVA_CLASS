<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>application 예제</h1><hr>
1. 서버 정보 : <%= application.getServerInfo() %> <br>
2. 서블릿 API 버젼정보 : <%= application.getMajorVersion() +
"." +application.getMinorVersion() %> <br>
3. application.jsp 화일의 실제 경로 : <%= application.getRealPath("application_2.jsp") %> <br>
<hr>
setAttribute 로 username 변수에 "홍길동" 설정 <p>
<% application.setAttribute("username","홍길동");
application.log("username=홍길동");
application.setAttribute("count", 1);%>

<a href = "application3.jsp">확인하기</a> 


</body>
</html>