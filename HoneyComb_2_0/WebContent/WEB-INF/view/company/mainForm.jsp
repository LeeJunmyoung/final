<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script>
	function inputCheck() {

		if (!document.com_regi.com_name.value) {
			alert("사업장명을 입력하세요");
			return false;
		}

		if (!document.com_regi.com_add.value) {
			alert("주소를 입력하세요");
			return false;
		}

		if (!document.com_regi.com_phone1.value) {
			alert("전화번호를 입력하세요");
			return false;
		}

		if (!document.com_regi.com_phone2.value) {
			alert("전화번호를 입력하세요");
			return false;
		}

		if (!document.com_regi.com_phone3.value) {
			alert("전화번호를 입력하세요");
			return false;
		}

		if (document.com_regi.com_aff.value == "선택하세요") {
			alert("계열을 선택하세요");
			return false;
		}

		return true;

	}
</script>
<script>
	function searchCheck() {

		if (!document.com_search.com_name.value) {
			alert("사업장을 선택해주세요");
			return false;
		}

		if (document.com_search.com_dept_num.value == "선택하세요") {
			alert("부서를 선택하세요");
			return false;
		}

		if (document.com_search.com_pos_num.value == "선택하세요") {
			alert("직급을 선택하세요");
			return false;
		}

		return true;

	}

	function companyCheck() {

		url = "/Final_Testing/company/com_searchForm";

		window
				.open(
						url,
						"post",
						"toolbar=no, left=200, top=100, width=700, height=400, directories=no, status=yes, scrollbar=yes, menubar=no");
	}
</script>
<script type='text/javascript'
	src='http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js'></script>
<script>
	$(document).ready(function() {
		$("#one").click(function() {
			/* 			$("#one").css("background", "#fff");
			 $("#one").css("color", "black");
			 $("#two").css("background", "#344d91");
			 $("#two").css("color", "white"); */
			$("#company_form").css("display", "block");
			$("#company_find_form").css("display", "none");
		});
		$("#one").mouseenter(function() {
			$("#one").css("background", "#fff");
			$("#one").css("color", "black");
		});
		$("#one").mouseleave(function() {
			$("#one").css("background", "#344d91");
			$("#one").css("color", "#fff");
		});

		$("#two").mouseenter(function() {
			$("#two").css("background", "#fff");
			$("#two").css("color", "black");
		});

		$("#two").mouseleave(function() {
			$("#two").css("background", "#344d91");
			$("#two").css("color", "#fff");
		});
		$("#two").click(function() {
			/* $("#one").css("background", "#344d91");
			$("#one").css("color", "white");
			$("#two").css("background", "#fff");
			$("#two").css("color", "black"); */
			$("#company_form").css("display", "none");
			$("#company_find_form").css("display", "block");
		});
	});
</script>

<style>
#content {
	position: absolute;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 100;
	filter: alpha(opacity = 50);
	background: #e9ebee;
}
/* 4367b0 */
#main {
	background: #e9ebee;
	position: relative;
	top: 100px;
	height: 80%;
	width: 450px;
	margin: 0 auto;
}

#menu {
	display: block;
	height: 30px;
	width: 100%;
	z-index: -99;
}

input[type=radio].ch {
	display: none;
}

#menu>label {
	/* 수평 정렬 */
	display: block;
	float: left;
	/* 크기 및 글자 위치 지정*/
	width: 225px;
	height: 30px;
	line-height: 30px;
	text-align: center;
	/* 테두리 지정 */
	box-sizing: border-box;
	border: 1px solid;
}

#menu>label[for=menu_one]:HOVER, #menu>label[for=menu_two]:HOVER {
	background: #fff;
	color: black;
}

#menu>label#one {
	border-right: 0.5px solid;
	border-top-left-radius: 10px;
	background: #344d91;
	color: white;
}

#menu>label#two {
	border-left: 0.5px solid;
	border-top-right-radius: 10px;
	background: #344d91;
	color: white;
}

#company_form {
	display: block;
	position: absolute;
	top: 70px;
	width: 100%;
	margin: 0 auto;
	text-align: center;
}

#company_find_form {
	display: none;
	position: absolute;
	top: 70px;
	width: 100%;
	margin: 0 auto;
	text-align: center;
}

#company_contents {
	background: #fff;
	margin: 0 auto;
	display: block;
	z-index: 3;
	width: 100%;
	height: 90%;
	border-bottom-left-radius: 10px;
	border-bottom-right-radius: 10px;
}

#search {
	width: 20px;
	height: 20px;
	cursor: pointer;
}

#search_map {
	width: 450px;
	height: 50px;
}

#div_text {
	float: left;
	width: 365px;
	height: 50px;
	margin-left: 22px;
}

