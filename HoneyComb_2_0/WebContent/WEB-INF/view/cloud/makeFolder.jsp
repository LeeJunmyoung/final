<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script>
$(function(){
	$("#folder").keyup(function(){
		var regExp = /^[^\|/*?<>:]$/
		if($("#folder").val() ==""){
			$("#dupli").html("")			
		}
		else if(regExp.test($("#folder").val())){
			$("#dupli").html("<font color=red size=2>특수문자 (\\ , | , / , * , ? , < , > , : )는 사용하실 수 없습니다..")
		}else{
		$.ajax({
			type:"POST",
			url:"dupleCk",
			data:{
				"item":$("#folder").val(),
				"folder":'${folder}'
			},
			success:function(data){
				if(data == 0){
					$("#dupli").html("<font color=#344D91>사용가능한 이름 입니다.")
				}else{
					$("#dupli").html("<font color=red>사용불가능한 이름 입니다.")
				}
				
			}
		})
		}
		
	})
})

</script>


</head>
<body>
 생성할 폴더명을 입력해 주세요
 <form action="makeFolderPro">
 	<input type="text" name="folder" id="folder">
 	<input type="submit" value="확인">
 	<p id="dupli"/>
 </form>
 
</body>
</html>