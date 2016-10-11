<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title><tiles:getAsString name="title" /></title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link href="/HoneyComb_2_0/resources/css/home.css" rel="stylesheet"
	type="text/css" />
</head>

<script type="text/javascript">
	function pop_up() {
		var noticeCookie = getCookie("CookieName");
		if (noticeCookie != "no") {

			window.open("/HoneyComb_2_0/admin/admin_noticePopup", '', "toolbar=no,location=no,status=no,menubar=no scrollbars=no,resizable=no,left=400, top=100,width=400,height=350");
		}
	}

	function getCookie(name) {
		var Found = false
		var start, end
		var i = 0
		while (i <= document.cookie.length) {
			start = i
			end = start + name.length

			if (document.cookie.substring(start, end) == name) {
				Found = true
				break;
			}
			i++
		}

		if (Found == true) {
			start = end + 1
			end = document.cookie.indexOf(";", start)

			if (end < start)
				end = document.cookie.length

			return document.cookie.substring(start, end)
		}
		return ""
	}
</script>

<body onload="pop_up()">




	<div id="page_container">

		<div id="page_header">

			<tiles:insertAttribute name="header" />

		</div>

		<div id="page_center_contents">

			<div id="page_sidebar">

				<tiles:insertAttribute name="menu" />

			</div>

			<div id="page_content">

				<div id="main_notice">
					<tiles:insertAttribute name="notice" />
				</div>
				<div id="main_project_manage">
					<tiles:insertAttribute name="promgr" />
				</div>
				<div id="main_cal">
					<tiles:insertAttribute name="calenar" />
				</div>

			</div>
		</div>


		<div id="page_footer">

			<tiles:insertAttribute name="footer" />

		</div>

	</div>



</body>
</html>


