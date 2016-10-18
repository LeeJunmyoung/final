<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

if(!"${deleteInfo}"){
	opener.location.reload();
	closeit()
	};
function closeit(){
	window.close()
}
</script>
<link rel="stylesheet" href="/HoneyComb_2_0/resources/css/cloud.css">
</head>
<body>
<form action="deletePro">
	<table>
	<tr>
		<td>파일명</td>
		<td>저장자</td>
		<td>저장날짜</td>
		<td>파일크기</td>	
	</tr>
		<c:forEach items="${deleteInfo}" var="info">
		<input type="hidden" value="${info.file_num}" name="file_num">
		<tr>
			<td>${info.file_name}</td>
			<td>${info.file_uploader}</td>
			<td>${info.file_date}</td>
			<td>${info.file_size}</td>
		</tr>
		</c:forEach>
	</table>
	위 파일들을 삭제하시겠습니까?
	<input type="submit" class="basicButton" value="예">
	<input type="button" class="basicButton" value="취소" onclick="closeit()">
</form>
</body>
</html>