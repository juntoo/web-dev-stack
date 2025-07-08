package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vo.Member;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// DAO 생략 로그인 성공 가정
		
		Member member = new Member(id, pwd);
		request.setAttribute("member", member);
		
		// HttpSession
		// 1. 세션을 하나 받는다
		HttpSession session = request.getSession();
		
		// 2. 세션에 바인딩
		session.setAttribute("user", member);
		
		// ProductServlet으로 member 데이터를 가지고 가려고 할 경우
//		request.getRequestDispatcher("product").forward(request, response);
		response.sendRedirect("product");
	}

}
