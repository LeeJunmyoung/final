<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>write check</title>
</head>
<body>

	<c:if test="${salary_insert_count > 0}">
		<script>
			window.opener.top.location.reload(true);
			window.close();
		</script>

	</c:if>

	<c:if test="${salary_update_count > 0}">
		<script>
			window.opener.top.location.reload(true);
			window.close();
		</script>

	</c:if>

</body>
</html>