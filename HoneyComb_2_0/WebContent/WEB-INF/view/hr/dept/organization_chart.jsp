<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<!-- <title>Insert title here</title> -->
<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script>

function chart_click(num, name) {
	// 해당 부서에 등록되어 있는 사원 리스트 조회
	
	var com_dept_num = num;
	var com_dept_name = name;

	location.href="/HoneyComb_2_0/dept/dept_memList?com_dept_num=" + com_dept_num + "&com_dept_name=" + com_dept_name;
	
}

</script>

<style>
body {
	width: 100%;
}

#chart {
	width: 100%;
}

table {
	/* width: 930px; */
	border-collapse: collapse;
	margin: 0 auto;
	margin-bottom: 20px;
}

tr, td {
	width: 45px;
	height: 20px;
	border-collapse: collapse;
}

#box_1 {
	width: 105px;
}

.box {
	background-color: #344d91;
	color: white;
	margin: auto;
	text-align: center;
	font-size: 14px;
	line-height: 40px;
}

.box_CEO {
	background-color: #344d91;
	color: white;
	margin: auto;
	text-align: center;
	font-size: 14px;
	line-height: 40px;
}

.box_button {
	background-color: #e9ebee;
	color: #23282D;
	font-weight: bold;
	text-align: center;
	border: 2px solid white;
	cursor: pointer;
	line-height: 40px;
	width: 92px;
	height: 40px;
	margin-bottom: 20px;
	font-size: 14px;
}

.box_button:HOVER {
	border: 2px solid #344d91;
	background-color: #CECACA;
}

.line_no_bottom1 {
	border-left: 2px solid #344d91;
	border-top: 2px solid #344d91;
	border-right: 2px solid #344d91;
	padding: 0;
}

.line_no_bottom {
	padding: 0;
	border-top: 2px solid #344d91;
	border-right: 2px solid #344d91;
	padding: 0;
}

.line_no_top {
	border-top: hidden;
}

.line_on_rt {
	border-right: 2px solid #344d91;
}

.line_on_top {
	border-top: 2px solid #344d91;
}

#div_center_wrapper {
	width: 100%;
}

#div_center {
	margin: 0 auto;
	text-align: center;
	width: 655px;
	height: 195px;
}

.div_location {
	float: left;
	display: inline-block;
	margin: 0 auto;
	margin-right: 50px;
	box-sizing: 120px 248px;
}

#table {
	width: 650px;
	margin: 0 auto;
}

#div_up_1 {
	margin-left: 2px;
	margin-right: 47px;
}

#div_up_2 {
	margin-right: 45px;
}

#div_up_3 {
	margin-right: 48px;
}

#div_up_4 {
	margin-right: 47px;
}

#div_no_margin {
	margin-right: 0px;
}

#h2_title {
	font-size: 30px;
	text-align: center;
}
</style>
</head>
<body onselectstart="return false" ondragstart="return false">
<br>
<br>
<br>
<br>
<h2 id="h2_title">ORGANIZATION CHART</h2>
<br>
<br>
<br>
<br>
	<div id="chart">

		<div id="div_px">
			<div id="table">
				<!-- 14*16 -->
				<table>

					<!-- 1 -->
					<tr>
						<td colspan="6" rowspan="2"></td>
						<td colspan="2" rowspan="2" class="box_CEO">CEO ${ ceo_name }</td>
						<td colspan="6" rowspan="2"></td>
					</tr>

					<!-- 2 -->
					<tr>
					</tr>

					<!-- 3 -->
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td rowspan="5" class="line_on_rt"></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>

					<!-- 4 -->
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<!--  -->
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>

					<c:forEach var="dept" items="${ dept }">
						<c:choose>
							<c:when test="${ dept.key == 1 }">
								<!-- 5 -->
								<tr class="button_size_one">
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<!--  -->
									<td></td>
									<td></td>
									<td></td>
									<td colspan="2" rowspan="2" class="box_button"
										onclick="chart_click(${ dept.key }, '${ dept.value }')">${ dept.value }</td>
									<td></td>
									<td></td>
								</tr>
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</c:forEach>


					<!-- 6 -->
					<tr class="button_size_one">
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<!--  -->
						<c:forEach var="dept" items="${ dept }">
							<c:choose>
								<c:when test="${ dept.key == 1 }">
									<td colspan="3" class="line_on_top"></td>
								</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${ empty (dept.key==1) }">
							<td></td>
							<td></td>
							<td></td>
						</c:if>
						<!--  -->
						<td></td>
						<td></td>
					</tr>


					<c:if test="${ empty (dept.key==1) }">
						<!-- 5 -->
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<!--  -->
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>

						<!-- 5 -->
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<!--  -->
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</c:if>


					<!-- 4 -->
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<!--  -->
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>


					<!-- 8 -->
					<tr>
						<td></td>
						<td colspan="3" class="line_no_bottom1"></td>
						<td colspan="3" class="line_no_bottom"></td>
						<td colspan="3" class="line_no_bottom"></td>
						<td colspan="3" class="line_no_bottom"></td>
						<td></td>
					</tr>

					<!-- 9 -->
					<tr>
						<td colspan="2" rowspan="2" class="box" id="box_1">관리부</td>
						<td rowspan="2" class="line_no_top"></td>
						<td colspan="2" rowspan="2" class="box">경영부</td>
						<td rowspan="2" class="line_no_top"></td>
						<td colspan="2" rowspan="2" class="box">제품부</td>
						<td rowspan="2" class="line_no_top"></td>
						<td colspan="2" rowspan="2" class="box">기술부</td>
						<td rowspan="2" class="line_no_top"></td>
						<td colspan="2" rowspan="2" class="box">영업부</td>
					</tr>

					<!-- 10 -->
					<tr>
					</tr>


				</table>
			</div>

			<div id="div_center_wrapper">
				<div id="div_center">

					<div class="div_location" id="div_up_1">
						<c:forEach var="dept" items="${ dept }">
							<c:if test="${ dept.key gt 1 && dept.key lt 5 }">
								<div class="box_button" onclick="chart_click(${ dept.key }, '${ dept.value }')">${ dept.value }</div>
							</c:if>
						</c:forEach>
					</div>

					<div class="div_location" id="div_up_2">
						<c:forEach var="dept" items="${ dept }">
							<c:if test="${ dept.key gt 4 && dept.key lt 8 }">
								<div class="box_button" onclick="chart_click(${ dept.key }, '${ dept.value }')">${ dept.value }</div>
							</c:if>
						</c:forEach>
					</div>

					<div class="div_location" id="div_up_3">
						<c:forEach var="dept" items="${ dept }">
							<c:if test="${ dept.key gt 7 && dept.key lt 10 }">
								<div class="box_button" onclick="chart_click(${ dept.key }, '${ dept.value }')">${ dept.value }</div>
							</c:if>
						</c:forEach>
					</div>

					<div class="div_location" id="div_up_4">
						<c:forEach var="dept" items="${ dept }">
							<c:if test="${ dept.key gt 9 && dept.key lt 12 }">
								<div class="box_button" onclick="chart_click(${ dept.key }, '${ dept.value }')">${ dept.value }</div>
							</c:if>
						</c:forEach>
					</div>

					<div class="div_location" id="div_no_margin">
						<c:forEach var="dept" items="${ dept }">
							<c:if test="${ dept.key gt 11 && dept.key le 14 }">
								<div class="box_button" onclick="chart_click(${ dept.key }, '${ dept.value }')">${ dept.value }</div>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>
