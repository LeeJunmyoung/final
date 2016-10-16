<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script>
function close_page() {
	alert("등록되었습니다");
	opener.opener.location.reload();
	opener.location.reload();
	
	window.close();
}
</script>
</head>
<body onload="close_page()">

</body>
</html>