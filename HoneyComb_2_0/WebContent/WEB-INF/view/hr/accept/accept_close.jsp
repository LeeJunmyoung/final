<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>


<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script type="text/javascript">
	function close_page() {
		opener.location.reload();

		window.close();
	}
</script>
<style>
p {
	margin: 0 auto;
	text-align: center;
}

#div_button {
	width: 100%;
	margin: 0 auto;
	text-align: center;
}

.button {
	width: 80px;
	margin-bottom: 2px;
	margin-left: 5px;
	background-color: #4367b0;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	cursor: pointer;
	color: #fff;
	font-size: 14px;
	padding: 5px 10px;
	text-decoration: none;
	text-align: center;
}

.button:hover {
	background-color: #344d91;
	color: white;
}
</style>
</head>
<body style="background: #e9ebee;">
	<!-- resume 기본정보등록시 -->

	<p>완료되었습니다</p>
	<br>
	<div id="div_button">
		<a href="#" onclick="close_page()" class="button">닫기</a>
	</div>

</body>
</html>
