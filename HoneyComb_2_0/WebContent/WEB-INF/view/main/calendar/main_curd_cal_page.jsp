<%@page import="org.apache.jasper.tagplugins.jstl.core.Param" pageEncoding="utf-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<%request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${param.title }</title>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">



<script type="text/javascript">
function deleteCal() {
	<%
	String number = request.getParameter("num");
	request.setAttribute("calnum", number); 
	%>
	var cc = true;
	var url = "del_cal.cal?number="+<%=request.getParameter("num")%>;
	open(url,"confirm","toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=550,height=400");

	

	
	
}


</script>

<style type="text/css">
#form_title{
display: inline;
width:420px;
position: absolute;
top:20px;
left:30px;
}
#form_title p{
display: inline;
width: auto;
}
#form_title input{
display: inline;
width: 250px;
}


#form_date{
display: inline;
width:420px;
position: absolute;
top:80px;
left:30px;
}

#form_date p{
display: inline;

}
 
#form_date input{
display: inline;
width: 155px;
}
 
#form_contents{

display: inline;
width:420px;
position: absolute;
top:140px;
left:30px;

} 
 
#form_contents textarea{
position: relative;

display: inline;
width: 355px;
}
#form_contents p{
position:relative;
top:-60px;
display: inline;

} 

#form_button{
position: absolute;
top: 225px;
left:388px;

}


 
</style>




</head>
<body style="background: #e9ebee">
	<form  >
	
	
<div id = "form_title">		<p>제목 :</p> <input type="text"  name="subject" placeholder="SUBJECT" value="${cal_subject }" class="form-control" readonly="readonly" style="background-color: #fff;"/>
	</div>		 
 <div id = "form_date">	<p>	시작 :</p> <input type="date"	 name="start" placeholder="일" value="${cal_start}" class="form-control" readonly="readonly" style="background-color: #fff;"/> 
	<p>	종료 : </p> <input type="date"	 name="end" placeholder="일" value="${cal_end}" class="form-control" readonly="readonly" style="background-color: #fff;"/>
			 </div>
			 
			 
<div id = "form_contents">		<p>내용 :</p> <textarea rows="3"  cols="30" name="contents" placeholder="CONTENTS"  class="form-control" readonly="readonly" style="background-color: #fff;" >${cal_contents}</textarea>
			 </div>
			 
		
<div id= 'form_button'>
			 
			 <input type="hidden" class="btn btn-primary btn-xs" id="modify" value="수정"/>
			 <input type="hidden" class="btn btn-primary btn-xs" id ="del" value = "삭제" onclick="location.href='del_cal.cal?number=${param.num}'"/>
			 
			 
			 <input type="button" class="btn btn-primary btn-xs" value="닫기" onclick="window.close()" >
	</div>		 
			 
			  <input type="hidden"  name = "num" value="${cal_num}">
			 
</form>








</body>
</html>