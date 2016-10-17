<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>
<script>

$(document).ready(function() {
	$("#mili_check").click(function(){
		if($("#mili_check").val()=='군필'){
			$('#mili_ex').attr('readonly','readonly');
			$('#mili_place').removeAttr('readonly','readonly');
			$('#mili_date').removeAttr('readonly','readonly');
			$('#mili_ex').val('해당없음');
			$('#mili_place').val('');
			$('#mili_date').val('');
		}
		
		if($("#mili_check").val()=='면제'){
			$('#mili_ex').removeAttr('readonly','readonly');
			$('#mili_place').attr('readonly','readonly');
			$('#mili_date').attr('readonly','readonly');
			$('#mili_ex').val('');
			$('#mili_place').val('─');
			$('#mili_date').val('─');
		}
		
		if($("#mili_check").val()=='해당없음'){
			$('#mili_ex').attr('readonly','readonly');
			$('#mili_place').attr('readonly','readonly');
			$('#mili_date').attr('readonly','readonly');
			$('#mili_ex').val('─');
			$('#mili_place').val('─');
			$('#mili_date').val('─');
		}
		
		
		
	})
})


	function certi_search() {

		url = "/HoneyComb_2_0/mypage/certi_search";

		window
				.open(
						url,
						"post",
						"toolbar=no, left=200, top=100, width=700, height=400, directories=no, status=yes, scrollbar=yes, menubar=no");
	}

	function school_che() {
		if (!document.school_submit.school_name.value) {
			alert("학교명을 입력하세요");
			return false;
		}

		if (!document.school_submit.school_date.value) {
			alert("재학기간을 입력하세요");
			return false;
		}

		if (!document.school_submit.school_major.value) {
			alert("전공/학과을 입력하세요");
			return false;
		}

		return true;
	}

	function edu_che() {
		if (!document.edu_submit.edu_insti.value) {
			alert("기관명을 입력하세요");
			return false;
		}

		if (!document.edu_submit.edu_name.value) {
			alert("연수과정을 입력하세요");
			return false;
		}

		if (!document.edu_submit.edu_date.value) {
			alert("연수기간을 입력하세요");
			return false;
		}
		return true;

	}

	function certi_che() {
		if (!document.certi_submit.certi_name.value) {
			alert("자격증명을 선택하세요");
			return false;
		}

		if (!document.certi_submit.certi_insti.value) {
			alert("발행처를 입력하세요");
			return false;
		}

		if (!document.certi_submit.certi_date.value) {
			alert("취득일을 입력하세요");
			return false;
		}

		return true;

	}

	function mili_che() {
		if (document.mili_submit.mili_check.value == "선택하세요") {
			alert("군필여부를 선택하세요");
			return false;
		}

		if (!document.mili_submit.mili_ex.value) {
			alert("면제사유를 입력하세요");
			return false;
		}

		if (!document.mili_submit.mili_place.value) {
			alert("복무처를 입력하세요");
			return false;
		}

		if (!document.mili_submit.mili_date.value) {
			alert("복무기간을 입력하세요");
			return false;
		}
		return true;
	}

	function career_che() {
		if (!document.career_submit.career_com_name.value) {
			alert("회사명을 입력하세요");
			return false;
		}

		if (!document.career_submit.career_dept_name.value) {
			alert("부서명을 입력하세요");
			return false;
		}

		if (!document.career_submit.career_work.value) {
			alert("담당업무를 입력하세요");
			return false;
		}

		if (!document.career_submit.career_date.value) {
			alert("기간을 입력하세요");
			return false;
		}

		return true;

	}
</script>
<style>
table, tr, th, td {
	border-collapse: collapse;
	border: 1.5px solid #6E6E6E;
	cellpadding: 0;
	cellspacing: 0;
	font-size: 13px;
	padding: 8px;
	height: 12px;
	margin: 0 auto;
	text-align: center;
	background: #e9ebee;
}

input[type=text] {
	height: 22px;
	border-radius: 5px 5px 5px 5px;
	font-size: 14px;
	margin-top: -10px;
	margin-bottom: -10px;
	text-align: center;
}

.div_submit {
	text-align: center;
	margin: 0 auto;
}

#school, #edu, #certi, #mili, #career {
	margin-top: 50px;
	width: 500px;
	height: 15px;
	text-align: cneter;
	margin: 0 auto;
	width: 500px;
}

p {
	text-align: center;
}

