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
				$("#dupli").html("<font color=#344D91>사용가능한 이름 입니다.")
				$("#submit").attr("disabled",false);
			} else {
				$("#dupli").html("<font color=red>이미 사용중인 이름 입니다.")
				$("#submit").attr("disabled",true);
			}

		}
	})
};
