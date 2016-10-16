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
	function fromtodept() {
		var url = "receiveForm.do";
		window
				.open(
						url,
						'get',
						"toolbar=no,width=300,height=400,left=600,directories=no,status=no,scrollbars=no,menubar=no");

	}
	
	function select_approval() {
		var url = "select_approval.do";
		window
				.open(
						url,
						'get',
						"toolbar=no,width=600,height=500,left=600,directories=no,status=no,scrollbars=no,menubar=no");

	}
	
	

	$(document).ready(function() {
		$('#approval_mem').hide();
		$('#sign_form').mouseenter(function() {

			$('#approval_mem').show();
			$('#sign_form').css('background-color', '#efefef');

		})
		$('#sign_form').mouseleave(function() {

			$('#approval_mem').hide();
			$('#sign_form').css('background-color', '#fff');

		})
		$('#approval_mem').mouseenter(function() {
			$('#approval_mem').show();
			$('#sign_form').css('background-color', '#efefef');
		})

	});
</script>

<title>문서 작성</title>
<style type="text/css">
HTML {
	width: 100%;
	height: 100%;
}

body {
	width: 98%;
	height: 98%;
	margin: auto;
}

.EDI_write_form {
	position: relative;
	top: 25px;
	width: 95%;
	height: 95%;
	border: 1px solid #000;
	margin: auto;
}

h2 {
	text-align: center;
}

.hr_class {
	width: 95%;
}

.form_left {
	display: inline-block;
	float: left;
	width: 50%;
	height: 300px;
}

.form_left table {
	margin: 0 auto;
}

.form_right {
	float: right;
	width: 50%;
	height: 300px;
}

.btn {
	padding: 2px;
}

td {
	height: 50px;
	padding: 0;
	vertical-align: middle;
}

#dept_name {
	float: left;
	margin: auto;
	padding-top: 4px;
	vertical-align: middle;
}

#sign_form tr td {
	border: 1px solid #000;
}

#sign_form_td_sign {
	width: 50px;
	text-align: center;
}

#sign_form_td_sign1, #sign_form_td_sign3 {
	width: 100px;
	text-align: center;
	height: 30px;
}

#sign_form_td_sign2 {
	width: 100px;
	text-align: center;
	height: 100px;
}

#approval_mem {
	position: relative;
	top: -90px;
	left: 140px;
	z-index: 3;
}
</style>




</head>
<body>

	<div class="EDI_write_form">
		<h2>전자 문서 작성</h2>
		<hr class="hr_class">

		<div class="form_left">
			<table>
				<tr>
					<td>작 성 일 :</td>
					<td>&nbsp;&nbsp;${write_date}</td>

				</tr>

				<tr>
					<td>수 신 처 :&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td><p id="dept_name"></p>&nbsp;&nbsp;<input type="button"
						class="btn btn-primary" value="선택" onclick="fromtodept()" /></td>

				</tr>

				<tr>
					<td>보 고 자 :</td>
					<td>&nbsp;&nbsp; ${com_dept_name} ${com_pos_name} ${name}</td>
				</tr>



			</table>

		</div>

		<div class="form_right">
			<table id="sign_form">
				<tr>
					<td rowspan="3" id="sign_form_td_sign">결<br>
					<br>재
					</td>
					<td id="sign_form_td_sign1">기 안 자</td>
					<td id="sign_form_td_sign1">검 토 자</td>
					<td id="sign_form_td_sign1">결 재 자</td>
				</tr>
				<tr>
					<td id="sign_form_td_sign2"><p>${com_pos_name}</p>
						<p>${name}</p></td>
					<td id="sign_form_td_sign2"><p id="middle_approval_pos">${com_pos_name}</p>
						<p id="middle_approval_name">${name}</p></td>
					<td id="sign_form_td_sign2"><p id="final_approval_pos">${com_pos_name}</p>
						<p id="final_approval_name">${name}</p></td>
				</tr>
				<tr>
					<td id="sign_form_td_sign3">test3</td>
					<td id="sign_form_td_sign3">test3</td>
					<td id="sign_form_td_sign3">test3</td>
				</tr>


			</table>
			<input type="button" class="btn btn-primary" id="approval_mem"
				value="결재자 지정" onclick="select_approval()">
		</div>

	</div>


</body>
</html>