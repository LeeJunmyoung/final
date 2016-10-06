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
		var regExp = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
		$("#submit").attr("disabled",false);
		if($("#folder").val() ==""){
			$("#dupli").html("")
			$("#submit").attr("disabled",true);
		}
		else if(regExp.test($("#folder").val())){
			
			$("#dupli").html("<font color=red size=2>특수문자 (\\ , | , / , * , ? , < , > , :, ;, `, ~, !, @, #, $, %, ^, & )는 사용하실 수 없습니다..")
			$("#submit").attr("disabled",true);
		}else{
			var item = $("#folder").val();
			var folder = '${folder}';
			dupliCk(item ,folder)
		}
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