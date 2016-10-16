<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결재자 지정</title>
<script type="text/javascript">
	$(document).ready(function() {
		

	});

	function select_dept() {
		var dept = $("#select_dept").val();
		// ID가 sido인 요소의 값을 불러옴

		var url = "getDeptMember.do";
		var params = "dept=" + dept;

		$
				.ajax({
					type : "post",
					url : url,
					data : params,
					dataType : "json",
					success : function(args) {

						$("#selected_mem_info input").each(function() { //id가 city인 option요소에 적용할 반복문
							$("#selected_mem_info input:eq(0)").remove(); // city option의 0번째 항목이 없을때까지 0번쨰 항목을 지운다. (기존에 있는거 모두 지운다.)
							$("#selected_mem_info label:eq(0)").remove(); 
						});

						for (var idx = 0; idx < args.mem_info.length; idx++) { // 새로 가져온 데이터를 데이터 갯수만큼 반복해서 붙여준다.
							$("#selected_mem_info")
									.append(
											"<input type='radio' name='chk_info' id='"+args.mem_info[idx].mem_num+"'><label for='"+args.mem_info[idx].mem_num+"' id='"+args.mem_info[idx].mem_num+"'>"
													+ args.mem_info[idx].com_dept_name
													+ " / "
													+ args.mem_info[idx].com_pos_name
													+ " / "
													+ args.mem_info[idx].name
													+ "</label>");

						}

					},
					error : function(e) {
						alert(e.responseText);
					}
				});
	}
</script>




<style type="text/css">
#form_wrapper {
	width: 100%;
	height: 480px;
}

#menu {
	display: block;
	width: 100%;
	height: 30px;
}

#left_form {
	display: inline;
	float: left;
	width: 50%;
	height: 450px;
}

#right_form {
	float: right;
	width: 50%;
	height: 450px;
	background-color: #ff0;
}

#select_approval_mem {
	position: relative;
	left: 85%;
}

#select_dept_form {
	text-align: center;
}

#selected_mem_info {
	width: 90%;
	height: 95%;
	border: 1px solid #000;
	margin: auto;
	overflow-x: hidden;
}

#button_form {
	width: 10%;
	float: left;
	height: inherit;
}

#approval_selected_div {
position:relative;
	float:left;
	left:10px;
	top:22px;
	width: 80%;
	margin:auto;
	height: 95%;
}
#add_mem{
position: relative;
top:40%;

margin-bottom: 5%;
}
#del_mem{
position: relative;
top:40%;

}
</style>


</head>
<body>
	<div id="form_wrapper">
		<div id="menu">
			<input type="button" class="btn btn-primary" id="select_approval_mem"
				value="선택 완료" />
		</div>
		<div id="left_form">
			<div id="select_dept_form">

				부서를 선택해 주세요 : <select id="select_dept" onchange="select_dept();">
					<option>선택하세요</option>
					<c:forEach var="dept_Name_EDI" items="${dept_Name_EDI}">
						<option>${dept_Name_EDI }</option>
					</c:forEach>
				</select>

			</div>
			<div id="selected_mem_info"></div>

		</div>

		<div id="right_form">

			<div id="button_form">
				<input type="button" class="btn btn-primary" id="add_mem" value=">" />
				<input type="button" class="btn btn-primary" id="del_mem" value="&lt" />
			</div>

			<div id="approval_selected_div"></div>

		</div>




	</div>



</body>
</html>