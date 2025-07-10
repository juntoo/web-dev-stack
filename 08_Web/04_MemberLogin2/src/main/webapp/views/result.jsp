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
	<% Member m = (Member)request.getAttribute("member"); %>
	<h2>회원 정보</h2>
	<%if(m!=null) {%>
	<ul>
		<li>아이디 : <%=m.getId() %></li>
		<li>이름 : <%=m.getName() %></li>
		<li>나이 : <%=m.getAge() %></li>
	</ul>
	<%} else { %>
	<h1>검색에 실패했습니다</h1>
	<%} %>
</body>
</html>