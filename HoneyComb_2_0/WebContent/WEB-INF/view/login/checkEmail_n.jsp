<!-- //이메일이 중복일때  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>회원가입</title>
<script language="javascript" src="/HoneyComb/view/script.js"></script>
<style type="text/css">
body{
text-align:  center;
background-color: #E9EBEE;
}
.indexbutton{
position:static;
color:black;
width:70px;
height: 25px;
background-color: #F8F8F8 ;	
border: 1px solid silver;
margin: 5px 0px;
text-align: center;
cursor: pointer;
}
</style>
<body>
	<p>
		입력하신 ${param.email}은 사용중인 이메일 입니다.<Br> 다른 이메일을 입력해주세요
	</p>
		<div id="clicktext"><input type="button" onclick="window.close()" value="닫기" class="indexbutton"></div>



</body>
</html>