<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

	function fromtodept1() {
		var url = "receiveForm.do";
		window.open(url,
						'post',
						"toolbar=no,width=300,height=400,left=600,directories=no,status=no,scrollbars=no,menubar=no");

	}

	function select_approval() {

		var url = "select_approval.do";
		window
				.open(
						url,
						'post',
						"toolbar=no,width=650,height=550,left=600,directories=no,status=no,scrollbars=no,menubar=no");

	}
	function del_temp() {
		

		var out = confirm("정말 삭제 하시겠습니까?");

		if (out) {
			var temp=${EDItemp.temp_EDI_num};
			window.location.href= "del_temp.do?temp_EDI_num="+temp+"";
		} else {
			return false;
		}
		

		
	}
	
	
	function tempupdatebutton() {
		var write_date = '${EDItemp.write_date}';
		var temp_EDI_num = '${EDItemp.temp_EDI_num}';
		var document_num = document.getElementById("document_num").value;
		var edi_subject = document.getElementById("edi_subject").value;
		var textarea_edi = document.getElementById("textarea_edi").value;
		var mid_mem_num = document.getElementById("mid_mem_num").value;
		var fin_mem_num = document.getElementById("fin_mem_num").value;
		var send_dept_name = document.getElementById("send_dept_name").value;

		if (edi_subject == "") {
			alert('제목은 필수 사항 입니다');
			return false;
		}

		var param = "write_date=" + write_date + "&document_num="
				+ document_num + "&edi_subject=" + edi_subject
				+ "&textarea_edi=" + textarea_edi + "&mid_mem_num="
				+ mid_mem_num + "&fin_mem_num=" + fin_mem_num
				+ "&send_dept_name=" + send_dept_name+"&temp_EDI_num="+temp_EDI_num;

		$.ajax({
			type : "POST",
			data : param,
			url : 'writeTempUpdate.do',
			dataType : "json",
			success : function(args) {
				alert('임시저장되었습니다');
				opener.location.reload();
				window.close()
			},
			error : function(e) {
				alert('내용을 입력하세요');
			}
		});

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

.button_div {
	position: relative;
	top: 30px;
	text-align: center;
}

#temp_save {
	width: 61px;
}
#submitsubmit{
margin-right: 3px;
}
</style>

<script language="javascript">
	//not event f5  event.clientY < 0
	//event.altKey When press Alt +F4 
	//event.ctrlKey When press Ctrl +F4 
	//event.clientY 107 or 129 is  Alt F4 postion on window screen it may change base on screen resolution
</script>


</head>
<body >
	<form action="tempwriteEDI.do" method="post" enctype="multipart/form-data" onsubmit="return check_invaild()">
		<div class="EDI_write_form">
			<h2>전자 문서 작성</h2>

			<hr class="hr_class">





			<div class="form_left">
				<table>
					<tr>
						<td style="width: 70px;">작 성 일 :</td>
						<td>&nbsp;&nbsp;${EDItemp.write_date}</td>

					</tr>
					<tr>
						<td style="width: 70px;">문서번호</td>
						<td>&nbsp; :&nbsp;<input type="text" id="document_num"
							name="document_num" value="${EDItemp.document_num}"></td>

					</tr>

					<tr>
						<td style="width: 70px;">수 신 처 :</td>
						<td><p id="dept_name">${EDItemp.send_dept_name}</p>&nbsp;&nbsp;<input
							type="button" class="btn btn-primary" value="선택"
							onclick="fromtodept1()" /></td>

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
						<td id="sign_form_td_sign2"><p id="middle_approval_pos">
								<c:choose>
									<c:when test="${not empty EDItemp.mid_mem_pos}">${EDItemp.mid_mem_pos}</c:when>
									<c:otherwise>미지정</c:otherwise>
								</c:choose>
							</p>
							<p id="middle_approval_name">
								<c:if test="${not empty EDItemp.mid_mem_name}">	${EDItemp.mid_mem_name}</c:if>
							</p></td>
						<td id="sign_form_td_sign2"><p id="final_approval_pos">
								<c:choose>
									<c:when test="${not empty EDItemp.fin_mem_pos}">${EDItemp.fin_mem_pos}</c:when>
									<c:otherwise>미지정</c:otherwise>
								</c:choose>
							</p>
							<p id="final_approval_name">

								<c:if test="${not empty EDItemp.fin_mem_name}">${EDItemp.fin_mem_name}</c:if>
							</p></td>
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
						style="width: 80%;" value="${EDItemp.EDI_Subject}">
				</div>
				<div class="edi_contents_div">
					<p class="p_contents">내용</p>
					<div class="contents_menubar"></div>
					<textarea id="textarea_edi" name="textarea_edi">${EDItemp.EDI_TextArea}</textarea>
				</div>
			</div>


		</div>
		<input type="hidden" id="mid_mem_num" name="mid_mem_num"
			value="${EDItemp.mid_mem_num}" /> <input type="hidden"
			id="fin_mem_num" name="fin_mem_num" value="${EDItemp.fin_mem_num}" />
		<input type="hidden" id="send_dept_name" name="send_dept_name"
			value="${EDItemp.send_dept_name}" />
			<input type="hidden" id="temp_EDI_num" name="temp_EDI_num"
			value="${EDItemp.temp_EDI_num}" />
		<div class="button_div">
			<input id='temp_save' class="btn btn-primary" value="임시저장"
				onclick="return tempupdatebutton()"> <input id="submitsubmit" type="submit"
				class="btn btn-primary" value="등록하기"><input id='temp_save' class="btn btn-primary" value="삭제"
				onclick="return del_temp()">
				
		</div>
	</form>

</body>
</html>