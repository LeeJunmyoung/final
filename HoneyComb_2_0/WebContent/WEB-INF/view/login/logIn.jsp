<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
	rel="stylesheet" type="text/css">

<script type="text/javascript"src="/HoneyComb_2_0/resources/script/script.js"></script>
	
	<!-- 네이버 로그인 스크립트 링크 -->
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

<script>
$(document).ready(function(){
    // 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
    var userInputId = getCookie("userInputId");
    $("input[name='email']").val(userInputId); 
     
    if($("input[name='email']").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
        $("#idSaveCheck").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
    }
     
    $("#idSaveCheck").change(function(){ // 체크박스에 변화가 있다면,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기 체크했을 때,
            var userInputId = $("input[name='email']").val();
            setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
        }else{ // ID 저장하기 체크 해제 시,
            deleteCookie("userInputId");
        }
    });
     
    // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
    $("input[name='email']").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
        if($("#idSaveCheck").is(":checked")){ // ID 저장하기를 체크한 상태라면,
            var userInputId = $("input[name='email']").val();
            setCookie("userInputId", userInputId, 7); // 7일 동안 쿠키 보관
        }
    });
});
 
function setCookie(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}
 
function deleteCookie(cookieName){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}
 
function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}
function confirmSave(checkbox){
	var isRemeber
	//로그인정보 저장한다고 선택할 경우
	if(checkbox.checked){
		isRemember = confirm("이 PC에 로그인 정보를 저장하시겠습니까? \n\nPC방등의 공공장소에서는 개인정보가 유출될 수 있으니 주의해주십시오.");
		
		if(!isRemember)
			checkbox.checked = false;
	
	}
}
function openNaver(){
	var url="https://nid.naver.com/oauth2.0/authorize?client_id=XxuZWIw4L8tP4C_0BW1_&response_type=code&redirect_uri=http://localhost:7777/HoneyComb_2_0/login/logIn.do(UTF-8)&state=${state}";
	window.open(url);
	
}
</script>
<style type="text/css">


a:link {
	text-decoration: none;
	color: #333333;
}

a:visited {
	text-decoration: none;
	color: #333333;
}

a:active {
	text-decoration: none;
	color: #333333;
}

a:hover {
	text-decoration: underline;
	color: red;
}

#home_banner {
	width: 100%;
	height: 11%;
	background: #344d91;
	margin: 0;
	padding: 0;
}

#logo_wrapper {
	position: absolute;
	left: 250px;
	z-index: 3;
}

#logo_banner {
	display: inline;
	margin: auto;
	width: 100px;
	height: 100px;
}

#Honey_comB {
	display: inline;
	font-size: 38pt;
	color: #fff;
	vertical-align: middle;
}

#logo_a {
	text-decoration: none;
}

.container {
	position: absolute;
	left: 250px;
	padding: 0;
}

#col-md-12 {
	padding: 0;
}

#FBbtn {
	color: blue;
}

</style>

</head>
<body>
	<script type="text/javascript">
  // This is called with the results from from FB.getLoginStatus().
  function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
      // Logged into your app and Facebook.
      alert("로그인성공"); 
      testAPI();
    } else if (response.status === 'not_authorized') {
      // The person is logged into Facebook, but not your app.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into this app.';
    } else {
      // The person is not logged into Facebook, so we're not sure if
      // they are logged into this app or not.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into Facebook.';
    }
  }

  // This function is called when someone finishes with the Login
  // Button.  See the onlogin handler attached to it in the sample
  // code below.
  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
      
    });
  }

  window.fbAsyncInit = function() {
  FB.init({
    appId      : '2133525620205300',
    cookie     : true,  // enable cookies to allow the server to access 
                        // the session
    xfbml      : true,  // parse social plugins on this page
    version    : 'v2.5' // use graph api version 2.5
  });

  // Now that we've initialized the JavaScript SDK, we call 
  // FB.getLoginStatus().  This function gets the state of the
  // person visiting this page and can return one of three states to
  // the callback you provide.  They can be:
  //
  // 1. Logged into your app ('connected')
  // 2. Logged into Facebook, but not your app ('not_authorized')
  // 3. Not logged into Facebook and can't tell if they are logged into
  //    your app or not.
  //
  // These three cases are handled in the callback function.

  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });

  };

  // Load the SDK asynchronously
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  // Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', {fields: 'email, name, gender'},  function(response) {
    	var email = response.email;
    	var name = response.name;
    	var gender = response.gender;
    	window.location.replace("login/apiLogIn.do?email="+email+"&gender="+gender+"&name="+name);
    /* 	alert(response.email); 
    	alert(response.name);
    	alert(response.gender);
      console.log('Successful login for: ' + response.name);
      document.getElementById('status').innerHTML =
        'Thanks for logging in, ' + response.name + '!'; */
      
    });
  }
