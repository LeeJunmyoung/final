<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

	<%
		session.invalidate();
		response.sendRedirect("login/LoginMainFrame.do");
	%>

</body>

</html>
