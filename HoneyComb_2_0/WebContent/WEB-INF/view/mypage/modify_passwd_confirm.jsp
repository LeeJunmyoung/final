<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>비밀번호 확인</title>

<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script>
	var check_pw = false;

	function PW_Check(pw) {

		var passwd = pw;
		alert(passwd);
		check_pw = 0;
		if (document.pwChange.pw.value == "") {
			alert("비밀번호를 입력하세요");
			document.pwChange.pw.focus();
			check_pw = false;
			return false;
		}

		if (document.pwChange.pw.value == passwd) {
			alert("비밀번호가 일치합니다!");
			document.pwChange.newpw1.focus();
			check_pw = true;
			return false;
		}

		if (!document.pwChange.pw.value != passwd) {
			alert("비밀번호가 일치하지 않습니다!");
			document.pwChange.pw.focus();
			check_pw = false;
			return false;
		}

	}

	function PW_Same() {

		if (check_pw == false) {
			alert("인증부터 받으세요");
			return false;
		}
		if (document.pwChange.newpw1.value != document.pwChange.newpw2.value
				|| document.pwChange.newpw1.value == ""
				|| document.pwChange.newpw2.value == "") {
			alert("변경할 비밀번호를 확인하세요");
			document.pwChange.newpw1.focus();
			return false;
		} else {
			alert("비밀번호가 성공적으로 변경되었습니다");
			//window.close();
			return true;
		}
	}
</script>
<style>
body {
	top: 2%;
}

.button {
	background-color: #4367b0;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	display: block;
	cursor: pointer;
	color: #fff;
	font-size: 15px;
	padding: 5px 10px;
	text-decoration: none;
	margin: 0 auto;
}

.button:hover {
	background-color: #344d91;
	color: white;
}

.button:active {
	position: relative;
	top: 1px;
}

input[type=password] {
	height: 30px;
	border-radius: 5px 5px 5px 5px;
	font-size: 16px;
	padding-left: 10px;
	text-align: lift;
	margin-top: 5px;
	margin-left: 15px;
}

hr {
	width: 200px;
	border-top: 1px solid #bbb;
	border-bottom: 1px solid #bbb;
	margin-top: -10px;
	margin-bottom: 30px;
}

.che {
	display: inline-block;
	margin-bottom: 20px;
	text-align: center;
}

table td {
	position: relative;
	margin: 0 auto;
	text-align: center;
}

#close {
	position: relative;
	margin: 0 auto;
	text-align: center;
}

.pw_text {
	text-align: right;
}
</style>
</head>
<body>

			<form align="center" name="pwChange" method="post"
				action="passwd_change"
				onsubmit="return PW_Same()">
				<h3>비밀번호 변경</h3>
				<p>
				<table align="center">
					<tr>
						<td class="pw_text">현재 비밀번호</td>
						<td><input width="100" height="50" type="password" id="pw" name="pw"
							placeholder="PASSWORD"></td>
						<td><input type="button" class="button"
							onclick="return PW_Check('${passwd}')" value="확인"></td>
					</tr>
					<tr>
						<td class="pw_text">새로운 비밀번호</td>
						<td><input type="password" id="newpw1" name="newpw1" placeholder="NEW PASSWORD"></td>
					</tr>
					<tr>
						<td class="pw_text">새로운 비밀번호 확인</td>
						<td><input type="password" id="newpw2"  placeholder="NEW PASSWORD"></td>
						<td><input type="submit" class="button" value="변경"></td>
					</tr>
				</table>
				<br/>
				<br/>
				<div class="che">
					<input type="button" value="뒤로가기" class="button" id="close"
						onclick="javascipt:location.href='/HoneyComb_2_0/mypage/mypage'">
				</div>
			</form>

</body>
</html>
