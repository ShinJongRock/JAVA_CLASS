<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script language="javascript"> 
        document.cookie= "cook_ok"

    </script>
</head>
<body>
	  <h2>reQuest �׽�Ʈ ��</h2>
        <HR>

            <form action="Reuest_2.jsp" method="post">
            <table align="center" border="1px" writh="350px" height="120px">

            <tr >
                <td>�̸�</td>
                <td><input type="text" name="name"></td>

            </tr>

            <tr >
                <td >����</td>
                <td>
                    <select name="select">
                    <option value="����">����</option>
                    <option value="������">������</option>
                    <option value="����">����</option>
                    <option value="���">�밡��</option>
                    
                    </select>
                </td>
            </tr>

            <tr >

                <td >���� �о�</td>
                <td > 
                    <input type="checkbox" name="chk" value="��ġ" onclick="check_only(this)">��ġ
                    <input type="checkbox" name="chk" value="��ȸ" onclick="check_only(this)">��ȸ
                    <input type="checkbox" name="chk" value="�������" onclick="check_only(this)">�������
                  
                </td>
            </tr>
            <tr  >
                <td  colspan="3" align="center"><input type="submit" value="Ȯ��"> 
                  <input type="reset" value="���"></td>
            </tr>




            </table>
        </form>
<HR>
<h2>���2</h2>
  </table>

        <table border="0"><tr><td>
            1.Ŭ���̾�Ʈ IP�ּ�: <%= request.getRemoteAddr() %> <br>
            2.��û �޼��� : <%= request.getMethod()%> <br>
            <%
                Cookie cookie[] = request.getCookies();
            %>
            3. <%= cookie[0].getName()%> �� ������ ��Ű��: <%= cookie[0].getValue() %><br>
            4. ��������: <%=request.getProtocol() %>

        </td></tr>


        </table>




</body>
</html>