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
	str+= "�׽�Ʈ�Դϴ�,";
	return str;
}
private String str="����";
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
<h2>����ð��Դϴ�, 
<%= hour %>��
<%= hour %>��
<%= min %>��
<%= second %>�� 
<%= ampm %>�Դϴ�,


</h2>
</body>

</body>
</html>