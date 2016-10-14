<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script>
	function certi_search() {

		url = "/HoneyComb_2_0/mypage/certi_search";

		window
				.open(
						url,
						"post",
						"toolbar=no, left=200, top=100, width=700, height=400, directories=no, status=yes, scrollbar=yes, menubar=no");
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
		<form action="/HoneyComb_2_0" name="shool_submit">
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
				<input type="submit" class="button" value="등록" />
			</div>

		</form>
	</c:if>



	<c:if test="${ code == 2 }">
		<form name="edu_submit">
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
				<input type="submit" class="button" value="등록" />
			</div>

		</form>
	</c:if>



	<c:if test="${ code == 3 }">
		<form name="certi_submit">
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
				<input type="submit" class="button" value="등록" />
			</div>

		</form>
	</c:if>



	<c:if test="${ code == 4 }">
		<form name="mili_submit">
			<p>병 역</p>
			<table id="mili">

				<tr>
					<td>군필 여부</td>
					<td></td>
					<td>면제 사유</td>
					<td></td>
					<td>복무처</td>
					<td></td>
				</tr>

				<tr>
					<td colspan="2">복무 기간</td>
					<!-- <td></td> -->
					<td colspan="4"></td>
					<!-- <td></td> -->
					<!-- <td></td> -->
					<!-- <td></td> -->
				</tr>

			</table>
			<br /> <br />
			<div class="div_submit">
				<input type="submit" class="button" value="등록" />
			</div>

		</form>
	</c:if>



	<c:if test="${ code == 5 }">
		<form name="career_submit">
			<p>경 력</p>
			<table id="career">

				<tr>
					<td></td>
					<td></td>
					<td></td>
				</tr>

				<tr>
					<td></td>
					<td></td>
					<td></td>
				</tr>

			</table>
			<br /> <br />
			<div class="div_submit">
				<input type="submit" class="button" value="등록" />
			</div>

		</form>
	</c:if>

</body>
</html>
