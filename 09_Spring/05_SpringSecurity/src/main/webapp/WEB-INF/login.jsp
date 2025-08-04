<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>로그인</title>
  </head>
  <body>
	<!-- 로그인에 성공하면 index.jsp에 ~~님 로그인 하셨습니다.
		기존 회원가입이랑 로그인 연결된 부분은 사라지고 -->
    <h1>로그인</h1>
    <form action="/login" method="post">
      아이디 : <input type="text" name="username" /><br />
      비밀번호 : <input type="password" name="password" /><br />
      <input type="submit" value="로그인" />
    </form>
  </body>
</html>
