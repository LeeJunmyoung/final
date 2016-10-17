<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

<script>

function writeSalary(mem_num) { // salary 입력
	url = "/HoneyComb_2_0/salary/management_writeForm.do?mem_num="+mem_num;
	window
			.open(
					url,
					"post",
					"toolbar=no,width=300,height=350,directories=no,status=yes,scrollbars=yes,menubar=no");
}

</script>

<script>
	$(document).ready(function() {
		
		if(${dept_num} > -1) {
			
			$("#sel_1").val(1).attr("selected", "selected");
			
			$('#sel_2_dept').css("display", "");
			$('#sel_2_pos').css("display", "none");
			
			$("#sel_2_dept").val(${dept_num}).attr("selected", "selected");
			
		}else if(${pos_num} > -1) {
			
			$("#sel_1").val(2).attr("selected", "selected");
			
			$('#sel_2_dept').css("display", "none");
			$('#sel_2_pos').css("display", "");
			
			$("#sel_2_pos").val(${pos_num}).attr("selected", "selected");
			
		} else {
			
			$("#sel_1").val(0).attr("selected", "selected");
			
			$('#sel_2_dept').css("display", "none");
			$('#sel_2_pos').css("display", "none");
			
		}

		$('#sel_1').change(function() {

			if ($('#sel_1 option:selected').val() == 0) {
				$('#sel_2_dept').css("display", "none");
				$('#sel_2_pos').css("display", "none");
				
				$(location).attr('href', "/HoneyComb_2_0/salary/management_main.do");
				
			} else if ($('#sel_1 option:selected').val() == 1) {
				$('#sel_2_dept').css("display", "");
				$('#sel_2_pos').css("display", "none");
			} else if ($('#sel_1 option:selected').val() == 2) {
				$('#sel_2_dept').css("display", "none");
				$('#sel_2_pos').css("display", "");
			}

		});

		$('#sel_2_dept').change(function() {

			if ($('#sel_2_dept option:selected').val() != null) {
				
				$(location).attr("href", "/HoneyComb_2_0/salary/management_main.do?dept_num="
					+ $('#sel_2_dept option:selected').val());
				
			}

		});

		$('#sel_2_pos').change(function() {

			if ($('#sel_2_pos option:selected').val() != null) {
				
				$(location).attr('href', "/HoneyComb_2_0/salary/management_main.do?pos_num="
					+ $('#sel_2_pos option:selected').val());
				
			}

		});

	});

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
					
						<select class="form-control" id="sel_1">
							<option value="0">전체</option>
							<option value="1">부서별</option>
							<option value="2">직급별</option>
						</select>

					</span>
					
					<span class="col-md-3">
					 
						<select class="form-control" id="sel_2_dept">
							<c:forEach var="item" items="${dept}">
								<option value="${item.com_dept_num}">${item.com_dept_name}</option>
							</c:forEach>
						</select>
						
						<select class="form-control" id="sel_2_pos">
							<c:forEach var="item" items="${pos}">
								<option value="${item.com_pos_num}">${item.com_pos_name}</option>
							</c:forEach>
						</select>

					</span>

				</form>
				
				<span class="col-md-3"> 
					
				</span>
				
				<span class="col-md-3 text-right"> 
					
						<b>단위 : 천원</b>

				</span>

			</div>

			<div class="row">

				<c:set var="sum" value="" />

				<table class="table table-bordered" style="margin-top: 20px">
					<thead>
						<tr>
							<th class="text-center" rowspan="2">이름</th>
							<th class="text-center" rowspan="2">부서</th>
							<th class="text-center" rowspan="2">직급</th>
							<th class="text-center" colspan="4">지급내용(과세)</th>
							<th class="text-center" colspan="4">지급내용(비과세)</th>
							<th class="text-center" rowspan="2">합계</th>
							<th class="text-center" rowspan="2"> </th>
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

					<c:if test="${empty salaryList}">

						<tbody>
							<tr>
								<td class="text-center" colspan="12">해당 인원이 없습니다.</td>
							</tr>
						</tbody>

					</c:if>

					<c:if test="${!empty salaryList}">
						<tbody>
							<c:forEach var="item" items="${salaryList}">
								<tr id="${item.mem_num}">
									<td class="text-center">${item.name}</td>
									<td class="text-center">${item.com_dept_name}</td>
									<td class="text-center">${item.com_pos_name}</td>
									<td class="text-center">${item.salary_month / 1000}</td>
									<td class="text-center">${item.salary_add_time / 1000}</td>
									<td class="text-center">${item.salary_add_holiday / 1000}</td>
									<td class="text-center">${item.salary_bonus / 1000}</td>
									<td class="text-center">${item.costs_food / 1000}</td>
									<td class="text-center">${item.costs_transport / 1000}</td>
									<td class="text-center">${item.costs_benefit / 1000}</td>
									<td class="text-center">${item.costs_etc / 1000}</td>
									<td class="text-center">${item.salary_sum / 1000}</td>
									<td class="text-center">
										<input type="button" class="btn btn-primary btn-xs" value="입력" onclick="writeSalary(${item.mem_num})">
									</td>
								</tr>
							</c:forEach>
						</tbody>

					</c:if>


				</table>

			</div>

			<!-- <div class="col-md-1"></div> -->

		</div>

	</div>

</body>
</html>