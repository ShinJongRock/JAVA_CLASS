<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<form  method = "post" id = "form" onsubmit = "return false;">
	<table border = "1" align = "center">
		<tr>
			<td>
				ID :
			</td>
			<td>
				<input type = "textbox" name ="id">
			</td>
		</tr>
		
		<tr>
			<td>
				PW :
			</td>
			
			<td>
				<input type = "textbox" name ="pw">
			</td>
		</tr>
		
		<tr>
			<td colspan = "2" align = "center">
				<input type = "button" value = "로그인" onclick ="login()">
				<input type = "button" value = "회원가입" onclick ="join()">
			</td>
			
		
		</tr>
	</table>
	</form>
	
	
</body>
</html>

	<script type = "text/javascript">
		var form = document.getElementById("form");
		function login(){
			 form.action = "loginProcess.jsp";
			 form.method = "post";
			 form.submit();
		}
	
		function join(){
			form.action = "joinForm.jsp";
			form.methd = "post";
			form.submit();
		}
		
	</script>