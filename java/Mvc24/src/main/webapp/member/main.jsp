<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript"> 
function goPage() 
{ 	
	// 링크가 눌려지면 해당 함수가 호출됨.
	document.loginf.action = "./MemberLoginAction.lg";
	document.loginf.method = "post";
	document.loginf.submit();
}
</script>

</head>

<body  align="center">
<% session.invalidate(); %>

	<h2 class="text-center">로그인 페이지</h2>
	<div align="center">
	<div class = "container my-3">
		<div class="card align-middle" >
			<div class="card-body">
			<form name="loginf">
			<table border="1">
				 <tr>
		            <td colspan="2">로그인 페이지
		         </tr>
		         
				<tr>
					<td>
						아이디
					</td>
					<td >
					<input type="text" name="mid" id="id" placeholder="ID를 입력하세요" class="form-control">
					</td> 
				</tr>
				
				<tr>
					<td>비밀번호</td>
					<td colspan="2">
						<input type="text" name="mpw" id="pw" placeholder="비밀번호를 입력하세요" class="form-control">
					</td>
				</tr>

				
				<tr>
					<td colspan="2">
					<a href="javascript:;" onclick="goPage()">로그인</a>
				
					
					<a href="./joinForm.lg">회원가입</a>
					</td>
				</tr>
					
			
				</table>
			</form>
				</div>
			</div>
		</div>
	</div>

	

</body>
</html>