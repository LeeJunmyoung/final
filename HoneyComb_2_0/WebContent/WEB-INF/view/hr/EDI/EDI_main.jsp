<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<html>
<head>
<title>notice</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function writeView() { // 공지 작성
		url = "writeForm.do";
		window
				.open(
						url,
						"post",
						"toolbar=no,width=800,height=980,left=300,directories=no,status=no,scrollbars=no,menubar=no");
	}
	
	
	$(document).ready(function() {
		
		$('.ing').click(function(){
			
			var EDI_num = this.id;
			url = "EDI_review_form.do?EDI_num="+EDI_num;
			window.open(
							url,
							"get",
							"toolbar=no,width=800,height=980,left=300,directories=no,status=no,scrollbars=no,menubar=no");
			
		})
		
		
		
	})
	
	
	
	
	
</script>

<style type="text/css">
.EDI_ing {
	width: 95%;
	height: 300px;
	margin: auto;
	border: 1px solid #eaeaea;
}

.EDI_ing_cover {
	margin: auto;
}
</style>


</head>
<body>
	<!-- 
	모든 결제된 서류들 
	 -->


	<div id="EDI_main">
	
	
	
	
		<div class="row">

			<div class="col-md-9">

				<b>결제함 <span class="badge">111</span></b>

			</div>

			<div class="col-md-1" style="margin-right: 3px;">

				<input type="button" class="btn btn-primary btn-xs btn-lg"
					value="새 문서" onclick="writeView()" />

			</div>

			<div class="col-md-1">

				<input type="button" class="btn btn-primary btn-xs" value="더보기"
					onclick="location.href='#'">

			</div>

		</div>

		<div class="row">

			<div class="col-md-11">




				<table class="table table-hover">
					<thead>
						<tr>
							<th class="text-center">문서번호</th>
							<th class="text-center">제목</th>
							<th class="text-center">부서</th>
							<th class="text-center">기안자</th>
							<th class="text-center">작성일</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${not empty EDI_Table_ing  }">
							<c:forEach var="EDI_Table_ing" items="${EDI_Table_ing }">
								<tr id='${EDI_Table.EDI_num }'>
									<th class="col-md-2 text-center">${EDI_Table_ing.document_num }</th>
									<th class="col-md-4">${EDI_Table_ing.EDI_Subject }</th>
									<th class="col-md-2 text-center">${EDI_Table_ing.writer_mem_dept }</th>
									<th class="col-md-2 text-center">${EDI_Table_ing.writer_mem_name }</th>
									<th class="col-md-3 text-center">${EDI_Table_ing.draftDate }</th>
								</tr>

							</c:forEach>
						</c:if>
						


					</tbody>
				</table>



			</div>

		</div>

	
	




	</div>
	
	
	
	<!-- 
	아래는 결제 진행함
	 -->
	 
	 
	 
	 
	<div id="EDI_wait">
	
		<div class="row">

			<div class="col-md-9">

				<b>결제 진행 함 <span class="badge">${EDI_Table_ing_count}</span></b>

			</div>

			<div class="col-md-1" style="margin-right: 3px;">

				<input type="hidden" class="btn btn-primary btn-xs btn-lg"
					value="새 문서" onclick="writeView()" />

			</div>

			<div class="col-md-1">

				<input type="button" class="btn btn-primary btn-xs" value="더보기"
					onclick="location.href='#'">

			</div>

		</div>

		<div class="row">

			<div class="col-md-11">




				<table class="table table-hover">
					<thead>
						<tr>
							<th class="text-center">문서번호</th>
							<th class="text-center">제목</th>
							<th class="text-center">부서</th>
							<th class="text-center">기안자</th>
							<th class="text-center">작성일</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${not empty EDI_Table_ing  }">
							<c:forEach var="EDI_Table_ing" items="${EDI_Table_ing }">
								<tr class='ing' id='${EDI_Table_ing.EDI_num }'>
									<th class="col-md-2 text-center">${EDI_Table_ing.document_num }</th>
									<th class="col-md-4">${EDI_Table_ing.EDI_Subject }</th>
									<th class="col-md-2 text-center">${EDI_Table_ing.writer_mem_dept }</th>
									<th class="col-md-2 text-center">${EDI_Table_ing.writer_mem_name }</th>
									<th class="col-md-3 text-center">${EDI_Table_ing.draftDate }</th>
								</tr>

							</c:forEach>
						</c:if>
						


					</tbody>
				</table>



			</div>

		</div>

	
	
	
	</div>
	<div id="EDI_temp"></div>






</body>
</html>
