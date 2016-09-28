<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>admin comSelect</title>

<script>
function memberList(com_num) {

	 url = "admin_memList?com_num=" + com_num;
	window.open(url, "post", "toolbar=no,width=1000,height=400,directories=no,status=yes,scrollbars=yes,menubar=no");
}
</script>

</head>
<body>
	<table border='1px' id="memCheck_table">
		<c:if test="${ !empty adminlist }">
			<tr id='visible_tr'>
				<td width="100" class="title" align="center">Company</td>
				<td width="250" class="title" align="center">Address</td>
				<td width="70" class="title" align="center">Affiliation</td>
				<td width="150" class="title" align="center">PhoneNumber</td>
				<td width="70" class="title" align="center">Detail</td>
			</tr>
			<c:forEach var="adminlist" items="${ adminlist }">
				<tr id="text" name="${ adminlist.com_name }">
					<td width="100" align="center">${ adminlist.com_name }</td>
					<td width="250" align="center">${ adminlist.com_add }</td>
					<td width="70" align="center">${ adminlist.com_aff }</td>
					<td width="150" align="center">0${ adminlist.com_phone }</td>
					<td><input type="button" class="btn btn-primary btn-xs"
						value="memberList" onclick="memberList(${ adminlist.com_num })"></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>