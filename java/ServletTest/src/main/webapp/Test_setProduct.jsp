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
            ���� �ϰ� ������ ���
        </h2>
        <hr>
        
     <%
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		
		//�̸��� ""�̸� ��������
		if(name == ""){
			out.println("<script>alert('�̸��� �Է����ּ���.');</script>");
			out.println("<script>location.href='TextLogin.jsp'</script>");
		}
		
		//���ǿ� login�� ���ٸ� ���
		if(session.getAttribute("name") == null){
			session.setAttribute("name", name);
		}
	%>
				
		
		<hr/>
			<%= session.getAttribute("name") %>���� �α��� �� �����Դϴ�. <%= session.getAttribute("name") %><br/>
		<hr/>

        <hr>
        
        <form  action="Test_add.jsp" method="post">
		<select name=  SelectList>
		    <option value="�ڰ� �ʹ�">�ڰ� �ʹ�</option>
		    <option value="���� �ְ� �ʹ�">���� �ְ� �ʹ�</option>
		    <option value="�� ������ �ʹ�">�� ������ �ʹ�</option>
		    <option value="��� �ʹ�">��� �ʹ�</option>
		    <option value="������ �ʹ�">������ �ʹ�</option>
		</select>
		
		<input type="submit"  value="�߰�">
		</form>
		<br>
		<br>
		
		<a href="Test_ckklist.jsp">���</a>
		       
		     
		</cnter>
</body>
</html>