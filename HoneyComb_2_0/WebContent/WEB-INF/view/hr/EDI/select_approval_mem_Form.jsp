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

		$('#select_approval_mem').click(function(){
		
			if(chkchk()){
			 $('input:checkbox[name="chk_box1"]').each(function() {
				 this.checked = true; 
				 
			 });
			 $('input:checkbox[name="chk_box2"]').each(function() {
				 this.checked = true; 
				 
			 });
			 $('#mem_submit').click();
			}
			
			
			
			
			
		})
		
		
		

		$('#ref_add_mem').click(function (){
			 var checked = $(":input:radio[name=chk_info]:checked").attr("id");
			 var name = $("."+checked).text()			 						
			$('#'+checked).remove();
			$('.'+checked).remove();
			
			 $("#ref_box")
				.append(
						"<input type='checkbox' name='chk_box' id='"+checked+"'  value='"+checked+"' onclick='chk_color()' ><label for='"+checked+"' class='"+checked+"'>"
								+ name
								+ "</label>");
			
			
		})
		
		$('#ref_del_mem').click(function (){
			 $('input:checkbox[name="chk_box"]').each(function() {

			      

			      if(this.checked){//checked 처리된 항목의 값
						var check= this.id;
						 var name = $("."+check).text()
						 $('#'+check).remove();
						 $('.'+check).remove();
							$("#selected_mem_info")
							.append(
									"<input type='radio' name='chk_info' id='"+check+"'><label for='"+check+"' class='"+check+"'>"
											+ name
											+ "</label>");	
			            

			      }

			 });
			
			
			
			
		})
		
		
		
		//가운데 버튼 실행
		
		
		$('#mid_add_mem').click(function (){
			 var checked = $(":input:radio[name=chk_info]:checked").attr("id");
			 var name = $("."+checked).text()			 						
			$('#'+checked).remove();
			$('.'+checked).remove();
			
			 $("#mid_box")
				.append(
						"<input type='checkbox' name='chk_box1' id='"+checked+"' value='"+checked+"' onclick='chk_color()' ><label for='"+checked+"' class='"+checked+"'>"
								+ name
								+ "</label>");
			
			
		})
		
		$('#mid_del_mem').click(function (){
			 $('input:checkbox[name="chk_box1"]').each(function() {

			      

			      if(this.checked){//checked 처리된 항목의 값
						var check= this.id;
						 var name = $("."+check).text()
						 $('#'+check).remove();
						 $('.'+check).remove();
							$("#selected_mem_info")
							.append(
									"<input type='radio' name='chk_info' id='"+check+"'><label for='"+check+"' class='"+check+"'>"
											+ name
											+ "</label>");	
			            

			      }

			 });
			
			
			
			
		})
		
		//마지막 버튼
		
		
		$('#fin_add_mem').click(function (){
			 var checked = $(":input:radio[name=chk_info]:checked").attr("id");
			 var name = $("."+checked).text()			 						
			$('#'+checked).remove();
			$('.'+checked).remove();
			
			 $("#fin_approval_mem")
				.append(
						"<input type='checkbox' name='chk_box2' id='"+checked+"' value='"+checked+"' onclick='chk_color()' ><label for='"+checked+"' class='"+checked+"'>"
								+ name
								+ "</label>"); 
			
			
		})
		
		$('#fin_del_mem').click(function (){
			 $('input:checkbox[name="chk_box2"]').each(function() {

			      

			      if(this.checked){//checked 처리된 항목의 값
						var check= this.id;
						 var name = $("."+check).text()
						 $('#'+check).remove();
						 $('.'+check).remove();
							$("#selected_mem_info")
							.append(
									"<input type='radio' name='chk_info' id='"+check+"'><label for='"+check+"' class='"+check+"'>"
											+ name
											+ "</label>");	
			            

			      }

			 });
			
			
			
			
		})
		
		
		
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
											"<input type='radio' name='chk_info' id='"+args.mem_info[idx].mem_num+"' onclick='chk_color()'><label for='"+args.mem_info[idx].mem_num+"' class='"+args.mem_info[idx].mem_num+"'>"
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
<script type="text/javascript">
function chkchk(){
	var c = 0;
	$('input:checkbox[name="chk_box"]').each(function() {
		 c++;
		 
	 });
	if(c>0){
		alert("참고자는 아직 지원하지 않는 기능입니다");
		return false;
	}
	c=0;
	 $('input:checkbox[name="chk_box1"]').each(function() {
		 
		c++; 
	 });
	 if(c>1||c==0){
			alert("1명만 선택해 주세요");
			return false;
		}
		c=0;
	 
	 $('input:checkbox[name="chk_box2"]').each(function() {
		 
		 c++;
	 });
	 if(c>1||c==0){
			alert("1명만 선택해 주세요");
			return false;
		}
		c=0;
	
	
	return true;
}
function chk_color(){
	 $('input:checkbox[name="chk_box"]').each(function() {
		 if(this.checked){
		 var id = this.id;
		$('.'+id).css('background-color','#B2CCFF');
		 }
	 });
	 $('input:checkbox[name="chk_box"]').each(function() {
		 if(!this.checked){
		 var id = this.id;
		$('.'+id).css('background-color','#fff');
		 }
	 });
	 $('input:checkbox[name="chk_box1"]').each(function() {
		 if(this.checked){
		 var id = this.id;
		$('.'+id).css('background-color','#B2CCFF');
		 }
	 });
	 $('input:checkbox[name="chk_box1"]').each(function() {
		 if(!this.checked){
		 var id = this.id;
		$('.'+id).css('background-color','#fff');
		 }
	 });
	 $('input:checkbox[name="chk_box2"]').each(function() {
		 if(this.checked){
		 var id = this.id;
		$('.'+id).css('background-color','#B2CCFF');
		 }
	 });
	 $('input:checkbox[name="chk_box2"]').each(function() {
		 if(!this.checked){
		 var id = this.id;
		$('.'+id).css('background-color','#fff');
		 }
	 });
	 $('input:radio[name="chk_info"]').each(function() {
		 if(this.checked){
		 var id = this.id;
		$('.'+id).css('background-color','#B2CCFF');
		 }
	 });
	 
	 $('input:radio[name="chk_info"]').each(function() {
		 if(!this.checked){
		 var id = this.id;
		$('.'+id).css('background-color','#fff');
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
	padding:10px;
	overflow-x: hidden;
}

#button_form {
	width: 10%;
	position: relative;
	left: -5px; float : left;
	height: inherit;
	float: left;
}

label {
	font-size: 13pt;
}

#approval_selected_div {
	position: relative;
	float: left;
	left: 10px;
	top: 22px;
	width: 80%;
	margin: auto;
	height: 95%;
}

#ref_add_mem {
	position: relative;
	top: 20%;
	margin-bottom: 5%;
}

