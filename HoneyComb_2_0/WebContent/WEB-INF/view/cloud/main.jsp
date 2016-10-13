<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
		/* $("<div class='cloud_menu' style='position: absolute; z-index:1000;'>"+
			    "<a href="+"javascript:openupload('${param.folder}')"+"><p>업로드</p></a>"+
			    "<a href="+"javascript:myfunction()"+"  id='download'><p id='download'>다운로드</p></a>"+
			    "<a href = "+"javascript:openMakeFolder('${param.folder}')"+"><p>폴더 만들기</p></a>"+
			    "<a class='deldiv' id=delete href="+"javscript:openDelete"+"><p>삭제</p></a>"+
			    "<a href='' 파일 열기>" 
			    +"</div>") */
			    $("#contextBox")
			    .appendTo("body")
			    .css({"display":"block", top: event.pageY + "px", left: event.pageX + "px"});	
		
	}).bind("click", function(event) {
		$("#contextBox").hide(); 
	});
});
</script>
</head>
<body>
<div>
<input type="button" value="업로드" onclick="openupload('${param.folder}')">
<input type="button" value="다운로드" id="download">
<input type="button" value="삭제" id="delete">
<input type="button" value="폴더 만들기" onclick="openMakeFolder('${param.folder}')">
</div>
<div>
	<ui>
		<c:if test="${param.folder ne null || !param.folder == ''}">
			<div><a href="javascript:goUpperFolder('${param.folder}')">상위폴더로</a></div>
		</c:if>	
		
		<c:forEach var="cloudlist" items="${cloudlist}">
			<li>
				<c:if test="${fn:substring(cloudlist.file_path,0,1)=='$'}">
				<input type="checkbox" id="${cloudlist.file_num}" name="selectedFiles" value="${cloudlist.file_num}" >
				<label for="${cloudlist.file_num}">
						<div style="border:5px solid" ondblclick="changeFolder('${cloudlist.file_path}')">
						this is folder
				</c:if>
			
				<c:if test="${fn:substring(cloudlist.file_path,0,1)!='$'}">
				<input type="checkbox" id="${cloudlist.file_num}" name="selectedFiles" value="${cloudlist.file_num}">
				<label for="${cloudlist.file_num}">
						<div style="border:5px solid">
						this is file
				</c:if>
				<input type="text" value="${cloudlist.file_name}" readonly="readonly" id="${cloudlist.file_num}">
					  file_name :::${cloudlist.file_name}<br>
					  file_uploader :::${cloudlist.file_uploader}<br>
					  file_size :::${cloudlist.file_size}<br>
					  file_date :::${cloudlist.file_date}<br>
					  
			<%-- 		  file_num :::${cloudlist.file_num}<br>
					  com_num :::${cloudlist.com_num}<br>
					  folder :::${cloudlist.folder}<br>
					  file_path:::${cloudlist.file_path}<br>
					  promgr_num :::${cloudlist.promgr_num}<br>
					  mem_num :::${cloudlist.mem_num}<br>
					  com_pos_num :::${cloudlist.com_pos_num}<br> --%>
					</div>
				</label>
			<li>
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