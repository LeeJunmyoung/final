<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>admin comSelect</title>
</head>
<body>
<c:forEach var="adminlist" items="${adminlist}">
	<div>
	${adminlist.com_num}<br>
	${adminlist.com_name}<br>
	${adminlist.com_add}<br>
	${adminlist.com_phone}<br>
	${adminlist.com_aff}<br>
	</div>
</c:forEach>
</body>
</html>