#ref_del_mem {
	position: relative;
	top: 20%;
}

#mid_approval_mem {
	display: block;
	height: 200px;
}

#ref_box {
	height: 180px;
	border: 1px solid #000;
}

#mid_box {
	height: 100px;
	border: 1px solid #000;
}

#fin_approval_mem {
	height: 90px;
	border: 1px solid #000;
}
#mid_add_mem,#mid_del_mem{
position: relative;
	top: 43%;
	margin-bottom: 5%;
}
#fin_add_mem,#fin_del_mem{
position: relative;
	top: 53%;
	margin-bottom: 5%;
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

<form method="post"  >

		<div id="right_form">

			<div id="button_form">
				<input type="button" class="btn btn-primary" id="ref_add_mem" value=">"  />
				<input type="button" class="btn btn-primary" id="ref_del_mem"
					value="&lt" />
					
				<input type="button" class="btn btn-primary" id="mid_add_mem" value=">"  />
				<input type="button" class="btn btn-primary" id="mid_del_mem"
					value="&lt" />
					
				<input type="button" class="btn btn-primary" id="fin_add_mem" value=">"  />
				<input type="button" class="btn btn-primary" id="fin_del_mem"
					value="&lt" />	
					
			</div>

			<div id="approval_selected_div">
				<div id="mid_approval_mem">
					참고자
					<div id="ref_box"></div>

				</div>
				검토자
				<div id="mid_box"></div>
				결재자
				<div id="fin_approval_mem"></div>

			</div>

		</div>

<input type="submit" id="mem_submit" style="position: absolute;left: -999px;" >

</form>


	</div>



</body>
</html>