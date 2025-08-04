<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="sec"
uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>시큐리티</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  </head>
  <body>
    <div id="anonymous" style="display: none">
      <a href="/register">회원가입</a><br />
      <a href="/login">로그인</a><br />
    </div>

    <div id="authenticated" style="display: none">
      <a href="/logout">로그아웃</a><br />
      <a href="/mypage">마이 페이지</a><br />
    </div>

    <div id="admin" style="display: none">
      <a href="/admin">관리자 페이지</a><br />
    </div>

    <script>
      const token = localStorage.getItem("token");
      if (token != null) {
        $("#authenticated").show();
      } else {
        $("#anonymous").show();
      }
    </script>
  </body>
</html>
