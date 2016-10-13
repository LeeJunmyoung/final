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
	function close() {

		opener.location.reload();
		window.close();
	}
</script>
</head>
<body>
	<center>
		<p>완료되었습니다</p>
		<input type="button" value="닫기" class="button"
			onclick="close()" />
	</center>
</body>
</html>
