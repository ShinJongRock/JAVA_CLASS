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
	  <h2>reQuest 테스트 폼</h2>
        <HR>

            <form action="Reuest_2.jsp" method="post">
            <table align="center" border="1px" writh="350px" height="120px">

            <tr >
                <td>이름</td>
                <td><input type="text" name="name"></td>

            </tr>

            <tr >
                <td >직업</td>
                <td>
                    <select name="select">
                    <option value="무직">무직</option>
                    <option value="공무원">공무원</option>
                    <option value="군인">군인</option>
                    <option value="녹다">노가다</option>
                    
                    </select>
                </td>
            </tr>

            <tr >

                <td >관심 분야</td>
                <td > 
                    <input type="checkbox" name="chk" value="정치" onclick="check_only(this)">정치
                    <input type="checkbox" name="chk" value="사회" onclick="check_only(this)">사회
                    <input type="checkbox" name="chk" value="정보통신" onclick="check_only(this)">정보통신
                  
                </td>
            </tr>
            <tr  >
                <td  colspan="3" align="center"><input type="submit" value="확인"> 
                  <input type="reset" value="취소"></td>
            </tr>




            </table>
        </form>
<HR>
<h2>결과2</h2>
  </table>

        <table border="0"><tr><td>
            1.클라이언트 IP주소: <%= request.getRemoteAddr() %> <br>
            2.요청 메서드 : <%= request.getMethod()%> <br>
            <%
                Cookie cookie[] = request.getCookies();
            %>
            3. <%= cookie[0].getName()%> 에 설정된 쿠키값: <%= cookie[0].getValue() %><br>
            4. 프로토콜: <%=request.getProtocol() %>

        </td></tr>


        </table>




</body>
</html>