<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.*"%>
    <% request.setCharacterEncoding("EUC-KR"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body align="center">

<h2> ������ ��ǰ ��� </h2> 
 
  <hr> 
  
  
  <script type="text/javascript">
		function deleteSe(){
			document.location.href="Test_Logout.jsp";
		}
		function backetPop(){
			document.location.href="Test_DElet.jsp";
		}
	</script>
  
  
  
  
  
  
  
  <%
     ArrayList Slist = (ArrayList)session.getAttribute("productlist");
  
   if(Slist == null){ 
   out.println("������ ����� �����ϴ�.!!"); 
   } else { 
   		for(Object productname:Slist){ 
        	out.println(productname +"<br>"); 
      } 
   } 
 
  %> 
  
  
  
	  

<form >
    <input type="button" value="�α׾ƿ�" onclick="deleteSe()">
   
   	<input type="button" value="�ڷΰ���" onclick="history.go(-1);">
    <input type = "button" value ="�ٱ��� ����"  onclick="backetPop()">
   
    
    
</form>








</body>
</html>