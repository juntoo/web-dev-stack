<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 정보</h2>
	<% Member m = (Member)request.getAttribute("member"); %>
	<% String id = request.getParameter("id"); %>
	<%if(m!=null) {%>
	<table border="1" style="text-align: center;">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<tr>
			<td><%=m.getId() %></td>
			<td><%=m.getName() %></td>
			<td><%=m.getAge() %></td>
		</tr>
	</table>
	<a href="/view">뒤로</a>
	<%} else {%>
		<h1>아이디가 <%=id %>인 회원이 없습니다.</h1>
		<a href="/view">뒤로</a>
	<%} %>
</body>
</html>