<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

<script>
function init() {
	window.location.reload(true);
}
	
function approve(num) {
	var mem_num = num;
	var url = "/HoneyComb_2_0/accept/update_member?mem_num=" + mem_num;
	
	window
	.open(
			url,
			"post",
			"toolbar=no, left=400, top=150, width=350, height=100, directories=no, status=yes, scrollbar=yes, menubar=no");
}

function refusal(num) {
	var mem_num = num;
	var url = "/HoneyComb_2_0/accept/delete_member?mem_num=" + mem_num;
	
	window
	.open(
			url,
			"post",
			"toolbar=no, left=400, top=200, width=500, height=150, directories=no, status=yes, scrollbar=yes, menubar=no");
}

</script>
<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<style>
#member_check {
	position: relative;
	top: 30px;
	margin: auto;
}

#h1_tag {
	text-align: center;
}

table, tr, th, td {
	margin: 0 auto;
	border-collapse: collapse;
	border: 1px solid white;
	cellpadding: 0;
	cellspacing: 0;
	font-size: 16px;
	padding: 10px;
	text-align: center;
}

form {
	margin: auto;
}

.title {
	background: #344d91;
	color: white;
}

.title {
	background: #344d91;
	color: white;
}

#text {
	background: #e9ebee;
	color: black;
	cursor: pointer;
}

#text:HOVER {
	background-color: #A4A4A4;
	color: black;
}

/* #title>tbody {
	overflow-y: auto;
	overflow-x: hidden;
	max-height: 150px;
}

#title th {
	background: #344d91;
	color: white;
	font-size: 16px;
	letter-spacing: 1.5px;
	font-weight: bold;
	padding: px;
	text-align: center;
	color: white;
}

#text:nth-child(odd) {
	background-color: #e9ebee;
	color: black;
}

#text:hover {
	background-color: #A4A4A4;
	color: black;
}

#title_option tr {
	height: 31px;
} */
td {
	vertical-align: middle;
}

#back_button {
	position: relative;
	top: 60px;
}

#back_button {
	width: 50px;
	margin: auto;
}

#back_button_div {
	width: 60px;
	margin: auto;
}

#awaiter {
	font-size: 37px;
}

h4 {
	text-align: center;
}

#no_member {
	width: 500px;
	text-align: center;
	font-size: 16pt;
	margin: auto;
}

#name {
	width: 120px;
}

#dept {
	width: 150px;
}

#pos {
	width: 100px;
}

#accept {
	width: 150px;
}

#bu_pa_one {
	padding-left: 8px;
	padding-right: 8px;
	padding-top: 1px;
	padding-bottom: 1px;
	margin-right: 10px;
}

#bu_pa_two {
	padding-left: 8px;
	padding-right: 8px;
	padding-top: 1px;
	padding-bottom: 1px;
}

#h2_title {
	font-size: 30px;
	text-align: center;
}
</style>
</head>





<body>


	<div id='h1_tag'>
		<br> <br> <br> <br>
		<h2 id="h2_title">ACCEPT</h2>
		<br> <br> <br> <br> <br />
		<c:if test="${ !empty awaiter_list }">
			<h4>"${ count }"명의 승인 대기자가 조회되었습니다</h4>
		</c:if>
	</div>
	<div id="member_check">

		<c:if test="${!empty awaiter_list }">
			<table border='1px'>
				<tr>
					<td class="title">이름</td>
					<td class="title">부서</td>
					<td class="title">직책</td>
					<td class="title">승인 / 거절</td>
				</tr>

				<c:forEach var="member" items="${ awaiter_list }">

					<tr id='text'>
						<td id="name">${member.name}</td>
						<td id="dept">${member.com_dept_name}</td>
						<td id="pos">${member.com_pos_name}</td>
						<td id="accept"><input type="button" value="승인"
							class="btn btn-primary btn-xs" id="bu_pa_one"
							onclick="approve(${member.mem_num})"> <input
							type="button" value="거절" class="btn btn-primary btn-xs"
							id="bu_pa_two" onclick="refusal(${member.mem_num})"></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

		<c:if test="${empty awaiter_list }">
			<p id='no_member'>승인 대기자가 없습니다</p>
		</c:if>


	</div>


</body>
</html>
