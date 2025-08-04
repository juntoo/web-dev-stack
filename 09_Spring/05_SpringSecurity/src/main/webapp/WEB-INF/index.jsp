<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>시큐리티</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  </head>
  <body>
  	<sec:authorize access="isAnonymous()">
	    <a href="/register">회원가입</a><br>
	    <a href="/login">로그인</a><br>
    </sec:authorize>
    
    <sec:authorize access="isAuthenticated()">
    	<a href="/logout">로그아웃</a><br>
    	<a href="/mypage">마이 페이지</a><br>
    </sec:authorize>
    
    <sec:authorize access="hasRole('ADMIN')">
    	<a href="/admin">관리자 페이지</a><br>
    </sec:authorize>
  </body>
</html>
