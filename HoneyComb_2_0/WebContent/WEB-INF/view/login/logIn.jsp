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

<script type="text/javascript"
	src="/HoneyComb_2_0/resources/script/script.js"></script>
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
	var url="https://nid.naver.com/oauth2.0/authorize?client_id=XxuZWIw4L8tP4C_0BW1_&response_type=code&redirect_uri=login/LoginMainFrame.do(UTF-8)";
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
	<div id="fb-root"></div>
	<script>(function(d, s, id) {
 /*  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v2.8";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk')); */</script>
	<script>
  
        function statusChangeCallback(response) {
             console.log('statusChangeCallback'); 
             console.log(response);
             if (response.status === 'connected') {
                alert('로그인 성공!');
                
            } else if (response.status === 'not_authorized') {
                alert('Please log ' + 'into this app.');
            } else {
                alert('Please log ' + 'into Facebook.');
            } 
        } 
 
        function checkLoginState() {
            FB.getLoginStatus(function(response) {
                statusChangeCallback(response);
            });
        }
 
        window.fbAsyncInit = function() {
            FB.init({
                appId : '2133525620205300',
                xfbml : true,
                version : 'v2.8'
            });
 
            FB.getLoginStatus(function(response) {
                statusChangeCallback(response);
            });
 
        FB.Event.subscribe('auth.logout', function(response) {
                document.location.reload();
        });
 
        };
 
        (function(d, s, id) {
            var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id))
                return;
            js = d.createElement(s);
            js.id = id;
            js.src = "//connect.facebook.net/en_US/sdk.js";
            fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));
         
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
							<br> <a href="#" class="btn-social btn-facebook" id="FBbtn"
								onclick="FB.login();"> <span class="fa fa-facebook">
									&nbsp;Facebook 계정으로 로그인하기</span></a>
									<p>
									<a href="javascript:openNaver()">네이버 로그인 나는냐 CSS 파괴자</a>
									</p>
							</p>
							<a href="signIn.do">회원가입</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="findEmail.do">Email</a>&nbsp;/&nbsp;
							<a href="findPasswd.do">Passwd 찾기</a>
						</div>

						<a href="#" onclick="FB.logout();">[logout]</a><br>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>