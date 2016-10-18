<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<script type="text/javascript">
function setmember(){
	var mid_mem_num = '${mid_mem.mem_num}';
	var mid_mem_name = '${mid_mem.name}';
	var mid_mem_pos = '${mid_mem.com_pos_name}';
	
	var fin_mem_num ='${fin_mem.mem_num}';
	var fin_mem_name = '${fin_mem.name}';
	var fin_mem_pos = '${fin_mem.com_pos_name}';
	
	$("#mid_mem_num", opener.document).val(mid_mem_num);
	$("#middle_approval_pos", opener.document).text(mid_mem_pos);
	$("#middle_approval_name", opener.document).text(mid_mem_name);

	$("#fin_mem_num", opener.document).val(fin_mem_num);
	$("#final_approval_pos", opener.document).text(fin_mem_pos);
	$("#final_approval_name", opener.document).text(fin_mem_name);
	
	

	
	
	window.close();
	
}

</script>
<body onload="setmember()">

</body>
</html>