<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>erp-project</title>
  </head>
  <body>
    <form action="/insert" method="post">
		<p>아이디 : <input type="text" name="id"></p>
		<p>비밀번호 : <input type="password" name="password"></p>
		<p>이름 : <input type="text" name="name"></p>
		<p>전화번호 : <input type="text" name="phone"></p>
		<p>이메일 : <input type="text" name="email"></p>
		<p>부서명 : <input type="text" name="deptName"></p>
		<p>직책 : <input type="text" name="position"></p>
		<input type="submit" value="등록">
	</form>
  </body>
</html>