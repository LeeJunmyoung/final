<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form commandName="membersInfo">
		<p>
			<form:label path="email">Email</form:label>
			<form:input path="email" />
			<form:errors path="email" />
		</p>
		<p>
			<form:label path="passwd">Passwd</form:label>
			<form:input path="passwd" />
			<form:errors path="passwd" />
		</p>
		<p>
			<form:label path="passwd">checkPasswd</form:label>
			<form:input path="passwd" />
			<form:errors path="passwd" />
		</p>
		<p>
			<form:label path="name">Name</form:label>
			<form:input path="name" />
			<form:errors path="name" />
		</p>
		<p>
			<form:label path="phone_num">PhoneNum1</form:label>
			<form:input path="phone_num" />
			<form:errors path="phone_num" />
		-
			<form:label path="phone_num">PhoneNum2</form:label>
			<form:input path="phone_num" />
			<form:errors path="phone_num" />
		-
			<form:label path="phone_num">PhoneNum3</form:label>
			<form:input path="phone_num" />
			<form:errors path="phone_num" />
		</p>
			<input type="submit" value="회원가입">
	</form:form>
</body>
</html>