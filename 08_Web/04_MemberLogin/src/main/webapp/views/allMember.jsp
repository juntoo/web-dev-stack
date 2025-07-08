<%@page import="vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>전체 회원 보기</h2>
	<% ArrayList<Member> allList = (ArrayList<Member>)request.getAttribute("list"); %>
	<table border="1" style="text-align: center;">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<% for(Member m : allList) { %>
		<tr>
			<td><%=m.getId() %></td>
			<td><%=m.getPwd() %></td>
			<td><%=m.getName() %></td>
			<td><%=m.getAge() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>