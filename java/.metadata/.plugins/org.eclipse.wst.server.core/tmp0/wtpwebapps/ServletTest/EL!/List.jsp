<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    
    
    
    

<jsp:useBean id="Eltest" class="test.Eltest" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form action="Sel.jsp" method="post">
<select name="box">
   <% String[] list = Eltest.getProductList(); %>
   <%
   		for(int i=0; i<5; i++){
    %>
   
   <option value="<%=list[i] %>"><%=list[i]%></option>
   <%}
   %>
   
   
   
   
</select>
   <input type="submit" value="전송">
</form>

</body>
</html>