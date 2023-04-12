<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
    <!DOCTYPE html>
    <html>
    <body>
    <title>회원가입</title>
    </head>
    <body>


        <script type = "text/javascript">

        
        //아이디 4~12자의 영문 대소문자의 숫자로만 입력
        function idCheck(){
            var getId = document.getElementById("id").value;
            const check = new RegExp(/^[a-zA-Z0-9]{4,12}$/);    // ^를 사용하면 시작되는 언어가 a-zA-Z0-9 사이로 시작
            if(check.test(getId)){
                return true;

            }else
                return false;

        }
        
        //비밀번호 4~12자의 영문 대소문자와 숫자로만 입력
        function pwCheck(){
            var getPw = document.getElementById("pw").value;
            const pwC = new RegExp(/^[a-zA-Z0-9]{4,12}$/);      // ^를 사용하면 시작되는 언어가 a-zA-Z0-9 사이로 시작
            if(pwC.test(getPw)){
                return true;
            }else
                return false;
        }
        
        //비밀번호 확인
        function pwCheck2(){
            var pw = document.getElementById("pw").value;
            var pw2 = document.getElementById("pwcheck").value;

            if(pw == pw2){
                return true;
            }else
                return false;

        }
        
        //메일
        function emailCheck(){
            var getEmail = document.getElementById("email").value;
            const emailC = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
            if(emailC.test(getEmail)){
                return true;
            }else
                return false;

        }
        
        //이름        한글만 입력 가능하고 2자~10자 이내 입력
        function nameCheck(){
            var getName = document.getElementById("name").value;
            const nameC = new RegExp(/^[ㄱ-ㅎ가-힣]{2,10}$/);
            if(nameC.test(getName)){
                return true;
            }else
                return false;
        }



        



        function mainClick(){
            var id =idCheck();
            var pw =pwCheck();
            var pwC = pwCheck2();
            var nameC = nameCheck();
            var emailC = emailCheck();
            
            
            if(id ==true && pw == true && pwC ==true && nameC ==true&& emailC ==true ){
                alert("회원가입 완료");
                document.getElementById("form").submit();
            }else
                alert("다시 입력하세요");
            
       
        }
        
        </script>
        <form id = "form" action = "joinprocess.jsp" method = "post">

        <table width="700" height = "300" border = "1" align = "center" bgcolor ="white">

        <tr>
        <td colspan = "2" align = "center"><B>회원 가입</B>
        </tr><!--아이디 입력-->
        <td align = "center"><B>아이디:</B></td>
        <td><input type = "text" name = "id" size="20"  id ="id" >4~12자의 영문 대소문자와 숫자로만 입력
        </td>
        
        <tr><!--비밀번호 입력-->
        <td align = "center"><B>비밀번호:</B></td>
        <td><input type = "text" name = "pw" id = "pw" size="20" >4~12자의 영문 대소문자와 숫자로만 입력	</td>
        </tr>
        
        <tr><!--비밀번호 확인 입력-->
        <td align = "center"><B>비밀번호확인:</B></td>
        <td><input type = "text" name = "pw_check" id ="pwcheck" size="17"></td>
        </tr>
        
        <tr><!--메일 주소 입력-->
        <td align = "center"><B>메일주소:</B></td>
        <td><input type = "text" name = "mail" size="20"  id = "email" >ex)id@naver.com</td>
        </tr>
        
        <tr><!--이름 입력-->
        <td align = "center"><B>이름:</B></td>
        <td><input type = "text" name = "name" size="20"  id = "name" ></td>
        </tr>
        

  
        </table>

    
    <p align = "center">
    <input type = "submit" value = "로그인">
        </p>
    </form>


        
    </body>
    </html>