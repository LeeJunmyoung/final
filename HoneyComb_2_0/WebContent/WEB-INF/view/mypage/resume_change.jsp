<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>이력서</title>
<script>
	function resume_pro(c) {
		// code number
		// 1 == school (학력)
		// 2 == edu (교육이수)
		// 3 == certi (자격증)
		// 4 == mili (병역)
		// 5 == career (경력)

		var code = c;

		url = "/HoneyComb_2_0/mypage/resume_pro?code=" + code;

		window
				.open(
						url,
						"post",
						"toolbar=no, left=200, top=100, width=700, height=280, directories=no, status=yes, scrollbar=yes, menubar=no");
	}

	function base_change() {

		var phone_num = document.base.phone_num.value;
		var mem_address = document.base.mem_address.value;

		var url = "/HoneyComb_2_0/mypage/base_pro?phone_num=" + phone_num
				+ "&mem_address=" + mem_address;

		window
				.open(
						url,
						"post",
						"toolbar=no, left=400, top=150, width=350, height=100, directories=no, status=yes, scrollbar=yes, menubar=no");
	}
	
	function resume_reset(c) {
		
		var code = c;
		
		url = "/HoneyComb_2_0/mypage/resume_reset?code=" + code;

		window
				.open(
						url,
						"post",
						"toolbar=no, left=400, top=150, width=350, height=100, directories=no, status=yes, scrollbar=yes, menubar=no");
		 
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

#subject {
	text-align: center;
	margin-bottom: -5px;
}

input[type=text] {
	height: 22px;
	border-radius: 5px 5px 5px 5px;
	font-size: 14px;
	margin-top: -10px;
	margin-bottom: -10px;
	text-align: center;
	width: 110px;
}

#img_myprofile {
	width: 115px;
	height: 138px;
}

.title {
	text-align: left;
	margin-bottom: 5px;
	margin-top: 10px;
	margin-left: 10px;
	font-size: 14px;
	font-weight: bold;
}

#main {
	text-align: center;
	margin: 0 auto;
	height: 900px;
	width: 600px;
}

.wi {
	width: 120px;
}

.wi_sum {
	width: 240px;
}

.bold {
	color: white;
	background: #344d91;
}

.bold_wi {
	color: white;
	width: 120px;
	background: #344d91;
}

.bold_wi_sum {
	color: white;
	width: 240px;
	background: #344d91;
}

.div_title {
	width: 590px;
	height: 30px;
	margin-bottom: 2px;
}

.button {
	width: 30px;
	display: inline-block;
	margin-bottom: 2px;
	margin-left: 5px;
	background-color: #4367b0;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	cursor: pointer;
	color: #fff;
	font-size: 12px;
	padding: 2px 7px;
	text-decoration: none;
	float: right;
	text-align: center;
}

.button:hover {
	background-color: #344d91;
	color: white;
}

.button_reset {
	width: 40px;
	display: inline-block;
	margin-bottom: 2px;
	margin-left: 5px;
	background-color: #4367b0;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	cursor: pointer;
	color: #fff;
	font-size: 12px;
	padding: 2px 7px;
	text-decoration: none;
	float: right;
	text-align: center;
}

.button_reset:hover {
	background-color: #344d91;
	color: white;
}

.button_base {
	width: 80px;
	display: inline-block;
	margin-bottom: 2px;
	margin-left: 5px;
	background-color: #4367b0;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	cursor: pointer;
	color: #fff;
	font-size: 12px;
	padding: 2px 7px;
	text-decoration: none;
	float: right;
	text-align: center;
}

.button_base:HOVER {
	background-color: #344d91;
	color: white;
}