.button {
	width: 80px;
	margin-bottom: 2px;
	margin-left: 5px;
	background-color: #4367b0;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	cursor: pointer;
	color: #fff;
	font-size: 14px;
	padding: 5px 10px;
	text-decoration: none;
	text-align: center;
}

.button:hover {
	background-color: #344d91;
	color: white;
}
</style>
</head>
<body style="background-color: #e9ebee;">

	<c:if test="${ code == 1 }">
		<form action="/HoneyComb_2_0/mypage/school_pro" method="post"
			name="school_submit">
			<p>학 력</p>
			<table id="school">

				<tr>
					<td>학교명</td>
					<td>재학 기간</td>
					<td colspan="2">전공 / 학과</td>
				</tr>

				<tr>
					<td><input type="text" name="school_name" /></td>
					<td><input type="text" name="school_date"
						placeholder="입학년도 ~ 졸업년도" /></td>
					<td colspan="2"><input type="text" name="school_major" /></td>
				</tr>

			</table>
			<br /> <br />
			<div class="div_submit">
				<input type="submit" onclick="return school_che()" class="button"
					value="등록" />
			</div>

		</form>
	</c:if>



	<c:if test="${ code == 2 }">
		<form action="/HoneyComb_2_0/mypage/edu_pro" method="post"
			name="edu_submit">
			<p>교육 이수</p>
			<table id="edu">

				<tr>
					<td>기관명</td>
					<td>연수 과정</td>
					<td>연수 기간</td>
				</tr>

				<tr>
					<td><input type="text" name="edu_insti" /></td>
					<td><input type="text" name="edu_name" /></td>
					<td><input type="text" name="edu_date" /></td>
				</tr>

			</table>
			<br /> <br />
			<div class="div_submit">
				<input type="submit" class="button" value="등록"
					onclick="return edu_che()" />
			</div>

		</form>
	</c:if>



	<c:if test="${ code == 3 }">
		<form action="/HoneyComb_2_0/mypage/certi_pro" method="post"
			name="certi_submit">
			<p>자격증</p>
			<table id="certi">

				<tr>
					<td>자격증명</td>
					<td>자격증코드</td>
					<td>발행처</td>
					<td>취득일</td>
				</tr>

				<tr>
					<td><input type="text" name="certi_name" /></td>
					<td><input type="text" name="certi_code" /></td>
					<td><input type="text" name="certi_insti" /></td>
					<td><input type="text" name="certi_date" /></td>
				</tr>

			</table>
			<br /> <br />
			<div class="div_submit">
				<input type="submit" class="button" value="등록"
					onclick="return certi_che()" />
			</div>

		</form>
	</c:if>



	<c:if test="${ code == 4 }">
		<form action="/HoneyComb_2_0/mypage/mili_pro" method="post"
			name="mili_submit">
			<p>병 역</p>
			<table id="mili">

				<tr>
					<td>군필 여부</td>
					<td><select name="mili_check" id="mili_check">
							<option value="선택하세요">선택하세요</option>
							<option value="군필">군필</option>
							<option value="면제">면제</option>
							<option value="해당없음">해당없음</option>
					</select></td>
					<td>면제 사유</td>
					<td><input type="text" name="mili_ex" id="mili_ex" /></td>
					<td>복무처</td>
					<td><input type="text" name="mili_place" id="mili_place" /></td>
				</tr>

				<tr>
					<td colspan="2">복무 기간</td>
					<!-- <td></td> -->
					<td colspan="4"><input type="text" name="mili_date" id="mili_date" /></td>
					<!-- <td></td> -->
					<!-- <td></td> -->
					<!-- <td></td> -->
				</tr>

			</table>
			<br /> <br />
			<div class="div_submit">
				<input type="submit" class="button" value="등록"
					onclick="return mili_che()" />
			</div>

		</form>
	</c:if>



	<c:if test="${ code == 5 }">
		<form action="/HoneyComb_2_0/mypage/career_pro" method="post"
			name="career_submit">
			<p>경 력</p>
			<table id="career">

				<tr>
					<td>회사명</td>
					<td>부서명</td>
					<td>담당업무</td>
					<td>기간</td>
				</tr>

				<tr>
					<td><input type="text" name="career_com_name" /></td>
					<td><input type="text" name="career_dept_name" /></td>
					<td><input type="text" name="career_work" /></td>
					<td><input type="text" name="career_date" /></td>
				</tr>

			</table>
			<br /> <br />
			<div class="div_submit">
				<input type="submit" class="button" value="등록"
					onclick="return career_che()" />
			</div>

		</form>
	</c:if>

</body>
</html>
