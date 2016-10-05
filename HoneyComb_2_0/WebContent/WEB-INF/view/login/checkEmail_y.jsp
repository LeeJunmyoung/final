<!-- //이메일이 중복이지 않을 때 -->
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
width:150px;
height: 30px;
background-color: #F8F8F8 ;	
border: 1px solid silver;
margin: 5px 0px;
text-align: center;
cursor: pointer;
}
</style>
<body>
	<form action="checkEmailPro.do">
		<p>
			     사용 가능한 이메일 입니다.<br> 이메일 인증 후 회원가입을 진행 합니다
		</p>
		<input type="text" value="${param.email}" name="email">
		<input type="submit" value="인증번호 전송" class="indexbutton">
	</form>

</body>
</html>