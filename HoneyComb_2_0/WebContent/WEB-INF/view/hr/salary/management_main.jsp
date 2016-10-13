<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

<script>
	function setSel_Option() {
		
		var select = document.getElementById("sel_1");

		if(select.options[select.selectedIndex].value == 0) {
			 sel_2_dept.style.display = 'none';
			 sel_2_pos.style.display = 'none';
		 } else if(select.options[select.selectedIndex].value == 1) {
			 sel_2_dept.style.display = '';
			 sel_2_pos.style.display = 'none';
		 } else if(select.options[select.selectedIndex].value == 2) {
			 sel_2_dept.style.display = 'none';
			 sel_2_pos.style.display = '';
		 }
		
	}

	function setMemberSalaryList() {
		
		var select_dept = document.getElementById("sel_2_dept");
		var select_pos = document.getElementById("sel_2_pos");
		
		if(select_dept.options[select_dept.selectedIndex].value != null) {
			
		} else if(select_pos.options[select_pos.selectedIndex].value != null) {
			
		} else {
			
		}
		
	}
</script>

<body>

	<div class="row">

		<div class="col-md-9">

			<b>SALARY MENAGEMENT</b>

		</div>

	</div>

	<div class="row" style="margin-top: 7px;">

		<!-- <div class="col-md-1"></div> -->

		<div class="container col-md-12">

			<div class="row">

				<form id="select_search" style="margin-top: 20px">

					<span class="col-md-3">
						<select class="form-control" id="sel_1" onchange="setSel_Option()">
							<option value="0">전체</option>
							<option value="1">부서별</option>
							<option value="2">직급별</option>
						</select>
					</span> 
					
					<span class="col-md-3"> 
						<select class="form-control" id="sel_2_dept" onchange="setMemberSalaryList()" style="display: none;">
							<c:forEach var="item" items="${dept}">
								<option value="${item.com_dept_num}">${item.com_dept_name}</option>
							</c:forEach>
						</select> 
					
						<select class="form-control" id="sel_2_pos" onchange="setMemberSalaryList()" style="display: none;">
							<c:forEach var="item" items="${pos}">
								<option value="${item.com_pos_num}">${item.com_pos_name}</option>
							</c:forEach>
						</select>

					</span>

				</form>

			</div>
			
			<div class="row">
			
				<%-- <c:if test="${notice_count > 0}"> --%>
				
				<c:set var="sum" value=""/>

	  				<table class="table table-bordered" style="margin-top: 20px">
						<thead>
							<tr>
								<th class="text-center" rowspan="2">이름</th>
								<th class="text-center" rowspan="2">부서</th>
								<th class="text-center" rowspan="2">직급</th>
								<th class="text-center" colspan="4">지급내용(과세)</th>
								<th class="text-center" colspan="4">지급내용(비과세)</th>
								<th class="text-center" rowspan="2">합계</th>
							</tr>
							<tr>
								<th class="text-center">기본급</th>
								<th class="text-center">야근수당</th>
								<th class="text-center">휴가수당</th>
								<th class="text-center">상여금</th>
								<th class="text-center">식대</th>
								<th class="text-center">교통비</th>
								<th class="text-center">복리후생</th>
								<th class="text-center">기타</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${salaryList}">
								<tr id="${item.mem_num}">
									<td class="text-center">${item.name}</td>
									<td class="text-center">${item.com_dept_num}</td>
									<td class="text-center">${item.com_pos_num}</td>
									<td class="text-center">${item.salary_year / 12}</td>
									<td class="text-center">${item.salary_add_time}</td>
									<td class="text-center">${item.salary_add_holiday}</td>
									<td class="text-center">${item.salary_bonus}</td>
									<td class="text-center">${item.costs_food}</td>
									<td class="text-center">${item.costs_transport}</td>
									<td class="text-center">${item.costs_benefit}</td>
									<td class="text-center">${item.costs_etc}</td>
									<td class="text-center">${item.costs_etc}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
	
				<%-- </c:if> --%>
			
			</div>
			
			<!-- <div class="col-md-1"></div> -->

		</div>

	</div>

</body>
</html>