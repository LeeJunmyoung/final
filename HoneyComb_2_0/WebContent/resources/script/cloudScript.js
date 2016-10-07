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
		url : "dupleCk",
		data : {
			"item" : item,
			"folder" : folder
		},
		success : function(data) {
			if (data == 0) {
				/*$("#submit").attr("disabled",false);*/
			} else {
				$("#dupli").html("<font color=red>이미 있는 이름입니다 다시 입력해 주세요.")
				$("#submit").attr("disabled",true);
			}

		}
	});
};

