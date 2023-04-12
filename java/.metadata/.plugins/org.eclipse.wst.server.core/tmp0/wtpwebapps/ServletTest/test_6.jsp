<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<%
	// contents값을 들고 옴
	String contents = request.getParameter("cont");
	


	// contents 없을 경우
	String Page = "test_3";
	// contents 있을 경우
	if(contents != null){
		Page = contents;
	}
	Page += ".jsp";
%>


<body>
<table border = "1" width = "700" height = "200">

<tr  height = "30%">
	<td colspan = "3" >
		<jsp:include page = "test_1.jsp"/> 
	</td>
	
</tr>





<tr  height = "60%">
	<td colspan = "1" align="center"  >
		<jsp:include page = "test_2.jsp"/> 
	</td>
	<td colspan = "2" align="center">
	<jsp:include page="<%= Page %>" />
	</td>
	
</tr>
	
	
	
	
<tr  height = "10%">

	<td  colspan = "3 "align="center"><jsp:include page = "test_4.jsp"/></td>
	
</tr>



</table>

</body>
</html>