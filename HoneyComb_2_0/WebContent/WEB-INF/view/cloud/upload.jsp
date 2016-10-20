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
		dupliCk(fName,folder,'${promgr_num}');
	})
	var file_Target=$('.file_upload .upload_hidden');
	file_Target.on('change', function(){  // 값이 변경되면
	 	    if(window.FileReader){  // modern browser
	 	      var filename = $(this)[0].files[0].name;
	 	    }
	 	    // 추출한 파일명 삽입
	 	    $(this).siblings('.upload_name').val(filename);
	 	  });
	$("input:checkbox").change(function(){
		if($(this).is(":checked")){
			$("#secureimg").attr('src',"/HoneyComb_2_0/resources/images/cloud_img/secured.png");
		}else{
			$("#secureimg").attr('src',"/HoneyComb_2_0/resources/images/cloud_img/unlock.jpg");
		};
		
	});
});
</script>
<link rel="stylesheet" href="/HoneyComb_2_0/resources/css/cloud.css">
</head>
<body>
	<form name="form"	action="upload" enctype="multipart/form-data" method="post">
		<input type="hidden" value="${param.folder}" name="folder">
		<c:if test="${promgr_num != null}">
			<input type="hidden" name="promgr_num" value="${promgr_num}"> 
			<input type="hidden" name = "promgr_name" value="${promgr_name}"> 
		</c:if>
		<div class="file_upload">
			<input type="text" disabled="disabled"class="upload_name">
			<label for="uploadFile">
				<div class="choosefile">파일선택</div>
			</label>
			<input type="file" name="uploadfile" id="uploadFile" class="upload_hidden">
		</div>
		
		<c:if test="${com_pos_num < 4}">
			<div class="security">
			<input type="checkbox" name="security"id="security">
				<label for="security">
					<img src="/HoneyComb_2_0/resources/images/cloud_img/unlock.jpg" id="secureimg">
					보안설정
				</label>
			</div>
		</c:if>
		
		<input type="submit" class="basicButton" id="submit" value="업로드" disabled="disabled" style="margin-left:40%; margin-top: 10px;">
		<div class="duplitext"><p id="dupli"/></div>
	
	</form>
	
</body>
</html>