</script>
	<div id="home_banner">
		<div id="logo_wrapper">
			<img id="logo_banner" src="/HoneyComb_2_0/resources/img/logo.png"
				width="100" height="100" onclick="location.href='LoginMainFrame.do'">
			<a id="logo_a" href="LoginMainFrame.do"><p id="Honey_comB">HONEYCOMB</p></a>
		</div>
	</div>
	<div class="container" style="height: 89%; width: 80%;">
		<div class="cover">
			<div class="navbar navbar-default"></div>
			<div class="cover-image"
				style="background-image: url('/HoneyComb_2_0/resources/img/background.png')"></div>
			<div class="container" style="width: 70%;">

				<div class="col-md-12 text-center" id="col-md-12">
					<h1>HONEYCOMB</h1>
					<p>로그인페이지</p>
					<form class="form-horizontal text-center" method="post"
						onsubmit="return checkEmail()" name="myform">

						<input type="email" name="email" id="email" placeholder="Email">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
							type="password" name="passwd" id="passwd" placeholder="Password">
						<p></p>
						<p></p>
						<div class="checkbox">
							<label> <input type="checkbox" id="idSaveCheck"
								onClick="confirmSave(this)">이메일 저장
							</label>
							<p></p>
							<p></p>
						</div>
							
						<div id="buttoncheck">

							<button type="submit" class="btn btn-default">Sign in</button>
							<br>
							
							<!-- <a href="#" scope="public_profile,email" class="btn-social btn-facebook" id="FBbtn" onclick="FB.login();"> 
							<span class="fa fa-facebook">&nbsp;Facebook 계정으로 로그인하기</span></a> -->
							<br>
							<fb:login-button data-size="large" scope="public_profile,email" onlogin="checkLoginState();">Facebook 아이디로 로그인</fb:login-button>
							<br>
							<!-- 네이버아이디로로그인 버튼 노출 영역 -->
							<div id="naver_id_login">네이버 아이디로 로그인</div>
							<!-- //네이버아이디로로그인 버튼 노출 영역 -->
							<a href="signIn.do">회원가입</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="findEmail.do">Email</a>&nbsp;/&nbsp;
							<a href="findPasswd.do">Passwd 찾기</a>
						</div>

				</div>
			</div>
		</div>
	</div>
	</div>
<script type="text/javascript">
var naver_id_login = new naver_id_login("XxuZWIw4L8tP4C_0BW1_", "http://localhost:7777/HoneyComb_2_0/login/logIn.do");
var state = naver_id_login.getUniqState();
naver_id_login.setButton("green", 3,40);
naver_id_login.setDomain("/login/naverLogIn"); 
naver_id_login.setState(state);
naver_id_login.setPopup();
naver_id_login.init_naver_id_login();

// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
function naverSignInCallback() {
	var email = naver_id_login.getProfileData('email');
	var gender = naver_id_login.getProfileData('gender');
	var name = naver_id_login.getProfileData('nickname');
	window.opener.location.replace("login/apiLogIn.do?email="+email+"&gender="+gender+"&name="+name);
	window.close();
	// naver_id_login.getProfileData('프로필항목명');
	// 프로필 항목은 개발가이드를 참고하시기 바랍니다.
/* 	;
	alert(naver_id_login.getProfileData('nickname'));
	alert(naver_id_login.getProfileData('age'));
	alert(naver_id_login.getProfileData('gender'));
	alert(naver_id_login.getProfileData('birthday')); */
}

// 네이버 사용자 프로필 조회
naver_id_login.get_naver_userprofile("naverSignInCallback()");

</script>
</body>
</html>