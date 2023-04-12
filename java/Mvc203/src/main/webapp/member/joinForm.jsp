<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원가입 유효성 검사 정규식</title>
<script type="text/javascript" src="./js/script.js" charset="utf-8"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<link rel="stylesheet" href="./bootst/css/bootstrap.css">
</head>

<body>
	<form id="sm" name="pej" method="post" onsubmit="return allCheck()" action="./MemberJoinAction.me">
	
		<div class="row">
			<div class="col-sm-6">
				<table class="table table-bordered table-dark">

					<tr bgcolor="blanchedalmond">
						<!-- 첫줄 -->
						<td align="center" colspan="2" style="color: black">회원 기본 정보</td>
					</tr>

					<tr>
						<!-- 2 -->
						<td>아이디:</td>
						<td><input type="text" id="_id" name="id" size=12
							maxlength=12> 4~12자의 영문 대소문자와 숫자로만 입력</td>

					</tr>

					<tr>
						<!-- 3 -->
						<td>비밀번호:</td>
						<td><input type="password" id="_pw" name="pw" size=12
							maxlength=12> 4~12자의 영문 대소문자와 숫자로만 입력</td>
					</tr>

					<tr>
						<!-- 4 행-->
						<td>비밀번호확인:</td>
						<td><input type="password" id="_pw2" size=12 maxlength=12></td>
					</tr>

					<tr>
						<!-- 5 -->
						<td>메일주소:</td>
						<td><input type="text" id="_mail" name="email" size=15>
							예) id@domain.com</td>
					</tr>

					<tr>
						<!-- 6 -->
						<td>이름:</td>
						<td><input type="text" id="_name" name="name" size=15
							maxlength=4></td>
					</tr>

					<tr bgcolor="blanchedalmond">
						<!-- 첫줄 -->
						<td align="center" colspan="2" style="color: black">개인 신상 정보</td>
					</tr>

					<tr>
						<td>주소</td>
						<!-- zib코드 입력-->
						<td><input type="text" id="tbox1" name="addr"
							placeholder="우편번호" size=8> <input type="button"
							onclick="addrFind()" value="우편번호 찾기"><br> <input
							type="text" id="tbox2" name="addr" placeholder="주소" size=28><br>
							<input type="text" id="tbox4" name="addr" placeholder="참고항목"
							size=28> <input type="text" id="tbox3" name="addr"
							placeholder="상세주소"></td>
					</tr>

					<tr>
						<!-- 7 -->
						<td>주민등록번호:</td>
						<td><input type="text" id="_ju" name="pin" size=15
							minlength=13 maxlength=13> 예) 1234561234567</td>
					</tr>

					<tr>
						<!-- 8 -->
						<td>생일:</td>
						<td><input type="text" id="birth" name="year" size=5maxlength=12>년 
						
							<select id="month" name="month">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
							</select>월 
						
						<select id="day" name="day">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="13">13</option>
								<option value="14">14</option>
								<option value="15">15</option>
								<option value="16">16</option>
								<option value="17">17</option>
								<option value="18">18</option>
								<option value="19">19</option>
								<option value="20">20</option>
								<option value="21">21</option>
								<option value="22">22</option>
								<option value="23">23</option>
								<option value="24">24</option>
								<option value="25">25</option>
								<option value="26">26</option>
								<option value="27">27</option>
								<option value="28">28</option>
								<option value="29">29</option>
								<option value="30">30</option>
								<option value="31">31</option>
						</select>일</td>
					</tr>

					<tr>
						<!-- 9 -->
						<td>관심분야:</td>
						<td><input type="checkbox" value="컴퓨터" name="hobby">컴퓨터
							<input type="checkbox" value="인터넷" name="hobby">인터넷 <input
							type="checkbox" value="여행" name="hobby">여행 <input
							type="checkbox" value="영화감상" name="hobby">영화감상 <input
							type="checkbox" value="음악감상" name="hobby">음악감상
					</tr>

					<tr>
						<!-- 9 -->
						<td>자기소개:</td>
						<td><textarea id="my_intro" name="intro" cols="55" rows="5"
								maxlength="700"></textarea></td>
					</tr>

					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="회원 가입"> <input type="reset" value="다시입력">
						</td>
					</tr>
				</table>
			</div>
		</div>
	</form>
	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="bootst/js/bootstrap.js"></script>
	
</body>
</html>