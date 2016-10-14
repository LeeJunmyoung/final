<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
request.getSession().setAttribute("mem_num", "10007");
request.getSession().setAttribute("name", "user7");
request.getSession().setAttribute("email", "user7@naver.com");
request.getSession().setAttribute("phone_num", "1000007");
request.getSession().setAttribute("com_num", 1001);
request.getSession().setAttribute("com_dept_num", "2");
request.getSession().setAttribute("com_pos_num", "3");
request.getSession().setAttribute("com_name", "naver");
request.getSession().setAttribute("com_dept_name", "인사팀");
request.getSession().setAttribute("com_pos_name", "사원");
response.sendRedirect("login/LoginMainFrame.do");
%>

</body>
</html>