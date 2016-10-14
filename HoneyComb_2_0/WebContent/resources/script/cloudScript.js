function duplInit(){
	$("#dupli").html("");
	$("#submit").attr("disabled",false);
};
function blankCk(value){
	if(value == ''||value == null){
		$("#submit").attr("disabled",true);
		return;
	};
};
function specialCharCk(value){
	var regExp = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
	if(regExp.test($("#folder").val())){
		$("#dupli").html("<font color=red size=2>특수문자 (\\ , | , / , * , ? , < , > , :, ;, `, ~, !, @, #, $, %, ^, & )는 사용하실 수 없습니다..")
		$("#submit").attr("disabled",true);
		return;
	};
};
function dupliCk(item, folder) {
	var item = item;
	var folder = folder
	$.ajax({
		type : "POST",
		url : "/HoneyComb_2_0/cloud/dupleCk",
		data : {
			"item" : item,
			"folder" : folder
		},
		success : function(data) {
			console.log(data);
			if (data == 0) {
				/*$("#submit").attr("disabled",false);*/
			} else {
				$("#dupli").html("<font color=red>이미 있는 이름입니다 다시 입력해 주세요.")
				$("#submit").attr("disabled",true);
			}

		}
	});
};
/*메인에서 쓰는 script*/
function openupload(folder){
	window.open("upload?folder="+folder,'',"toolbar=yes,scrollbars=yes,resizable=yes,top=500,left=500,width=400,height=400")
}
function openDelete(selectedFiles){
	var selectedFiles = selectedFiles;
	window.open("delete?selectedFiles="+selectedFiles,'',"toolbar=yes,scrollbars=yes,resizable=yes,top=500,left=500,width=800,height=400");
}
function openMakeFolder(folder){
	
	window.open("makeFolder?folder="+folder,'',"toolbar=yes,scrollbars=yes,resizable=yes,top=500,left=500,width=400,height=400")
}

function changeFolder(folder){
	location.href="main?folder="+folder;
}
function goUpperFolder(folder){
	location.href="goUpper?folder="+folder;
}
function download(){
	var selectedFiles = new Array();
	var i =0;
	$("input:checkbox[name='selectedFiles']:checked").each(function(){
		selectedFiles[i] = this.value;
		i++
	});
	$(location).attr('href',"download?selectedFiles="+selectedFiles); 
}
function deletefile(){
	var selectedFiles =  new Array();
	var i = 0;
	$("input:checkbox[name='selectedFiles']:checked").each(function(){
		selectedFiles[i] = this.value;
		i++
	});
	openDelete(selectedFiles); 
	
}
function changeFileName(){
	var checked = $("input:checkbox[name='selectedFiles']:checked");
	if(checked.size() > 1){
		alert("한개의 파일만 선택하여 주세요");
		return false;
	}
	$("input:text[id="+checked.val()+"]").removeAttr("readonly").focus();
}
function checkChange(){
	$("input:text").each(function(){
		if($(this).attr("readonly") != 'readonly'){
			changeFilename($(this).attr('id'), $(this).val());
		}
		
		
	})
function changeFilename(file_num, file_name){
		var file_num = file_num;
		var file_name = file_name;
	$.ajax({
			type : "POST",
			url : "/HoneyComb_2_0/cloud/changeName",
			data : {
				"file_num" : file_num,
				"file_name" : file_name
			},
			success : function(data) {
				console.log(data);
				alert(data);
				if (data == 0) {
					alert("success");
					$("input:text[id="+file_num+"]").Attr("readonly", true);
				} else {
					$("#dupli").html("<font color=red>이미 있는 이름입니다 다시 입력해 주세요.")
					$("#submit").attr("disabled",true);
				}

			} ,error:function(request,status,error){
			    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);}
		});
		
	}
	
	
}