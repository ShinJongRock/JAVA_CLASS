var re = /^[a-zA-Z0-9]{4,12}$/; // 아이디와 패스워드가 적합한지 검사할 정규식
var re2 = /^[0-9a-zA-Z]{1,}@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i; // 이메일 조건 정규 표현식
function allCheck(){
  return (idCheck()&&pwCheck()&&checkMail()&&nameCheck()&&checkAddr()&&ymdCheck()&&checkInterest()&&introCheck());
}

// 아이디
function idCheck(){
  var id = document.getElementById("_id");
  // ^ 이 규칙으로 문장을 시작한다. 
  // [문자 규칙을 입력]
  // {} = [] 안에 포함되는 문자가 최소 4개부터 12개까지
  
  if(id.value == ""){
    window.alert("ID를 입력하세요");
    id.focus();
    id.value = "";
    return false;
  }
  else if(!re.test(id.value)){
    window.alert("아이디는 4~12자와 영어 숫자로만 입력");
    id.focus();
    id.value = "";
    return false;
  }
  else return true;
}

// 주소 유효성 판별 체크 (상세주소)
function checkAddr(){
  var sangaddr = document.getElementById("tbox3").value;
  var numaddr = document.getElementById("tbox1").value;
  if(numaddr == ""){
    alert("주소를 입력해 주세요.");
    document.getElementById("tbox1").focus;
    return false;
  }
  if(sangaddr == ""){ //상세주소 없으면 안받아줌
    alert("상세주소를 입력해 주세요.");
    document.getElementById("tbox3").focus();
    return false;
  }
  else return true;
}

// 비밀번호체크
function pwCheck(){
      var pw1 = document.getElementById("_pw");
      var pw2 = document.getElementById("_pw2");

      // 아이디랑 비번이랑 같을 경우
      if (pw1.value == document.getElementById("_id").value)
      {
        alert("아이디랑 비밀번호가 같으면 안됩니다.")
        pw1.focus;
        pw1.value = "";
        pw2.value = "";
        return false;
      }
      // 비번 길이와 영어소대문자 입력값이 올바른지
      // 정규표현식을 true false로 반환할거면 test
      else if (!re.test(pw1.value))
      {
        alert("비밀번호는 4~12자 또는 영문 대소문자만 입력하세요.");
        pw1.focus;
        pw1.value = "";
        pw2.value = "";
        return false;
      }
      // 비번 확인이 잘 안된 경우
      else if (pw1.value != pw2.value)
      {
        alert("비밀번호를 확인해주세요")
        pw1.focus;
        pw1.value = "";
        pw2.value = "";
        return false;
      }
      else return true;
}

// 메일주소
function checkMail(){
  var mail = document.getElementById("_mail");
  if(mail.value == ""){
    alert("이메일 내용을 입력해주세요.");
    mail.focus;
    mail.value = "";
    return false;
  }
  else if(!re2.test(mail.value)){
    alert("이메일 형식을 확인바랍니다.");
    mail.focus;
    mail.value = "";
    return false;
  }
  else return true;  
}

//이름
function nameCheck(){
  var name = document.getElementById("_name");
  var reKor = /^[가-힣]{1,}$/;
  if (name.value == null){
    alert("이름을 입력해주세요");
    name.focus;
    name.value = "";
    return false;
  }
  else if(!reKor.test(name.value)){
    alert("한글을 입력해 주세요.")
    name.focus;
    name.value = "";
    return false;
  }
  else return true;
}


// 주소팝업
function addrFind() {
  new daum.Postcode({
    oncomplete: function(data) {
    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
    var addr = ''; // 주소 변수
    var extraAddr = ''; // 참고항목 변수

    //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
      addr = data.roadAddress;
    } else { // 사용자가 지번 주소를 선택했을 경우(J)
      addr = data.jibunAddress;
    }
    // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
    if(data.userSelectedType === 'R'){
    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
      extraAddr += data.bname;
    }
    // 건물명이 있고, 공동주택일 경우 추가한다.
    if(data.buildingName !== '' && data.apartment === 'Y'){
      extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
    }
    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
    if(extraAddr !== ''){
      extraAddr = ' (' + extraAddr + ')';
    }
    // 조합된 참고항목을 해당 필드에 넣는다.
    document.getElementById("tbox4").value = extraAddr;
    } else {
      document.getElementById("tbox4").value = '';
    }
    // 우편번호와 주소 정보를 해당 필드에 넣는다.
    document.getElementById('tbox1').value = data.zonecode;
    document.getElementById("tbox2").value = addr;
    // 커서를 상세주소 필드로 이동한다.
    document.getElementById("tbox3").focus();
    }
  }).open();

}

// 주민번호 , 생일
function ymdCheck(){
  var today = new Date();
  var yearcheck = today.getFullYear()
  var ssn = document.getElementById("_ju").value;
  var birth = ssn.substr(0,6);
  var reymd = /^[0-9]{1,}$/; // 숫자만 판별하고 1개이상들어가야함.
  
  // 몇년생인지 구분
  if(!reymd.test(ssn)){
    alert("숫자만 입력하세요.");
    document.getElementById("_ju").focus;
    document.getElementById("_ju").value = "";
    return false;
  }else{
    if(parseInt("20"+birth.substr(0,2)) > yearcheck){
      document.getElementById("birth").value = "19"+ birth.substr(0,2);
    }
    else {
      document.getElementById("birth").value = "20"+ birth.substr(0,2);
    }
    // 월 체크
    month[parseInt(birth.substr(2,2))-1].selected = true;
    day[parseInt(birth.substr(4,2))-1].selected = true;
    
    if(parseInt(ssn[6]) > 4)
    {
      alert("너는 성별이 어떻게 되냐?");
    }
    else if(
      ssn[12] != (11-((2*parseInt(ssn[0])+ 3*parseInt(ssn[1])+ 4*parseInt(ssn[2])+
      5*parseInt(ssn[3])+ 6*parseInt(ssn[4])+ 7*parseInt(ssn[5])+
      8*parseInt(ssn[6])+ 9*parseInt(ssn[7])+ 2*parseInt(ssn[8])+
      3*parseInt(ssn[9])+ 4*parseInt(ssn[10])+5*parseInt(ssn[11]))%11))) 
      {
        alert("주민번호가 매우 수상해~");
    }
    return true;
  }
}

//관심분야
function checkInterest(){
    var interest = document.getElementsByName("hobby")
    var cnt = 0;
    for(var i =0; i<interest.length; i ++){
      if(interest[i].checked){cnt++};
    }
    if (cnt == 0)
    {
      alert("관심분야를 체크해 주세요.")
    return false;
    }
    else return true;
}

// 자기소개
function introCheck(){
  var intro = document.getElementById("my_intro");

  if(intro.value == ""){
    alert("자기소개란에 내용을 입력해주세요.");
    intro.focus;
    return false;
  }
  else return true;
}