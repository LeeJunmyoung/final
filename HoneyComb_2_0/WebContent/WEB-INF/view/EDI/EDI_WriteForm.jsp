<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">
function fromtodept(){
	var url="";
	window.open(url,'get',"toolbar=no,width=800,height=900,directories=no,status=no,scrollbars=no,menubar=no");
	
}
</script>

<title>문서 작성</title>
<style type="text/css">
HTML{
width: 100%;
height: 100%;

}
body{
width: 98%;
height: 98%;
margin: auto;
}

.EDI_write_form{
position:relative;
top:25px;
width: 95%;
height: 95%;
border: 1px solid #000;
margin: auto;

}
h2{
text-align: center;
}
.hr_class{
width: 95%;

}
.form_left{
display:inline-block;
float:left;
width: 50%;
height:300px;

}
.form_left table{
margin: 0 auto;
}


.form_right{
float:right;
width: 50%;
height:300px;

}
.btn{
padding:2px;


}
td{
height: 50px;
}


</style>




</head>
<body>

<div class="EDI_write_form">
<h2>전자 문서 작성</h2>
<hr class="hr_class">

<div class="form_left" > 
<table>
<tr>
<td>작 성 일 :</td>
<td>&nbsp;&nbsp;${write_date}</td>

</tr>

<tr>
<td>수 신 처 :</td>
<td>&nbsp;&nbsp;<input type="button" class="btn btn-primary" value ="선택" onclick="fromtodept()"/></td>

</tr>

<tr>
<td>보 고 자 :</td>
<td>&nbsp;&nbsp; ${com_dept_name} ${com_pos_name} ${name}</td>
</tr>

</table>

</div>

<div class="form_right"> </div>


</div>


</body>
</html>