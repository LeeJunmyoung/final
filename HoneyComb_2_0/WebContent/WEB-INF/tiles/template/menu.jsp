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

	$(function() {
		$("#dropdown").click(function() {
			if ($("#dropdown ul", this).css("display") == "none") {
				$("#dropdown ul").slideUp("fast");
			} else {
				$("#dropdown ul").slideDown("fast");
			}
		});
	});
</script>

<style>
li {
	font-size: 18px;
}

#dropdown {
	cursor: pointer;
}

#dropdown ul {
	display: none;
}

#dropdown ul li{
	font-size: 7pt;
}
</style>

</head>
<body>
	<div id="menu_div">
		<h1 align="center">${ sessionScope.com_name }</h1>

		<h2>
			<img src="${ sessionScope.profile_img }" width="130" height="156"
				onerror="this.src='/HoneyComb_2_0/resources/images/user.png'"
				title="내 프로필 사진">
		</h2>

		<h2 id="my_profile">${ sessionScope.name }</h2>

		<br /> <br />
		<ul class="nav nav-pills nav-stacked">

			<li><a href="/HoneyComb_2_0/chatting/mainchat.do">MESSAGE</a></li>
			<li><a href="/HoneyComb_2_0/cloud/main">CLOUD</a></li>

			<li id="dropdown"><a>HR <span class="caret"></span></a>
				<ul class="nav nav-pills nav-stacked">
					<li><a href="/HoneyComb_2_0/EDI/EDI_Main.do">EDInterchage</a></li>
					<li><a href="/HoneyComb_2_0/dept/chart">DEPT</a></li>
					<c:if test="${ sessionScope.com_pos_num <= 4 }">
					<li><a href="/HoneyComb_2_0/accept/accept">ACCEPT</a></li>
					</c:if>
					<li><a href="/HoneyComb_2_0/salary/user_main.do">SALARY</a></li>

					<c:if test="${sessionScope.com_dept_num == 2 and sessionScope.com_dept_num == 0}">
						<li><a href="/HoneyComb_2_0/salary/management_main.do">SALARY MANAGEMENT</a></li>
					</c:if>
				</ul></li>

			<li><a href="/HoneyComb_2_0/mypage/mypage">MYPAGE</a></li>
			<li><a href="#logout" onclick="logout();return false;"
				onkeypress="this.onclick;">LOG OUT</a></li>

		</ul>

	</div>
</body>
</html>
