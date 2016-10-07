<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script>
	function init() {
		window.location.reload(true);
	}

	function passwd_confirm() {
		// 비밀번호 변경 폼

		var url = '/HoneyComb_2_0/mypage/passwd_ch_view';
		open(url, "비밀번호 변경", "toolbar=no,location=no,status=no,menubar=no,"
				+ "scrollbars=no,left=400,top=200,width=500,height=300");

	}

	function view_resume() {

		/* "final_test/mem_resume.do?mem_num=" + mem_num */
		var url = '/HoneyComb_2_0/mypage/my_resume';
		open(url, "이력서",
				"toolbar=no,location=no,status=no,menubar=no scrollbars=no,resizable=no,"
						+ "left=600, top=200,width=700,height=920");
	}

	function user_del() {
		// 계정 삭제 폼

		var url = '/HoneyComb_2_0/mypage/account_drop';
		open(url, "계정 삭제", "toolbar=no,location=no,status=no,menubar=no,"
				+ "scrollbars=no,left=400,top=20,width=500,height=300");

	}

	function file_extension(form) {
		// img파일인지 확인

		var check = document.profile_img_upload.file_route.value; // 파일명
		var extension = check.substr(check.length - 3); // 확장자
		if (!(extension == 'png' || extension == 'bmp' || extension == 'gif' || extension == 'jpg')) {
			// 사진파일이 아닐때

			alert("사진 파일만 선택해주세요\n * png, bmp, gif, jpg \n");
			return false;

		} else if (extension == 'png' || extension == 'bmp'
				|| extension == 'gif' || extension == 'jpg') {
			// 사진파일일때 action실행

			window.location.reload();
			return true;
		}
		return false;
	}
	var input;
	var input_value;

	$(document).ready(function() {
		$('.file_wrap').click(function() {

			$('#profile_img').click();
		});

		$('#profile_img').change(function() {
			input = $(this).val();
			input_value = input.replace("C:\\fakepath\\", "");
			$('.file_text').val(input_value);
		});

	});
</script>

<style>
table, tr, th, td {
	margin: 0 auto;
	border-collapse: collapse;
	border: 1px solid #bbb;
	cellpadding: 0;
	cellspacing: 0;
	font-size: 14px;
	padding: 10px;
	width: 400px;
	height: 20px;
}

input[type=text] {
	height: 30px;
	border-radius: 5px 5px 5px 5px;
	font-size: 16px;
	padding-left: 10px;
	text-align: lift;
}

#top {
	width: 300px;
	height: 70px;
	text-align: center;
	margin: 0 auto;
}

#h2_title {
	font-size: 30px;
}

/* 상단 프로필 */
#div_pro_map {
	width: 400px;
	height: 150px;
	margin: 0 auto;
}

#div_pro {
	width: 150px;
	height: 150px;
	float: left;
	text-align: center;
	border-radius: 100px;
}

#div_pro_search {
	width: 230px;
	height: 150px;
	float: right;
	text-align: center;
}

#img_myprofile {
	width: 100px;
	height: 104px;
	width: 100px;
	margin-top: 20px;
	border: 3px solid black;
	border-radius: 80px;
}
/* 상단 프로필 */

/* file */
#div_file_search {
	float: right;
	margin: 0 auto;
	margin-top: 40px;
	padding: 5px;
	width: 210px;
	height: 35px;
}

.file_text {
	float: left;
	width: 150px;
	height: 16px;
}

.file_wrap {
	display: inline-block;
	width: 30px;
	height: 30px;
	margin-bottom: 5px;
	background: url(/HoneyComb_2_0/resources/images/search_one.png)
		no-repeat;
	background-size: 30px;
	cursor: pointer;
}

.file_wrap:HOVER {
	width: 30px;
	height: 30px;
	background: url(/HoneyComb_2_0/resources/images/search_two.png)
		no-repeat;
	background-size: 30px;
}

.file_hidden {
	position: absolute;
	left: -9999px;
	width: 30px;
	height: 30px;
	width: 30px;
	width: 30px;
	left: -9999px;
}
/* file */

/* table */
#div_table {
	border: 1px solid #bbb;
	width: 400px;
	height: 218px;
	margin: 0 auto;
	margin-top: 20px;
}

.title {
	width: 180px;
	text-align: center;
	font-size: 16px;
	margin: 0 auto;
}
/* table */

/* func_img */
.div_img_map {
	float: right;
	width: 80px;
	height: 60px;
}

.div_img {
	width: 20px;
	height: 40px;
	float: right;
	margin-top: 20px;
}

.click_img {
	width: 20px;
	height: 20px;
}

/* function */
#div_func {
	margin: 0 auto;
	margin-top: 15px;
	width: 400px;
	height: 185px;
	border-top: 3px solid #bbb;
	border-bottom: 3px solid #bbb;
}

.functions {
	width: 400px;
	height: 60px;
	margin: 0 auto;
}

.div_text {
	width: 295px;
	height: 40px;
	float: left;
	padding-left: 15px;
	left: 10px;
	text-align: left;
	top: 40px;
	margin-top: 15px;
	line-height: 25px;
}

