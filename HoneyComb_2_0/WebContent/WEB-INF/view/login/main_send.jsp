<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
${mem_num} mem_num<br>
${com_num} com_num<br>
${com_dept_num} dept num<br>
${com_pos_num} pos num<br>
${name} name<br>
${email} email<br> 
${phone_num }phone_num<br>
${com_name }com_name<br>
${com_dept_name }com_dept_name<br>
${com_pos_name }com_pos_name<br>



 <% response.sendRedirect("/HoneyComb_2_0/main/main.do"); %>   
</body>
</html>