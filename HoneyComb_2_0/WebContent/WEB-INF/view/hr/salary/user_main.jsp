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

function viewPaystub(mem_num) { // 급여명세서 보기
	url = "/HoneyComb_2_0/salary/paystub.do?mem_num="+mem_num;
	window
			.open(
					url,
					"post",
					"toolbar=no,width=800,height=600,directories=no,status=yes,scrollbars=yes,menubar=no");
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
							<th class="text-center" colspan="2">연봉</th>
							<td class="text-right" colspan="2">${salary.salary_year}</td>
						</tr>
						<tr>
							<th class="text-center" colspan="2">지급내용(과세)</th>
							<th class="text-center" colspan="2">지급내용(비과세)</th>
						</tr>
					</thead>
					
					<%-- <c:if test="${!empty salary}"> --%>
						<tbody>
							<tr>
								<th class="text-center">기본급</th>
								<td class="text-right">${salary.salary_month}</td>
								<th class="text-center">식대</th>
								<td class="text-right">${salary.costs_food}</td>
							</tr>
							<tr>
								<th class="text-center">야근수당</th>
								<td class="text-right">${salary.salary_add_time}</td>
								<th class="text-center">교통비</th>
								<td class="text-right">${salary.costs_transport}</td>
							</tr>
							<tr>
								<th class="text-center">휴가수당</th>
								<td class="text-right">${salary.salary_add_holiday}</td>
								<th class="text-center">복리후생</th>
								<td class="text-right">${salary.costs_benefit}</td>
							</tr>
							<tr>
								<th class="text-center">상여금</th>
								<td class="text-right">${salary.salary_bonus}</td>
								<th class="text-center">기타</th>
								<td class="text-right">${salary.costs_etc}</td>
								
							</tr>
							<tr>
								<th class="text-center">월급여액</th>
								<td class="text-right">${salary.salary_sum}</td>
								<th class="text-center">소득공제액</th>
								<td class="text-right">${salary.tax_sum}</td>
							</tr>
							<tr>
								<th class="text-center" colspan="2">실수령액</th>
								<td class="text-right" colspan="2">${salary.salary_sum - salary.tax_sum}</td>
							</tr>
						</tbody>

					<%-- </c:if> --%>

				</table>
				
				<input type="button" class="btn btn-primary btn-sm" value="급여 명세서 보기" onclick="viewPaystub(${salary.mem_num})">
		
		</div>
		
	</div>

</body>
</html>