#div_pw {
	margin-bottom: 5px;
}

#passwd_ch, #account_drop, #resume_ch {
	width: 40px;
	height: 40px;
	float: right;
	text-align: center;
	margin-top: 10px;
}

#passwd_ch {
	margin-right: 3px;
}

#div_line {
	border-top: 1px solid #bbb;
	border-bottom: 1px solid #bbb;
}
/* function */

/* image */
a#pw {
	display: block;
	width: 40px;
	height: 40px;
	background: url(/HoneyComb_2_0/resources/images/pw_one.png) no-repeat;
	background-size: 40px;
	margin: 0 auto;
}

a:HOVER#pw {
	background: url(/HoneyComb_2_0/resources/images/pw_two.png) no-repeat;
	background-size: 40px;
	cursor: pointer;
}

a#pw span {
	display: none;
}

a#resume {
	display: block;
	width: 40px;
	height: 40px;
	background: url(/HoneyComb_2_0/resources/images/resume_one.png)
		no-repeat;
	background-size: 40px;
	margin: 0 auto;
}

a:HOVER#resume {
	background: url(/HoneyComb_2_0/resources/images/resume_two.png)
		no-repeat;
	background-size: 40px;
	cursor: pointer;
}

a#resume span {
	display: none;
}

a#account {
	display: block;
	width: 40px;
	height: 40px;
	background: url(/HoneyComb_2_0/resources/images/account_one.png)
		no-repeat;
	background-size: 40px;
	margin: 0 auto;
}

a:HOVER#account {
	background: url(/HoneyComb_2_0/resources/images/account_two.png)
		no-repeat;
	background-size: 40px;
	cursor: pointer;
}

a#account span {
	display: none;
}
/* image */

/* button */
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
	margin-top: 10px;
	margin-right: 60px;
}

.button:hover {
	background-color: #344d91;
	color: white;
}

.button:active {
	position: relative;
	top: 1px;
}

.che {
	margin: 0 auto;
	margin-bottom: 20px;
	text-align: center;
	width: 90px;
	height: 40px;
}
/* button */
</style>



</head>
<body onselectstart="return false" ondragstart="return false">

	<div id="top">
		<h2 id="h2_title">My Page</h2>
	</div>
	<div id="div_pro_map">

		<div id="div_pro">
			<img src="${ sessionScope.profile_img }" name="profile_img"
				onerror="this.src='/HoneyComb_2_0/resources/images/user.png'"
				id="img_myprofile">
		</div>

		<div id="div_pro_search">

			<form name="profile_img_upload" method="post"
				enctype="multipart/form-data" action="#"
				onsubmit="return file_extension(this);">
				<div id="div_file">
					<div id="div_file_search">
						<input type="text" id="file_route" name="file_route"
							class="file_text" readonly /> <span class="file_wrap"> </span> <input
							type="file" value="선택" name="profile_img" id="profile_img"
							class="file_hidden" /> <input type="submit" value="프로필 사진 등록"
							class="button" />
					</div>
				</div>
			</form>

		</div>
	</div>

	<div id="div_table">
		<table>

			<tr>
				<td class="title">name</td>
				<td>${ sessionScope.name }</td>
			</tr>

			<tr>
				<td class="title">e-mail</td>
				<td>${ sessionScope.email }</td>
			</tr>

			<tr>
				<td class="title">cell-phone</td>
				<td>${ sessionScope.phone_num }</td>
			</tr>

			<tr>
				<td class="title">depertment</td>
				<td>${ sessionScope.com_dept_name }</td>
			</tr>

			<tr>
				<td class="title">position</td>
				<td>${ sessionScope.com_pos_name }</td>
			</tr>

		</table>
	</div>

	<div id="div_func">

		<div class="functions">
			<div class="div_text" id="div_pw">
				<p>현재 비밀번호를 변경하시겠습니까?</p>
			</div>
			<div class="div_img_map">
				<div class="div_img">
					<img src="/HoneyComb_2_0/resources/images/click.png"
						class="click_img" />
				</div>
				<div id="passwd_ch">
					<a onclick="passwd_confirm()" id="pw"
						title="password change"><span>pwChange</span></a>
				</div>
			</div>

		</div>

		<div class="functions" id="div_line">

			<div class="div_text">
				<p>이력서를 조회 및 수정할 수 있습니다</p>
			</div>
			<div class="div_img_map">
				<div class="div_img">
					<img src="/HoneyComb_2_0/resources/images/click.png"
						class="click_img" />
				</div>
				<div id="resume_ch">
					<a onclick="view_resume()" id="resume"
						title="my resume view"><span>resumeView</span></a>
				</div>
			</div>

		</div>

		<div class="functions">
			<div class="div_text">
				<p>HoneyComb 계정을 삭제할 수 있습니다</p>
			</div>
			<div class="div_img_map">
				<div class="div_img">
					<img src="/HoneyComb_2_0/resources/images/click.png"
						class="click_img" />
				</div>
				<div id="account_drop">
					<a onclick="user_del()" id="account"
						title="account drop"><span>accountDrop</span></a>
				</div>
			</div>

		</div>

	</div>

	<br />
	<br />

</body>
</html>
