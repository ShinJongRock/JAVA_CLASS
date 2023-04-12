<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <% request.setCharacterEncoding("euc-kr");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>


<% 

	String name = request.getParameter("name");
	String select = request.getParameter("select");
	String chk[] = request.getParameterValues("chk");
	

%>

<body align="center">


     <h2>request 테스트 결과</h2>
        <HR>

        <table  align="center" border="1px" writh="350px" height="120px">
            <tr>
                <td>이름</td>
                <td>
                	<%=name %>
                </td>
            </tr>

            <tr>
                <td>직업</td>
                <td><%=select %></td>
            </tr>

            <tr>
                <td>관심 분야</td>
                <td>
                <%
                	for(int i=0; i<chk.length; i++){
                		out.println(chk[i] +"<BR>");
                	}
                %>
             
            </tr>
        </table>


</body>
</html>