<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SelectUploadFile</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="/HoneyComb_2_0/resources/script/cloudScript.js"></script>
<script>
$(function(){
	if ('${param.upload}') {
			opener.location.reload();
			window.close();
		};
	$("#uploadFile").change(function(){
		duplInit()
		fullPath = $("#uploadFile").val();
		blankCk(fullPath);
		specialCharCk($("#folder").val());
		cPath = fullPath.lastIndexOf("\\");
		fName = fullPath.substring(cPath+1);
		folder = '${param.folder}';
		dupliCk(fName,folder);
	})
});
</script>

</head>
<body>
	<form name="form"	enctype="multipart/form-data" method="post">
		<input type="file" name="uploadfile" id="uploadFile">
		<c:if test="${com_pos_num < 3}">
			보안설정<input type="checkbox" name="security">
		</c:if>
		<input type="submit" id="submit" value="업로드" disabled="disabled">
		<p id="dupli"/>
		<c:if test="${promgrnum ne null|| promgrnum != 0}">
			<input type="hidden" name="promgr_num" value="${promgr_num}">
			<input type="hidden" name = "promgr_name" value="${promgr_name}"> 
		</c:if>
	</form>
	
</body>
</html>