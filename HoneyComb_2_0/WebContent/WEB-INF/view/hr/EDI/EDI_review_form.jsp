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

<script type="text/javascript">
function midsign(){
	
	
		
	
		var EDI_num = '${edi_info.EDI_num}';
		
		
		url = "midsign.do?EDI_num="+EDI_num;
		
		

			var out = confirm("결제 하시겠습니까?");

			if (out) {
				this.location.href=url;
		
			} else {
				return false;
			}

		
		
	
}
function finsign(){
	
	
	
	
	var EDI_num = '${edi_info.EDI_num}';
	
	
	url = "finsign.do?EDI_num="+EDI_num;
	
	

		var out = confirm("결제 하시겠습니까?");

		if (out) {
			this.location.href=url;
	
		} else {
			return false;
		}

	
	

}



</script>


</head>
<body>
	<form action="writeEDI.do" method="post" enctype="multipart/form-data"
		onsubmit="return check_invaild();">
		<div class="EDI_write_form">
			<h2>전자 문서 작성</h2>

			<hr class="hr_class">





			<div class="form_left">
				<table>
					<tr>
						<td style="width: 70px;">작 성 일 :</td>
						<td>&nbsp;&nbsp;${edi_info.draftDate}</td>

					</tr>
					<tr>
						<td style="width: 70px;">문서번호</td>
						<td>${edi_info.document_num}</td>

					</tr>

					<tr>
						<td style="width: 70px;">수 신 처 :</td>
						<td><p id="dept_name">${edi_info.send_dept_name }</td>

					</tr>

					<tr>
						<td style="width: 70px;">보 고 자 :</td>
						<td>${edi_info.writer_mem_dept}${edi_info.writer_mem_pos}
							${edi_info.writer_mem_name}</td>
					</tr>

					<tr>
						<td style="width: 70px;">파 일 : &nbsp;&nbsp;</td>
						<td><p id="attechFile"><a href="EDIDown.do?EDI_num=${edi_info.EDI_num }">${edi_info.attechFile }</a></td>
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
						<td id="sign_form_td_sign2"><p>${edi_info.writer_mem_pos}</p>
							<p>${edi_info.writer_mem_name}</p></td>
						<td id="sign_form_td_sign2"><p id="middle_approval_pos">${edi_info.mid_mem_pos}</p>
							<p id="middle_approval_name">${edi_info.mid_mem_name }</p></td>
						<td id="sign_form_td_sign2"><p id="final_approval_pos">${edi_info.fin_mem_pos}</p>
							<p id="final_approval_name">${edi_info.fin_mem_name }</p></td>
					</tr>
					<tr>
						<td id="sign_form_td_sign3">${edi_info.writer_sign}</td>
						<td id="sign_form_td_sign3"><c:if
								test="${empty edi_info.mid_sign}">
								<c:if test="${mem_num eq edi_info.mid_mem_num and edi_info.mid_accept eq 0 }">
									<input type="button" class="btn btn-primary" value="서명" onclick="midsign()">
								</c:if>
							</c:if> <c:if test="${not empty edi_info.mid_sign}">
						${edi_info.mid_sign }
						</c:if></td>
						<td id="sign_form_td_sign3"><c:if
								test="${empty edi_info.fin_sign}">
								<c:if test="${mem_num == edi_info.fin_mem_num and edi_info.fin_accept eq 0  }">
									<input type="button" class="btn btn-primary" value="서명" onclick="finsign()">
								</c:if>
							</c:if> <c:if test="${not empty edi_info.fin_sign}">
						 ${edi_info.fin_sign }
						</c:if></td>
					</tr>


				</table>
				<input type="hidden" class="btn btn-primary" id="approval_mem"
					value="결재자 지정" onclick="select_approval()">
			</div>

			<div class="EDI_contents">
				<div class="edi_subject_div">
					<p class="p_subject">문 서 제 목 :</p>
					<input type="text" id="edi_subject" name="edi_subject"
						value="${edi_info.EDI_Subject }" style="width: 80%;"
						readonly="readonly">
				</div>
				<div class="edi_contents_div">
					<p class="p_contents">내용</p>
					<div class="contents_menubar"></div>
					<textarea id="textarea_edi" name="textarea_edi" readonly="readonly">${edi_info.EDI_TextArea}</textarea>
				</div>
			</div>


		</div>

	</form>
</body>
</html>