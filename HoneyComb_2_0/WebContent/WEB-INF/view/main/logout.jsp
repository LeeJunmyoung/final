<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html>
<head>
<title>LogOut</title>
</head>
<%
	session.invalidate();
%>

<script>
	var Backlen = history.length;
	history.go(-Backlen);
	window.location.href = '/HoneyComb_2_0/index.jsp';
</script>


<body>

</body>
</html>
