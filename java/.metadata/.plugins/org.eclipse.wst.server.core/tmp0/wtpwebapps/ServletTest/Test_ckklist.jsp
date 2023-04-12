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

<h2> 선택한 상품 목록 </h2> 
 
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
   out.println("선택한 목록이 없습니다.!!"); 
   } else { 
   		for(Object productname:Slist){ 
        	out.println(productname +"<br>"); 
      } 
   } 
 
  %> 
  
  
  
	  

<form >
    <input type="button" value="로그아웃" onclick="deleteSe()">
   
   	<input type="button" value="뒤로가기" onclick="history.go(-1);">
    <input type = "button" value ="바구니 비우기"  onclick="backetPop()">
   
    
    
</form>








</body>
</html>