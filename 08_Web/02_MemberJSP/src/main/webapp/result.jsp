<!-- HTML 주석 : 소스 코드에 보여짐 -->
<%--JSP 주석 : 소스코드에 보여짐

JSP Element
1. 지시어 %@ % : 컨테이너에게 알려줄 내용 지정
2. 스플릿틀릿 % % : 자바코드는 이 안에 지정
3. 출력문 %= % : 출력하는 내용 지정
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- check 값도 바인딩 해서 여기서 조건을 걸 수 있음 --%>
	<% 
		String name = request.getParameter("name");
		boolean check = (boolean)request.getAttribute("check");
	%>
	<%-- String name = (String)request.getAttribute("name"); --%>
	<% if(check){ %>
		<h1><%=name %>님, 회원가입 완료!</h1>	
	<% } else { %>
		<h1>회원가입 실패</h1>
	<% } %>	

</body>
</html>