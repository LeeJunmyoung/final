<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-1.7.1.js"></script>

<script type="text/javascript">
/* var chat_Num = '${chat_Num}';
var chat_mem_name = '${chat_mem_name}';
var chat_Member_Participation = '${chat_Member_Participation}';




opener.location.href='/HoneyComb/Chatting/Chat_Use_Form.jsp';



$(opener.document).find("#chchch").val("${chat_Num}"); //방식 3







window.close();  */
var chat_Num = '${chat_Num}';
$("#"+chat_Num, opener.document).css("color","red");

 window.close();  



</script>

<body>
chat_Num ::::: ${chat_Num}<br>

chat_mem_name ::::: ${chat_mem_name}<br>

chat_Member_Participation ::::: ${chat_Member_Participation}<br>
</body>
</html>