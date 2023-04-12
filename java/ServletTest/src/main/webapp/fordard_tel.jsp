<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <% request.setCharacterEncoding("euc-kr");%>


<jsp:forward page= "forward_action.jsp">
      <jsp:param value="010-000-000" name="tel"/>
      
  </jsp:forward>   

