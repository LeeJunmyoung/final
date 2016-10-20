<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<title>사업장 승인폼</title>



<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>


<style>
#complete_com_div {
	width: 70%;
	height: 89%;
	background: white;
	position: relative;
	left: 250px;
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

#compl {
	color: black;
	font-size: 15px;
}

#submit {
	width: 60px;
	margin: auto;
	margin-top: 2px;
	margin-bottom: 2px;
	margin-right: 5px;
	font-size: 13px;
}

#delete {
	width: 60px;
	margin: auto;
	margin-top: 2px;
	margin-bottom: 2px;
	margin-left: 5px;
	font-size: 13px;
}

#back_button_div {
	width: 100%;
	margin: 0 auto;
	text-align: center;
}

#button_center {
	margin: 0 auto;
	width: 100px;
}

.button {
	width: 100px;
	text-align: center;
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

#h1_tag {
	width: 500px;
	margin: auto;
	font-size: 40px;
	text-align: center;
}

h1 {
	width: 500px;
	margin: auto;
	text-align: center;
}

html {
	width: 100%;
	height: 100%;
}

body {
	background: #e9ebee;
	height: 100%;
}

#title td {
	background: #344d91;
	color: white;
	height: 30px;
}

#com_nn {
	width: 150px;
}

#compl_table tr {
	height: 35px;
}
</style>
<script>
	function listCheck(com_num) {
		;
		url = "admin_comCheck?com_num=" + com_num;
		window
				.open(
						url,
						"post",
						"toolbar=no,width=700,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");

	}

	function del(com_num) {
		;
		url = "admin_comDelete?com_num=" + com_num;

		window
				.open(
						url,
						"post",
						"toolbar=no,width=600,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");

	}

	function submitCheck(com_num) {
		;
		url = "admin_comInsert?com_num=" + com_num;
		window
				.open(
						url,
						"post",
						"toolbar=no,width=600,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
</script>
</head>
<body background='e9ebee'>




	<div id="home_banner">
		<div id="logo_wrapper">
			<img id="logo_banner" src="/HoneyComb_2_0/resources/img/logo.png"
				width="80" height="80"
				onclick="location.href='/HoneyComb_2_0/admin/admin_mainPage'">
			<a id="logo_a" href="/HoneyComb_2_0/admin/admin_mainPage"><p
					id="Honey_comB">HONEYCOMB</p></a>
		</div>
	</div>



	<div id='complete_com_div'>

		<div id='h1_tag'>
			<br>Company Approval
			<hr>
		</div>
		<br> <br> <br> <br>
		<form align="center">
			<table width="400" border="1" cellpadding="1" cellspacing="0"
				align="center" id="compl_table">
				<tbody>
					<c:if test="${ empty admincomplete }">
						<tr>
							<td align="center">신청한 사업장이 없습니다</td>
						</tr>
					</c:if>
					<c:if test="${ !empty admincomplete }">
						<tr id="title">
							<td id="com_nn">사업장명</td>
							<td>등록 / 삭제</td>
						</tr>
						<c:forEach var="admincomplete" items="${admincomplete}">
							<tr>
								<td><a onclick="listCheck('${admincomplete.com_num}')"
									id="compl">${admincomplete.com_name}</a></td>
								<td id="compl_button"><input type="submit"
									class="btn btn-primary btn-xs" id="submit" value="등록"
									onclick="submitCheck('${admincomplete.com_num}')"> <input
									type="button" class="btn btn-primary btn-xs" id="delete"
									value="삭제" onclick="del('${admincomplete.com_num}')"></td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
			<br> <br> <br> <br>
			<div id="back_button_div">
				<div id="button_center">
					<a href="/HoneyComb_2_0/admin/admin_mainPage" class="button">뒤로가기</a>
				</div>
			</div>

		</form>

	</div>
</body>
</html>
