<%@page import="com.kh.vo.Member"%>
<%@page import="java.util.ArrayList"%>
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
	<h2>전체 회원 보기</h2>
	<table border="1" style="text-align: center;">
		<tr>
			<th>인덱스</th>
			<th>번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<c:forEach items="${list}" var="member" varStatus="status">
		<tr>
			<%-- index : 0부터, count : 1부터 --%>
			<td>${status.index}</td>
			<td>${status.count}</td>
			<td>${member.getId()}</td>
			<td>${member.getPwd()}</td>
			<td>${member.getName()}</td>
			<td>${member.getAge()}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>