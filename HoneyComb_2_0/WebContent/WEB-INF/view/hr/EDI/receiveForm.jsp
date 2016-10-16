<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수신처</title>
<script type="text/javascript">

$(document).ready(function() {
	$('p').mouseenter(function() {

	var c = $(this).text();	
	$("#dept_name", opener.document).text(c);
	alert(c+'을 수신부서로 선택하셨습니다.');
	window.close();
	
	})
	
	
	
});

</script>



</head>
<body>
<h4>수신 부서를 선택하세요</h4>
<c:forEach var="dept_name" items="${dept_Name_EDI }">


<p id="dept_name">${dept_name}</p><br>
<hr>
</c:forEach>



</body>
</html>