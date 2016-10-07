<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script>
	function logout() {

		var out = confirm("정말 로그아웃 하시겠습니까?");

		if (out) {
			location.href = "/HoneyComb_2_0/main/logout.do";
		} else {
			return false;
		}

	}
</script>
<style>
li {
	font-size: 18px;
}
</style>
</head>
<body>
	<div id="menu_div">
		<h1 align="center">${ sessionScope.com_name }</h1>

		<h2>
			<img src="${ sessionScope.profile_img }" width="150" height="153"
				onerror="this.src='/HoneyComb_2_0/resources/images/user.png'"
				title="내 프로필 사진">
		</h2>

		<h2 id="my_profile">${ sessionScope.name }</h2>

		<br /> <br />
		<ul class="nav nav-pills nav-stacked">

			<li><a href="/HoneyComb_2_0/chatting/mainchat.do">MESSAGE</a></li>
			<li><a href="/HoneyComb_2_0/cloud/main">CLOUD</a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"> HR<span class="dropdown-menu"></span>
			</a>
				<ul class="dropdown-menu">
					<li><a href="#">APPROVAL</a></li>
					<li><a href="/HoneyComb_2_0/salary/main.do">SALARY</a></li>
					<li><a href="/HoneyComb_2_0/dept/chart">DEPT</a></li>
				</ul></li>
			<li><a href="/HoneyComb_2_0/mypage/mypage">MYPAGE</a></li>
			<li><a href="#logout" onclick="logout();return false;"
				onkeypress="this.onclick;">LOG OUT</a></li>

		</ul>

	</div>
</body>
</html>
