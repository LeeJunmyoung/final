<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="/HoneyComb_2_0/resources/script/cloudScript.js"></script>
<script type="text/javascript">
	$(function(){
	if($("input:text").attr("readonly")==false){
		alert("test");
	}
	$("#download").click(function(){
		var selectedFiles = new Array();
		var i =0;
		$("input:checkbox[name='selectedFiles']:checked").each(function(){
			selectedFiles[i] = this.value;
			i++
		});
		$(location).attr('href',"download?selectedFiles="+selectedFiles); 
		
	});
	$("#delete").click(function(){
		var selectedFiles =  new Array();
		var i = 0;
		$("input:checkbox[name='selectedFiles']:checked").each(function(){
			selectedFiles[i] = this.value;
			i++
		});
		openDelete(selectedFiles); 
		
	});	
	$(document).bind("contextmenu", function(event) { 
		 event.preventDefault();
		 checkChange();
			    $("#contextBox")
			    .appendTo("body")
			    .css({"display":"block", top: event.pageY + "px", left: event.pageX + "px"});	
		
	}).bind("click", function(event) {
		checkChange();
		$("#contextBox").hide(); 
	});
	$(document).keypress(function(e){
		if(e.which == 13){
			 checkChange();
		};
	});
});
</script>
<link rel="stylesheet" href="/HoneyComb_2_0/resources/css/cloud.css">
</head>
<body>
<div class="button_Header">
	<input type="button" class="basicButton" value="업로드" onclick="openupload('${param.folder}')">
	<input type="button" class="basicButton" value="다운로드" id="download">
	<input type="button" class="basicButton" value="삭제" id="delete">
	<input type="button" class="basicButton" value="폴더 만들기" onclick="openMakeFolder('${param.folder}')">
</div>
<div>
	<ui> <c:if test="${param.folder ne null || !param.folder == ''}">
			<li>
				<div class="itemFrame">
					<input type="checkbox" id="goUpper"> <label for="goUpper">
						<div class="item" ondblclick="goUpperFolder('${param.folder}')">
							<img src="/HoneyComb_2_0/resources/images/cloud_img/go_upper.png">
						</div>
						<div class="itemInfo">

							상위폴더로 <br> <br> <br> <Br>
						</div>
			</li>
		</c:if> 
		<c:forEach var="cloudlist" items="${cloudlist}">
		<!-- 클라우드 view 설정 -->
		<fmt:parseNumber value="${cloudlist.file_size/1024}" integerOnly="true" var="file_size"/>
		<fmt:formatDate value="${cloudlist.file_date}" pattern="yyyy-MM-dd" var="file_date"/>
		
			<li>
				<div class="itemFrame">
					<c:if test="${fn:substring(cloudlist.file_path,0,1)=='$'}">
						<input type="checkbox" id="${cloudlist.file_num}" name="selectedFiles" value="${cloudlist.file_num}" >
						<label for="${cloudlist.file_num}">
							<div class="item" ondblclick="changeFolder('${cloudlist.file_path}')">
								<img src="/HoneyComb_2_0/resources/images/cloud_img/folder.png">
							</div>
					</c:if>
				
					<c:if test="${fn:substring(cloudlist.file_path,0,1)!='$'}">
						<input type="checkbox" id="${cloudlist.file_num}" name="selectedFiles" value="${cloudlist.file_num}">
						<label for="${cloudlist.file_num}">
							<div class="item" >
							<img src="/HoneyComb_2_0/resources/images/cloud_img/file.png">
							</div>
					</c:if>
					<div class="itemInfo">
						<input type="text" value="${cloudlist.file_name}" readonly="readonly" id="${cloudlist.file_num}"><br>
						${cloudlist.file_uploader}<br>
						${file_size} byte<br>
						${file_date}<br>						  
				<%-- 		  file_num :::${cloudlist.file_num}<br>
						  com_num :::${cloudlist.com_num}<br>
						  folder :::${cloudlist.folder}<br>
						  file_path:::${cloudlist.file_path}<br>
						  promgr_num :::${cloudlist.promgr_num}<br>
						  mem_num :::${cloudlist.mem_num}<br>
						  com_pos_num :::${cloudlist.com_pos_num}<br> --%>
						</div>
					</label>
				</div>
			</li>
		</c:forEach>
	</ui>
</div>
<div id="contextBox" style="display: none; position: absolute; z-index: 1000">
	<a href="javascript:openupload('${param.folder}')">업로드</a>
	<a href="javascript:download()">다운로드</a>
	<a href = "javascript:openMakeFolder('${param.folder}')">폴더 만들기</a>
	<a href="javascript:deletefile()">삭제</a>
	<a href="javascript:changeFileName()">이름 바꾸기</a>
	<a href="" >파일 열기</a>
</div>
</body>
</html>