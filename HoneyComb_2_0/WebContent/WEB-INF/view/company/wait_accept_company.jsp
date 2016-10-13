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

<style type="text/css">
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

.row {
	position: relative;
	left: -65px;
}
</style>

</head>
<body>
	<%
		request.getSession().invalidate();
	%>
	<div id="home_banner">
		<div id="logo_wrapper">
			<img id="logo_banner" src="/HoneyComb_2_0/resources/img/logo.png"
				width="80" height="80"
				onclick="location.href='/HoneyComb_2_0/index.jsp'"> <a
				id="logo_a" href="/HoneyComb_2_0/index.jsp"><p id="Honey_comB">HONEYCOMB</p></a>
		</div>
	</div>
	<div class="container" style="height: 89%; width: 80%;">
		<div class="cover">
			<div class="navbar navbar-default"></div>
			<div class="cover-image"></div>
			<div class="container" style="width: 70%;">
				<div class="row">
					<div class="col-md-12 text-center">

						<h3>승인 대기중</h3>
						<img src="/HoneyComb_2_0/resources/images/wait.gif" width="430px"
							height="300px">
						<p>
						<p>
							<button
								onclick="location.href='/HoneyComb_2_0/login/LoginMainFrame.do'"
								class="btn btn-default">확인</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
