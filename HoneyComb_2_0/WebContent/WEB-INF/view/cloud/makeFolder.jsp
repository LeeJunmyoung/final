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
	var folder = '${folder}';
	dupliCk(item ,folder)
	});
});
			
</script>


</head>
<body>
 생성할 폴더명을 입력해 주세요
 <form method="post">
 	<input type="text" name="item" id="folder">
 	<input type="hidden" name="folder" value="${folder}">
 	<input type="submit" value="확인" id="submit" disabled="disabled">
 	<p id="dupli"/>
 </form>
 
</body>
</html>