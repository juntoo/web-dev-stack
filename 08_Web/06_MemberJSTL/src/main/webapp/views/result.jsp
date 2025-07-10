<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 정보</h2>
	<c:if test="${not empty requestScope.member}">
	<ul>
		<li>아이디 : ${requestScope.member.getId()}</li>
		<li>이름 : ${requestScope.member.getName()}</li>
		<li>나이 : ${requestScope.member.getAge()}</li>
	</ul>
	</c:if>
	<c:if test="${empty requestScope.member}">
	<h1>검색에 실패했습니다</h1>
	</c:if>
</body>
</html>