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



<h2>���� ���</h2>
<%
    
 
    String productName = request.getParameter("SelectList"); // ������ ���  ������ ����
    
 
    ArrayList list = (ArrayList)session.getAttribute("productlist");  
    if(list == null)
      { 
      list = new ArrayList<String>(); 

      }  
    // ������� ���� null�̸� ó�� ��ǰ�� ������ ���̹Ƿ� ���ο� ArrayList�� ����� �ǰ�
    
 
    list.add(productName);
    // ArrayList���� ������ �� ��ǰ���� �߰��Ѵ�
    
    session.setAttribute("productlist", list);
    // �߰��� List�� �ٽ� ���ǿ� ����
    // ���� ���ο� ����� �߰��ɶ��� ���ǿ��� ������� ArrayList�� �߰��� ��ǰ�� �߰�
    
    
   
	 
%>


	 <script> 
	 alert("<%=productName %>��(��) �߰��Ǿ����ϴ�!!"); 
	 history.go(-1); // �ٷ� �� �������� �Ѿ�� ���ؼ�
	 </script> 
	 
	 <%
    if(productName == null){
	        //out.println("������ ������");
	        out.println("<script>alert('������ ������'); history.go(-1); </script>"); 
	    }     
	%> 



</body>
</html>