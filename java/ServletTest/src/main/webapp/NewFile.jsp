<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body align="center">
<h2>����</h2>
<form action="Cal" method="get">
	<tr>
		<td>
		<input type= "text" name ="Fnum">
		
		 <select name="chk">
		 	  <option value=+>+</option>
		      <option value="-">-</option>
		      <option value="*">*</option>
		      <option value="/">/</option>
		 </select> 
		 
		 <input type= "text" name="Snum">
	
		  <input type="submit" name="submit" value="���" >
    	  <input type="reset" value="�ٽ� �Է�">
    	  
		</td>
	</tr>
</form>
</body>
</html>