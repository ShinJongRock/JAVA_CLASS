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


     <h2>request �׽�Ʈ ���</h2>
        <HR>

        <table  align="center" border="1px" writh="350px" height="120px">
            <tr>
                <td>�̸�</td>
                <td>
                	<%=name %>
                </td>
            </tr>

            <tr>
                <td>����</td>
                <td><%=select %></td>
            </tr>

            <tr>
                <td>���� �о�</td>
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