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
/* window.onbeforeunload = function() {
    alert('ggg');
	return "Bye now!";
}; */
window.addEventListener("beforeunload", function (e) {
	  var confirmationMessage = "\o/";

	  e.returnValue = confirmationMessage;     // Gecko, Trident, Chrome 34+
	  return confirmationMessage;              // Gecko, WebKit, Chrome <34
	});

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
						"toolbar=no,width=650,height=550,left=600,directories=no,status=no,scrollbars=no,menubar=no");

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

	function check_invaild() {
		if (document.getElementById('document_num').value == "") {
			alert("문서번호를 지정해주세요");
			return false;
		}
		if (document.getElementById('send_dept_name').value == "") {
			alert("수신처를 지정하세요");

			return false;
		}
		if (document.getElementById('edi_subject').value == "") {
			alert("제목을 입력하세요");

			return false;
		}

		if (document.getElementById('fin_mem_num').value == "") {
			alert("결제권자를 지정해주세요");

			return false;
		}

	}
</script>

<title>문서 작성</title>
<style type="text/css">
HTML, form {
	width: 100%;
	height: 100%;
}

body {
	width: 98%;
	height: 98%;
	margin: auto;
	overflow: hidden;
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
	border: 1px solid #000;
}

.form_left {
	display: inline-block;
	float: left;
	width: 50%;
	height: 30%;
}

.form_left table {
	position: relative;
	top: 10px;
	margin: auto;
}

.form_right {
	float: right;
	width: 50%;
	height: 30%;
}

.form_right table {
	position: relative;
	left: -15px;
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

.EDI_contents {
	position: relative;
	top: 30%;
	width: 100%;
	height: 60%;
}

.edi_subject_div {
	width: 100%;
	height: 80px;
	position: relative;
	top: -220px;
	display: inline;
}

.p_subject {
	width: 100px;
	display: inline;
}

.edi_contents_div {
	width: 100%;
	height: 400px;
	position: relative;
	top: -200px;
	display: inline;
}

.contents_menubar {
	width: 100%;
	height: 30px;
	margin: auto;
	border-top: 1px solid #000;
	border-bottom: 1px solid #000;
}

textarea {
	position: relative;
	width: 100%;
	height: 71%;
	overflow-y: scroll;
}

#document_num {
	width: 100px;
}
</style>

<script language="javascript">
	//not event f5  event.clientY < 0
	//event.altKey When press Alt +F4 
	//event.ctrlKey When press Ctrl +F4 
	//event.clientY 107 or 129 is  Alt F4 postion on window screen it may change base on screen resolution
</script>


</head>
<body>
	<form action="writeEDI.do" method="post" enctype="multipart/form-data"
		onsubmit="return check_invaild();">
		<div class="EDI_write_form">
			<h2>
				전자 문서 작성 <input type="submit" class="btn btn-primary" value="등록하기">
			</h2>

			<hr class="hr_class">





			<div class="form_left">
				<table>
					<tr>
						<td style="width: 70px;">작 성 일 :</td>
						<td>&nbsp;&nbsp;${write_date}</td>

					</tr>
					<tr>
						<td style="width: 70px;">문서번호</td>
						<td>&nbsp; :&nbsp;<input type="text" id="document_num"
							name="document_num"></td>

					</tr>

					<tr>
						<td style="width: 70px;">수 신 처 :</td>
						<td><p id="dept_name"></p>&nbsp;&nbsp;<input type="button"
							class="btn btn-primary" value="선택" onclick="fromtodept()" /></td>

					</tr>

					<tr>
						<td style="width: 70px;">보 고 자 :</td>
						<td>&nbsp;&nbsp; ${com_dept_name} ${com_pos_name} ${name}</td>
					</tr>

					<tr>
						<td style="width: 70px;">파 일 : &nbsp;&nbsp;</td>
						<td><input type="file" value="선택" name="attachfile"
							id="attachfile" class="file_hidden" /></td>
					</tr>



				</table>

			</div>

			<div class="form_right">
				<table id="sign_form">
					<tr>
						<td rowspan="3" id="sign_form_td_sign">결<br> <br>재
						</td>
						<td id="sign_form_td_sign1">기 안 자</td>
						<td id="sign_form_td_sign1">검 토 자</td>
						<td id="sign_form_td_sign1">결 재 자</td>
					</tr>
					<tr>
						<td id="sign_form_td_sign2"><p>${com_pos_name}</p>
							<p>${name}</p></td>
						<td id="sign_form_td_sign2"><p id="middle_approval_pos">미지정</p>
							<p id="middle_approval_name"></p></td>
						<td id="sign_form_td_sign2"><p id="final_approval_pos">미지정</p>
							<p id="final_approval_name"></p></td>
					</tr>
					<tr>
						<td id="sign_form_td_sign3"></td>
						<td id="sign_form_td_sign3"></td>
						<td id="sign_form_td_sign3"></td>
					</tr>


				</table>
				<input type="button" class="btn btn-primary" id="approval_mem"
					value="결재자 지정" onclick="select_approval()">
			</div>

			<div class="EDI_contents">
				<div class="edi_subject_div">
					<p class="p_subject">문 서 제 목 :</p>
					<input type="text" id="edi_subject" name="edi_subject"
						style="width: 80%;">
				</div>
				<div class="edi_contents_div">
					<p class="p_contents">내용</p>
					<div class="contents_menubar"></div>
					<textarea id="textarea_edi" name="textarea_edi" value=" "></textarea>
				</div>
			</div>


		</div>
		<input type="hidden" id="mid_mem_num" name="mid_mem_num" value="" /> <input
			type="hidden" id="fin_mem_num" name="fin_mem_num" value="" /> <input
			type="hidden" id="send_dept_name" name="send_dept_name" value="" />
	</form>
</body>
</html>