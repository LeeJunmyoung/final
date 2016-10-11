<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script>
	function val_dept_check() {

		if (document.dept.com_dept_num.value == "선택하세요") {
			alert("변경할 부서를 선택해주세요");
			return false;
			
		} else {
			return true;
		}

	}

	function val_pos_check() {

		if (document.pos.com_pos_num.value == "선택하세요") {
			alert("변경할 직급을 선택해주세요");
			return false;
			
		} else {
			return true;
		}

	}
</script>
<style>
select {
	height: 25px;
	border-radius: 10px;
}

#center {
	width: 100%;
	height: 500px;
	margin: 0 auto;
	text-align: center;
}

.div_map {
	position: static;
}

.button {
	margin-left: 10px;
	width: 50px;
	display: inline-block;
	background-color: #4367b0;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	cursor: pointer;
	color: #fff;
	font-size: 12px;
	padding: 2px 2px;
	text-decoration: none;
	text-align: center;
}

.button:hover {
	background-color: #344d91;
	color: white;
}
</style>
</head>
<body>
	<div id="center">
		<c:if test="${ !empty dept_map }">
			<p>변경할 부서를 선택해주세요</p>
			<form method="post" action="/HoneyComb_2_0/dept/dept_change_pro"
				onsubmit="return val_dept_check()" name="dept">
				<div class="div_map">
					DEPARTMENT <select name="com_dept_num">
						<option value="선택하세요">선택하세요</option>
						<c:forEach var="dept" items="${ dept_map }">
							<option value="${ dept.key }">${ dept.value }</option>
						</c:forEach>
					</select><input type="submit" value="변경" class="button" />
				</div>
			</form>
		</c:if>



		<c:if test="${ !empty pos_map }">
			<p>변경할 직급을 선택해주세요</p>
			<form method="post" action="/HoneyComb_2_0/dept/pos_change_pro"
				onsubmit="return val_pos_check()" name="pos">
				<div class="div_map">
					AFFILIATE <select name="com_pos_num">
						<option value="선택하세요">선택하세요</option>
						<c:forEach var="pos" items="${ pos_map }">
							<option value="${ pos.key }">${ pos.value }</option>
						</c:forEach>
					</select><input type="submit" value="변경" class="button" />
				</div>
			</form>
		</c:if>
	</div>

</body>
</html>
