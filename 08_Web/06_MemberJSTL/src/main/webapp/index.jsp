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
	<h1>회원 관리</h1>
	<c:if test="${empty member}">
		<li><a href="/views/register.jsp">회원가입</a></li>
		<li><a href="/views/login.jsp">로그인</a></li>
	</c:if>
		
	<c:if test="${not empty member}">
		<li><a href="/views/search.jsp">회원검색</a></li>
		<li><a href="/allMember">전체 회원 보기</a></li>
		<li><a href="/logout">로그아웃</a></li>
	</c:if>
</body>
</html>