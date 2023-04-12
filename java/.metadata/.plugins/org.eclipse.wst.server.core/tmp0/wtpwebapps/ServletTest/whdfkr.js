
function checkAll(self){
    var RegExp = /^[a-zA-Z0-9]{4,12}$/;
    var emailRegExp = /^[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}$/;
    var nameRrgExp = /^[가-힣]{2,4}$/;
    var birthRegExp = /^[0-9]{4}$/


    var ojid  = document.getElementById("isid");
    var ojpwd = document.getElementById("pwd");
    var ojrepwd = document.getElementById("repwd");
    var ojmail = document.getElementById("mail");
    var ojname = document.getElementById("uname");
    var ojintro = document.getElementById("intro");
    var ojbirth = document.getElementById("birth");
    var ojchk = document.getElementsByName("chk");


    //id검사
    if(ojid.value == ""){
        alert("아이디를 입력해");
        return false;
    }
    if(!RegExp.test(ojid.value)){
        alert("4~12자의 영문 대소문자와 숫자로만 입력");
        return false;
    }


    //비밀번호 검사

    if(ojpwd.value ==""){             //입력 여부
        alert("비밀번호를 입력해주세요");
        return false;
    }
    if(!RegExp.test(ojpwd.value)){  //유효성 검사
        alert("4~12자의 영문 대소문자와 숫자로만 입력");
        return false;
    }

   if(ojpwd.value == ojid.value){
        alert("id와 비밀번호가 같습니다 다시 입력하세요");
        return false;
   }
   if(ojpwd =! ojrepwd){
        alert("비밀번호가 틀립니다 다시 입력하세요")
        return false;
   }


   //email 검사
   if(ojmail.value==""){
        alert("메일을 입력해 주세요");
        return false;
   }
   if(!emailRegExp.test(ojmail.value)){
        alert("메일 형식이 다릅니다. 다시 입력하세요");
        return false;
   }

   //이름 유효성 검사

   if(ojname.value==""){
        alert("이름을 입력하세요");
        return false;
   }
   if(!nameRrgExp.test(ojname.value)){
        alert("이름형식이 아닙니다. 다시 입력하세요");
        return false;
   }

   //생일 확인
   if(ojbirth.value==""){
        alert("생일을 입하세요");
        return false;
   }
   if(!birthRegExp.test(ojbirth.value)){
        alert("생일형식이 아닙니다");
        return false;
   }

   //관심 분야
   var num = 0;
   for(var i = 0; i < ojchk.length; i++){
        if(ojchk[i].checked){ count++; }
    }
    if(num == 0){ 
        alert("관심분야를 체크해주세요."); 
        return;
    }

//자기소개
   if(ojintro.value == ""){
        alert("자기소개를 입력해주세요");
        return false
   }

}