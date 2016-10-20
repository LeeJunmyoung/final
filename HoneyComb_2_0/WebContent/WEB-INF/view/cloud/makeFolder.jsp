<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="/HoneyComb_2_0/resources/script/cloudScript.js"></script>
<script>
$(function(){
if('${param.upload}'){
		opener.location.reload();
		window.close();
	}; 
$("#folder").keyup(function(){
	var item = $("#folder").val();
	duplInit();
	blankCk(item);
	specialCharCk(item);
	var folder = '${param.folder}';
	dupliCk(item ,folder,0)
	});
});
			
</script>
<link rel="stylesheet" href="/HoneyComb_2_0/resources/css/cloud.css">
</head>
<body>
 <p style="text-align: center">생성할 폴더명을 입력해 주세요<p>
 <form method="post" action="/HoneyComb_2_0/cloud/makeFolder">
 <div style="text-align: center;">
 	<input type="text" name="item" id="folder">
 </div>
 	<input type="hidden" name="folder" value="${param.folder}">
 	<div style="text-align: center; margin-top: 10px">
 	<input type="submit" class="basicButton" value="확인" id="submit" disabled="disabled">
 	</div>
 	<p id="dupli" style="text-align: center;"/>
 </form>
 
</body>
</html>