<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>ajax</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  </head>
  <body>
  	<h1>회원가입</h1>
  	<form id="frm" action="">
  		아이디 : <input type="text" name="id" id="id"><br>
  		비밀번호 : <input type="password" name="pwd" id="pwd"><br>
  		나이 : <input type="text" name="age" id="age"><br>
  		이름 : <input type="text" name="name" id="name"><br>
  		<input type="button" value="회원가입" id="btn">
  	</form>
  	<div id="result"></div>
    <script>
		$("#btn").click(() => {
			$.ajax({
				type: "post",
				url: "/signup",
				data: $("#frm").serialize(),
				success: function (result) {
					console.log(result.name);
					$("#result").text(result.name + "님이 회원가입 하셨습니다.")
				}
			});
		});
	</script>
  </body>
</html>