.search {
	top: 4px;
	float: right;
	margin-right: 33px;
	margin-top: 15px;
}

a.search {
	display: inline-block;
	width: 25px;
	height: 30px;
	background: url(/Final_Testing/resources/images/search_one.png)
		no-repeat;
	background-size: 25px;
}

a:HOVER.search {
	background: url(/Final_Testing/resources/images/search_two.png)
		no-repeat;
	background-size: 25px;
}

a:HOVER.search #div_search {
	border: 2px solid black;
}

a.search span {
	display: none;
}

.submit {
	background-color: #4367b0;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	display: inline-block;
	cursor: pointer;
	color: #fff;
	font-size: 15px;
	padding: 8px 25px;
	text-decoration: none;
}

.submit:hover {
	background-color: #344d91;
}

.submit:active {
	position: relative;
	top: 1px;
}

input[type=text] {
	height: 30px;
	border-radius: 5px 5px 5px 5px;
	font-size: 16px;
	padding-left: 10px;
	text-align: lift;
}

.cname {
	width: 340px;
	margin: 10px;
}

.cadd {
	width: 340px;
	margin: 10px;
}

.cphone {
	width: 70px;
	margin-top: 10px;
}

select {
	width: 120px;
	height: 30px;
	padding-left: 5px;
	border-radius: 5px 5px 5px 5px;
	margin: 10px;
	font-size: 16px;
}

hr {
	width: 400px;
	border-top: 1px solid #bbb;
	border-bottom: 1px solid #fff;
}

hr : after {
	content: '';
	display: block;
	margin-top: 3px;
	border-top: 1px solid #bbb;
	border-bottom: 1px solid #fff;
}

h3 {
	font-size: 18px;
	font-weight: 700;
}
</style>

</head>
<body>

	<div id="content">

		<div id="main">


			<div id="menu">
				<input type="radio" id="menu_one" value="사업장 등록" class="ch">
				<input type="radio" id="menu_two" value="내 회사 등록" class="ch">
				<label for="menu_one" id="one">사업장 등록</label> <label for="menu_two"
					id="two">내 회사 등록</label>
			</div>


			<div id="company_contents">
				<div id="company_form">
					<form name="com_regi" method="post"
						action="/Final_Testing/company/temp_com">
						<h3>사업장 등록</h3>
						<hr class="subject">
						<input type="text" placeholder="COMPANY NAME" name="com_name"
							class="cname" size="10"><br> <input type="text"
							placeholder="ADDRESS" name="com_add" class="cadd" size="30"><br>
						PHONE <input type="text" name="com_phone1" size="3" class="cphone"
							maxlength="3"> - <input type="text" name="com_phone2"
							size="4" class="cphone" maxlength="4"> - <input
							type="text" name="com_phone3" size="4" class="cphone"
							maxlength="4"><br> <br> AFFILIATE<select
							name="com_aff">
							<option value="선택하세요">선택하세요</option>
							<c:forEach var="aff_list" items="${ aff_list }">
								<option value="${ aff_list }">${ aff_list }</option>
							</c:forEach>
						</select>
						<hr>
						<br> <br> <a href="javascript:com_regi.submit();"
							onclick="return inputCheck()" class="submit">등록완료</a>
						<!-- <input type="submit" value="등록하기" /> -->
					</form>
				</div>

				<!-- <img src="/Final_Testing/view/search.png" id="search" value="찾기" onClick="companyCheck();"> -->

				<div id="company_find_form">
					<form name="com_search" method="post"
						action="/Final_Testing/company/mem_com_update">
						<!-- onSubmit="return searchCheck()" -->
						<h3>내 회사 등록</h3>
						<hr class="subject">
						<div id="search_map">
							<div id="div_text"><input type="text" placeholder="COMPANY NAME SEARCH"
								name="com_name" class="cname" readonly></div> <a
								href="#companyCheck" onclick="companyCheck();return false;"
								onkeypress="this.onclick" class="search"><span>search</span></a>
						</div>

						<br> <input type="hidden" name="com_num" /> DEPARTMENT <select
							name="com_dept_num">
							<option value="선택하세요">선택하세요</option>
							<c:forEach var="dept" items="${ dept_map }">
								<option value="${dept.key}">${ dept.value }</option>

							</c:forEach>
						</select> <br> POSITION <select name="com_pos_num">
							<option value="선택하세요">선택하세요</option>
							<c:forEach var="pos" items="${ pos_map }">
								<option value="${ pos.key }">${ pos.value }</option>
							</c:forEach>
						</select>
						<hr>
						<br> <br> <a href="javascript:com_search.submit();"
							onclick="return searchCheck()" class="submit">등록완료</a>
					</form>
				</div>
			</div>

		</div>
	</div>


</body>
</html>
