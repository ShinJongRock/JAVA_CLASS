<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <% request.setCharacterEncoding("EUC-KR"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body align="center">


     <h2>
            지금 하고 싶은거 목록
        </h2>
        <hr>
        
     <%
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		
		//이름이 ""이면 돌려보냄
		if(name == ""){
			out.println("<script>alert('이름을 입력해주세요.');</script>");
			out.println("<script>location.href='TextLogin.jsp'</script>");
		}
		
		//세션에 login이 없다면 등록
		if(session.getAttribute("name") == null){
			session.setAttribute("name", name);
		}
	%>
				
		
		<hr/>
			<%= session.getAttribute("name") %>님이 로그인 한 상태입니다. <%= session.getAttribute("name") %><br/>
		<hr/>

        <hr>
        
        <form  action="Test_add.jsp" method="post">
		<select name=  SelectList>
		    <option value="자고 싶다">자고 싶다</option>
		    <option value="누워 있고 싶다">누워 있고 싶다</option>
		    <option value="멍 때리고 싶다">멍 때리고 싶다</option>
		    <option value="놀고 싶다">놀고 싶다</option>
		    <option value="집가고 싶다">집가고 싶다</option>
		</select>
		
		<input type="submit"  value="추가">
		</form>
		<br>
		<br>
		
		<a href="Test_ckklist.jsp">계산</a>
		       
		     
		</cnter>
</body>
</html>