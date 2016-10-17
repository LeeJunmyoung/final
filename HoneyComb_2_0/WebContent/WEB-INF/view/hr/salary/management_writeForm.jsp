<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>salary write</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script>
	
	function onlyNumber(event){
		event = event || window.event;
		var keyID = (event.which) ? event.which : event.keyCode;
		if ( (keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105) || keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
			return;
		else
			return false;
	}
	
	function removeChar(event) {
		event = event || window.event;
		var keyID = (event.which) ? event.which : event.keyCode;
		if ( keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
			return;
		else
			event.target.value = event.target.value.replace(/[^0-9]/g, "");
	}
	
</script>

</head>
<body style="background-color: #e9ebee;">
	
	<div class="col-md-1"></div>

	<form class="col-md-10" role="form" method="post"
		name="salaryWriteform"
		action="/HoneyComb_2_0/salary/management_writePro.do?salary_num=${salary.salary_num}"
		>

		<div class="form-group" style="margin-top: 20px;">
			<label for="salary_year">연봉 :</label>
			<input type="text" class="form-control" id="salary_year" name="salary_year" value="${salary.salary_year}" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' style='ime-mode:disabled;'>
		</div>

		<div class="row" style="margin-top: 30px;">

			<div class="col-md-6" >

				<div class="row text-center">
					<b>[ 과세 ]</b>
				</div>

				<div class="form-group" style="margin-top: 10px;">
					<label for="salary_add_time">야근수당 :</label>
					<input type="text" class="form-control col-md-5" id="salary_add_time" name="salary_add_time" value="${salary.salary_add_time}" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' style='ime-mode:disabled;'>
				</div>

				<div class="form-group" style="margin-top: 10px;">
					<label for="salary_add_holiday">휴가수당 :</label>
					<input type="text" class="form-control" id="salary_add_holiday" name="salary_add_holiday" value="${salary.salary_add_holiday}" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' style='ime-mode:disabled;'>
				</div>
				
				<div class="form-group" style="margin-top: 10px;">
					<label for="salary_bonus">상여금 :</label>
					<input type="text" class="form-control" id="salary_bonus" name="salary_bonus" value="${salary.salary_bonus}" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' style='ime-mode:disabled;'>
				</div>

			</div>

			<div class="col-md-6">

				<div class="row text-center">
					<b>[ 비과세 ]</b>
				</div>

				<div class="form-group" style="margin-top: 10px;">
					<label for="costs_food">식대 :</label>
					<input type="text" class="form-control" id="costs_food" name="costs_food" value="${salary.costs_food}" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' style='ime-mode:disabled;'>
				</div>
				
				<div class="form-group" style="margin-top: 10px;">
					<label for="costs_transport">교통비 :</label>
					<input type="text" class="form-control" id="costs_transport" name="costs_transport" value="${salary.costs_transport}" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' style='ime-mode:disabled;'>
				</div>
				
				<div class="form-group" style="margin-top: 10px;">
					<label for="costs_benefit">복리후생 :</label>
					<input type="text" class="form-control" id="costs_benefit" name="costs_benefit" value="${salary.costs_benefit}" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' style='ime-mode:disabled;'>
				</div>
				
				<div class="form-group" style="margin-top: 10px;">
					<label for="costs_etc">기타 :</label>
					<input type="text" class="form-control" id="costs_etc" name="costs_etc" value="${salary.costs_etc}" onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' style='ime-mode:disabled;'>
				</div>

			</div>
			
		</div>

		<input type="submit" class="btn btn-primary btn-sm" style="margin-top: 10px; margin-bottom: 10px;" value="입력">

	</form>
	
	<div class="col-md-1"></div>

</body>
</html>