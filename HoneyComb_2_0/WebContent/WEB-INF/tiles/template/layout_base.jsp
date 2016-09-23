<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
<title><tiles:getAsString name="title" /></title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<tiles:insertAttribute name="header" />
			</div>
		</div>

		<div class="row">

			<div class="col-md-4">
				<tiles:insertAttribute name="header" />
			</div>

			<div class="col-md-8">
				<tiles:insertAttribute name="body" />
			</div>

		</div>

		<div class="row">
			<div class="col-md-12">
				<tiles:insertAttribute name="footer" />
			</div>
		</div>

	</div>

</body>
</html>