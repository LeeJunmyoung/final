<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<title>승인 완료</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>

<style>
#close_button {
	position: relative;
	top: 60px;
}

#close_button {
	width: 50px;
	margin: auto;
}

#close_button_div {
	width: 60px;
	margin: auto;
}

#h1_tag {
	width: 500px;
	margin: auto;
	font-size: 40px;
	text-align: center;
}
</style>
</head>
<script>
	opener.location.reload();
</script>
<body>
	<div id="h1_tag">
		<br>등록이 완료 되었습니다.
	</div>
	<div id="close_button_div">

		<input type="button" class="btn btn-primary btn-xs" value="close"
			id='close_button' onclick="window.close()">
	</div>

</body>
</html>