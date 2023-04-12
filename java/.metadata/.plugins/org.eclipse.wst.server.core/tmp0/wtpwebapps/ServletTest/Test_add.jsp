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
<body>


<%!ArrayList<String> list; %>



<h2>선택 목록</h2>
<%
    
 
    String productName = request.getParameter("SelectList"); // 가져온 목록  변수에 저장
    
 
    ArrayList list = (ArrayList)session.getAttribute("productlist");  
    if(list == null)
      { 
      list = new ArrayList<String>(); 

      }  
    // 가지고온 값이 null이면 처음 상품을 선택한 것이므로 새로운 ArrayList를 만들게 되고
    
 
    list.add(productName);
    // ArrayList에는 가지고 온 상품명을 추가한다
    
    session.setAttribute("productlist", list);
    // 추가된 List는 다시 세션에 저장
    // 이후 새로운 목록이 추가될때는 세션에서 가지고온 ArrayList에 추가된 상품을 추가
    
    
   
	 
%>


	 <script> 
	 alert("<%=productName %>이(가) 추가되었습니다!!"); 
	 history.go(-1); // 바로 전 페이지로 넘어가기 위해서
	 </script> 
	 
	 <%
    if(productName == null){
	        //out.println("과일을 고르세요");
	        out.println("<script>alert('과일을 고르세요'); history.go(-1); </script>"); 
	    }     
	%> 



</body>
</html>