#address {
	width: 320px;
	margin-left: -90px;
	margin-right: -90px;
}
</style>
</head>
<body onselectstart="return false" ondragstart="return false">

	<div id="main">

		<h2 id="subject">이 력 서</h2>

		<form name="base">
			<div class="div_title">
				<a href="#" onclick="base_change()" class="button_base">기본정보 변경</a>
			</div>
			<table>

				<c:forEach var="base_list" items="${ base_list }">
					<tr>
						<td rowspan="5" class="wi"><img
							src="${ base_list.profile_img }" name="profile_img"
							onerror="this.src='/HoneyComb_2_0/resources/images/user.png'"
							id="img_myprofile"></td>
						<td class="bold_wi">성 명</td>
						<td class="wi">${ base_list.name }</td>
						<td class="bold_wi">성 별</td>
						<td class="wi">${ base_list.gender }</td>
					</tr>

					<tr>
						<!-- <td></td> -->
						<td class="bold">생년월일</td>
						<td>${ base_list.birth_date }</td>
						<td class="bold">핸드폰 번호</td>
						<td><input type="text" name="phone_num"
							value="${ base_list.phone_num }" /></td>
					</tr>

					<tr>
						<!-- <td></td> -->
						<td class="bold">주 소</td>
						<td colspan="3"><input type="text" name="mem_address"
							id="address" value="${ base_list.mem_address }" /></td>
						<!-- <td></td> -->
						<!-- <td></td> -->
					</tr>

					<tr>
						<!-- <td></td> -->
						<td class="bold">부 서</td>
						<td name="com_dept_num" value="${ com_dept_num }">${ base_list.com_dept_name }</td>
						<td class="bold">직 급</td>
						<td name="com_pos_num" value="${ com_pos_num }">${ base_list.com_pos_name }</td>
					</tr>

					<tr>
						<!-- <td></td> -->
						<td class="bold">E-mail</td>
						<td colspan="3">${ base_list.email }</td>
						<!-- <td></td> -->
						<!-- <td></td> -->
						<!-- <td></td> -->
					</tr>
				</c:forEach>

			</table>
		</form>


		<form name="school">
			<table>

				<div class="div_title">
					<p class="title">
						학 력
						<a href="#" onclick="resume_pro(1)" class="button">등록</a>
						<c:if test="${ !empty school_list }"><a href="#" onclick="resume_reset(1)" class="button_reset">초기화</a></c:if>
					</p>
				</div>

				<tr>
					<td class="bold_wi">학교명</td>
					<td colspan="2" class="bold_wi_sum">재학 기간</td>
					<!-- <td></td> -->
					<td colspan="2" class="bold_wi_sum">전공 / 학과</td>
					<!-- <td></td> -->
				</tr>

				<c:forEach var="school" items="${ school_list }">
					<tr>
						<td>${ school.school_name }</td>
						<td colspan="2">${ school.school_date }</td>
						<!-- <td></td> -->
						<td colspan="2">${ school.school_major }</td>
						<!-- <td></td> -->
					</tr>
				</c:forEach>

				<c:if test="${ empty school_list }">
					<tr>
						<td colspan="5">등록된 정보가 없습니다</td>
					</tr>
				</c:if>

			</table>
		</form>

		<form name="edu">
			<table>

				<div class="div_title">
					<p class="title">
						교육 이수
						<a href="#" onclick="resume_pro(2)" class="button">등록</a>
						<c:if test="${ !empty edu_list }"><a href="#" onclick="resume_reset(2)" class="button_reset">초기화</a></c:if>
					</p>
				</div>

				<tr>
					<td class="bold_wi">기관명</td>
					<td colspan="2" class="bold_wi_sum">연수 과정</td>
					<!-- <td></td> -->
					<td colspan="2" class="bold_wi_sum">연수 기간</td>
					<!-- <td></td> -->
				</tr>

				<c:forEach var="edu" items="${ edu_list }">
					<tr>
						<td>${ edu.edu_insti }</td>
						<td colspan="2" class="wi_sum">${ edu.edu_name }</td>
						<!-- <td></td> -->
						<td colspan="2" class="wi_sum">${ edu.edu_date }</td>
						<!-- <td></td> -->
					</tr>
				</c:forEach>

				<c:if test="${ empty edu_list }">
					<tr>
						<td colspan="5">등록된 정보가 없습니다</td>
					</tr>
				</c:if>

			</table>
		</form>


		<form name="certi">
			<table>

				<div class="div_title">
					<p class="title">
						자격증
						<a href="#" onclick="resume_pro(3)" class="button">등록</a>
						<c:if test="${ !empty certi_list }"><a href="#" onclick="resume_reset(3)" class="button_reset">초기화</a></c:if>
					</p>
				</div>

				<tr>
					<td colspan="2" class="bold_wi_sum">자격증명</td>
					<!-- <td></td> -->
					<td class="bold_wi">발행처</td>
					<td colspan="2" class="bold_wi_sum">취득일</td>
					<!-- <td></td> -->
				</tr>

				<c:forEach var="certi" items="${ certi_list }">
					<tr>
						<td colspan="2" class="colspan">${ certi.certi_name }</td>
						<!-- <td></td> -->
						<td>${ certi.certi_insti }</td>
						<td colspan="2">${ certi.certi_date }</td>
						<!-- <td></td> -->
					</tr>
				</c:forEach>

				<c:if test="${ empty certi_list }">
					<tr>
						<td colspan="5">등록된 정보가 없습니다</td>
					</tr>
				</c:if>

			</table>
		</form>


		<table>

			<div class="div_title">
				<p class="title">
					병 역
					<c:if test="${ empty mili_list }">
					<a href="#" onclick="resume_pro(4)" class="button">등록</a>
					</c:if>
					<c:if test="${ !empty mili_list }"><a href="#" onclick="resume_reset(4)" class="button_reset">초기화</a></c:if>
				</p>
			</div>

			<c:forEach var="mili" items="${ mili_list }">
				<tr>
					<td class="bold_wi">군필 여부</td>
					<td class="wi">${ mili.mili_check }</td>
					<td class="bold_wi">면제 사유</td>
					<td class="wi">${ mili.mili_ex }</td>
					<td class="bold_wi">복무처</td>
					<td class="wi">${ mili.mili_place }</td>
				</tr>

				<tr>
					<td colspan="2" class="bold">복무 기간</td>
					<!-- <td></td> -->
					<td colspan="4">${ mili.mili_date }</td>
					<!-- <td></td> -->
					<!-- <td></td> -->
					<!-- <td></td> -->
				</tr>
			</c:forEach>


			<c:if test="${ empty mili_list }">
				<tr>
					<td class="bold_wi">군필 여부</td>
					<td class="wi"></td>
					<td class="bold_wi">면제 사유</td>
					<td class="wi"></td>
					<td class="bold_wi">복무처</td>
					<td class="wi"></td>
				</tr>

				<tr>
					<td colspan="2" class="bold">복무 기간</td>
					<td colspan="4"></td>
				</tr>
			</c:if>

		</table>



		<form name="career">
			<table>

				<div class="div_title">
					<p class="title">
						경 력
						<a href="#" onclick="resume_pro(5)" class="button">등록</a>
						<c:if test="${ !empty career_list }"><a href="#" onclick="resume_reset(5)" class="button_reset">초기화</a></c:if>
					</p>
				</div>

				<tr>
					<td class="bold_wi">회사명</td>
					<td class="bold_wi">부서명</td>
					<td class="bold_wi">담당업무</td>
					<td colspan="2" class="bold_wi_sum">근무기간</td>
					<!-- <td></td> -->
				</tr>

				<c:forEach var="career" items="${ career_list }">
					<tr>
						<td>${ career.career_com_name }</td>
						<td>${ career.career_dept_name }</td>
						<td>${ career.career_work }</td>
						<td colspan="2">${ career.career_date }</td>
						<!-- <td></td> -->
					</tr>
				</c:forEach>

				<c:if test="${ empty career_list }">
					<tr>
						<td colspan="5">등록된 정보가 없습니다</td>
					</tr>
				</c:if>

			</table>
		</form>


	</div>

</body>
</html>
