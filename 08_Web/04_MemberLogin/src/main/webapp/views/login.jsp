<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 로그인 로직 : 아이디, 비밀번호 입력 받아서
						호출 : /login, 방식 : post'
						LoginServlet : 세션 데이터 바인딩
						index.jsp로 이동 
	--%>
	<form action="login" method="post">
		<div>
			<label for="id">ID : </label> 
			<input type="text" id="id" name="id" />
		</div>
		<div>
			<label for="pwd">PASSWORD : </label> 
			<input type="password" id="pwd" name="pwd" />
		</div>
		<input type="submit" value="로그인">
	</form>
</body>
</html>