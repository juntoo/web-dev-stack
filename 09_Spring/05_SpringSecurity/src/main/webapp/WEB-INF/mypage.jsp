<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>로그인</title>
  </head>
  <body>
  	<!-- get, /mypage : 인증된 사람만. 즉, 로그인된 사람만 -->
    <h1>마이페이지</h1>
    <sec:authentication property="name"/>님의 페이지입니다.
  </body>
</html>
