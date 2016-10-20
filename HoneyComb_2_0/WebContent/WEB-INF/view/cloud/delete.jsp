<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<table style="table-layout: auto; margin: auto;">
	<tr class="delTable_upper">
		<td class="delForm">파일명</td>
		<td class="delForm">저장자</td>
		<td class="delForm">저장날짜</td>
		<td class="delForm">파일크기</td>	
	</tr>
		<c:forEach items="${deleteInfo}" var="info">
		<fmt:formatDate value="${info.file_date}" pattern="yyyy-MM-dd" var="file_date"/>
		<tr class="delTable_Lower">
			<td style="display: none;"><input type="hidden" value="${info.file_num}" name="file_num"></td>
			<td class="delForm_lower">${info.file_name}</td>
			<td class="delForm_lower">${info.file_uploader}</td>
			<td class="delForm_lower">${file_date}</td>
			<td class="delForm_lower">${info.file_size}</td>
		</tr>
		
		</c:forEach>
	</table>
	<div style="text-align: center;">
		위 파일들을 삭제하시겠습니까?
	</div>
	<div style="text-align: center; margin-top: 10px;">
		<input type="submit" class="basicButton" value="예">
		<input type="button" class="basicButton" value="취소" onclick="closeit()">
	</div>
</form>
</body>
</html>