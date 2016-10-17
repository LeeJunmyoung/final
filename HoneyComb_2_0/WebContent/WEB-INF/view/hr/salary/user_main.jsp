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

function viewSalary(mem_num) { // salary 자세히보기
	url = "/HoneyComb_2_0/salary/user_view.do?mem_num="+mem_num;
	window
			.open(
					url,
					"post",
					"toolbar=no,width=900,height=350,directories=no,status=yes,scrollbars=yes,menubar=no");
}

</script>

<body>

	<div class="row">

		<div class="col-md-9">

			<b>SALARY <span class="badge">연봉 : ${salary.salary_year / 10000} 만원</span></b>

		</div>

		<div class="col-md-1"></div>

		<div class="col-md-1">

		</div>

	</div>

	<div class="row" style="margin-top: 7px;">
	
		<div class="col-md-1"></div>

		<div class="container col-md-10">

			<table class="table table-bordered" style="margin-top: 20px">
					<thead>
						<tr>
							<th class="text-center" rowspan="12">연봉</th>
						</tr>
						<tr>
							<td class="text-center" rowspan="12">${salary.salary_year}</td>
						</tr>
						<tr>
							<th class="text-center" rowspan="6">지급내용(과세)</th>
							<th class="text-center" rowspan="6">지급내용(비과세)</th>
						</tr>
					</thead>
					
					<c:if test="${!empty salary}">
						<tbody>
							<tr>
								<th class="text-center" rowspan="3">기본급</th>
								<td class="text-center" rowspan="3">${salary.salary_month}</td>
								<th class="text-center" rowspan="3">식대</th>
								<td class="text-center" rowspan="3">${salary.costs_food}</td>
							</tr>
							<tr>
								<th class="text-center" rowspan="3">야근수당</th>
								<td class="text-center" rowspan="3">${salary.salary_add_time}</td>
								<th class="text-center" rowspan="3">교통비</th>
								<td class="text-center" rowspan="3">${salary.costs_transport}</td>
							</tr>
							<tr>
								<th class="text-center" rowspan="3">휴가수당</th>
								<td class="text-center" rowspan="3">${salary.salary_add_holiday}</td>
								<th class="text-center" rowspan="3">복리후생</th>
								<td class="text-center" rowspan="3">${salary.costs_benefit}</td>
							</tr>
							<tr>
								<th class="text-center" rowspan="3">상여금</th>
								<td class="text-center" rowspan="3">${salary.salary_bonus}</td>
								<th class="text-center" rowspan="3">기타</th>
								<td class="text-center" rowspan="3">${salary.costs_etc}</td>
								
							</tr>
							<tr>
								<th class="text-center" rowspan="3">월급여액</th>
								<td class="text-center" rowspan="3">${salary.salary_sum}</td>
								<th class="text-center" rowspan="3">소득공제액</th>
								<td class="text-center" rowspan="3">${salary.tax_sum}</td>
							</tr>
							<tr>
								<th class="text-center" rowspan="6">실수령액</th>
								<td class="text-center" rowspan="6">${salary.salary_sum - salary.tax_sum}</td>
							</tr>
						</tbody>

					</c:if>

				</table>
				
				<input type="button" class="btn btn-primary btn-xs" value="입력" onclick="viewSalary(${salary.mem_num})">
		
		</div>
		
	</div>

</body>
</html>