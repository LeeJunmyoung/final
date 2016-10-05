<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function openupload(folder){
		var folder = folder;
		window.open("upload/"+folder,'',"toolbar=yes,scrollbars=yes,resizable=yes,top=500,left=500,width=400,height=400")
	}
	function openDelete(selectedFiles){
		var selectedFiles = selectedFiles;
		window.open("delete?selectedFiles="+selectedFiles,'',"toolbar=yes,scrollbars=yes,resizable=yes,top=500,left=500,width=800,height=400");
	}
	function openMakeFolder(folder){
		folder = folder ? '/'+folder : '';
		window.open("makeFolder"+folder,'',"toolbar=yes,scrollbars=yes,resizable=yes,top=500,left=500,width=400,height=400")
	}
	
	$(function(){	
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
		
	})
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

<c:if test="${param.folder ne null || !param.folder == ''}">
	<div>상위폴더로</div>
</c:if>

<c:forEach var="cloudlist" items="${cloudlist}">
<input type="checkbox" id="${cloudlist.file_num}" name="selectedFiles" value="${cloudlist.file_num}">
	<label for="${cloudlist.file_num}">
		<div style="border:5px solid">
		  file_num :::${cloudlist.file_num}<br>
		  file_name :::${cloudlist.file_name}<br>
		  file_path:::${cloudlist.file_path}<br>
		  file_uploader :::${cloudlist.file_uploader}<br>
		  file_size :::${cloudlist.file_size}<br>
		  file_date :::${cloudlist.file_date}<br>
		  com_num :::${cloudlist.com_num}<br>
		  folder :::${cloudlist.folder}<br>
		  promgr_num :::${cloudlist.promgr_num}<br>
		  mem_num :::${cloudlist.mem_num}<br>
		  com_pos_num :::${cloudlist.com_pos_num}<br>
		</div>
	</label>
</c:forEach>

</body>
</html>