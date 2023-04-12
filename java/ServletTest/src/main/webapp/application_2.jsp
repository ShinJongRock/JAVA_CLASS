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
USERNAME 에 설정된 값은 :<br>   
<%=application.getAttribute("username")%><br>   
<%

Integer count = (Integer)application.getAttribute("count");
 
int cnt = count.intValue()+1;
application.setAttribute("count", cnt);
%>   

<%//새로 고침하면 1씩 카운터가 올라간다. %>     
 count : <%= cnt %>
출처: https://bitjava.tistory.com/20 [선택장애:티스토리]

</body>
</html>