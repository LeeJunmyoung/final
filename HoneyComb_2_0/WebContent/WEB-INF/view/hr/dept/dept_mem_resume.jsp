<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>이력서</title>
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

h2 {
	text-align: center;
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
</style>
</head>
<body onselectstart="return false" ondragstart="return false">

	<div id="main">

		<h2>이 력 서</h2>
		<table>

			<c:forEach var="base_list" items="${ base_list }">
				<tr>
					<td rowspan="5" class="wi">프로필 사진</td>
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
					<td>${ base_list.phone_num }</td>
				</tr>

				<tr>
					<!-- <td></td> -->
					<td class="bold">주 소</td>
					<td colspan="3">${ base_list.mem_address }</td>
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

		<table>

			<p class="title">학 력</p>

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

		<table>

			<p class="title">교육 이수</p>

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

		<table>

			<p class="title">자격증</p>

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

		<c:if test="${ !empty mili_list }">
			<table>

				<p class="title">병 역</p>

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

			</table>
		</c:if>

		<table>

			<p class="title">경 력</p>

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
					<td colspan="6">등록된 정보가 없습니다</td>
				</tr>
			</c:if>

		</table>

	</div>

</body>
</html>
