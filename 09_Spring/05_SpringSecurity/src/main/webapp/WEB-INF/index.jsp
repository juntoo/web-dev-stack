<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>시큐리티</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  </head>
  <body>
  	<c:if test="${not empty user}">
  		<div>어서오세요 ${user.name}님</div>
  	</c:if>
    <a href="/register">회원가입</a><br>
    <a href="/login">로그인</a>
  </body>
</html>
