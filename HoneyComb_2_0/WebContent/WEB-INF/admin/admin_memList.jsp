<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>admin memList</title>
</head>
<body>
	<table width="800" border="1" cellpadding="1" cellspacing="0"
		align="center" id="memCheck_table">
		<c:if test="${ empty adminlist }">
			<p align="center">
				<font color="red">Warning : Have No ComMemberList</font>
			</p>
		</c:if>
		<c:if test="${ !empty adminlist }">
			<tr>
				<td width="70" class="title" align="center">MemberName</td>
				<td width="150" class="title" align="center">Email</td>
				<td width="100" class="title" align="center">PhoneNumber</td>
				<td width="70" class="title" align="center">Department</td>
				<td width="70" class="title" align="center">position</td>
			</tr>
			<c:forEach var="adminlist" items="${ adminlist }">
				<br>
				<tr>
					<td width="70" align="center">${ adminlist.name }</td>
					<td width="150" align="center">${ adminlist.email }</td>
					<td width="100" align="center">${ adminlist.phone_num }</td>
					<td width="70" align="center">${ adminlist.com_dept_name }</td>
					<td width="70" align="center">${ adminlist.com_pos_name }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>