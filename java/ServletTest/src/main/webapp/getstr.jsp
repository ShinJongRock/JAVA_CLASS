<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h3>
	<%= getstr() %>
</h3>
<%!
private String getstr(){
	str+= "테스트입니다,";
	return str;
}
private String str="선언문";
%>




<%
 

Calendar c= Calendar.getInstance();
int hour =c.get(Calendar.HOUR_OF_DAY);
int min = c.get(Calendar.MINUTE);
int second = c.get(Calendar.SECOND);
int ampm = c.get(Calendar.AM_PM);


String am = "";

if(ampm== 0){
	am = "am";
}else{
	am = "pm";
}

%>

<body>
<h2>현재시간입니다, 
<%= hour %>시
<%= hour %>시
<%= min %>분
<%= second %>초 
<%= ampm %>입니다,


</h2>
</body>

</body>
</html>