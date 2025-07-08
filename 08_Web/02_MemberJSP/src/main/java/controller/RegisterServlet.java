package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

import java.io.IOException;
import java.sql.SQLException;

import dao.MemberDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private MemberDAO dao = new MemberDAO();
	
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. (있으면) 폼 값 받아온다.
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		boolean check = true;
		
		// 2. DAO 호출 - DB 접근 필요시
		try {
//			dao.register(id, name, pwd, age);
			dao.register(new Member(id, name, pwd, age));
			
		} catch (SQLException e) {
			check = false;
		}
		
		// 3. 바인딩 : 결과 페이지에 서버에서 받은 값 보내야 할 때
//		request.setAttribute("name", name);
		request.setAttribute("check", check);
		// 4. 네비게이션 : 결과 페이지 지정
		// 3. 결과 페이지 -> 회원가입 성공할 때와 실패할 때 페이지 구별
//		if(check) {
////			response.sendRedirect("result.jsp");
//			// 만약 결과 페이지로 서버에서 받은 값 보여주려면
//			// -> RequestDispatcher forward 방식으로 보내야 함
			request.getRequestDispatcher("result.jsp").forward(request, response);
//		}
//		else response.sendRedirect("fail.jsp");
		
	}

}
