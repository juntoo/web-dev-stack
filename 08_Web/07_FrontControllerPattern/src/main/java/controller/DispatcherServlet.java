package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vo.Member;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.MemberDAO;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/front")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/*
	 * Controller에서 Servlet을 하나로 만들자! Front Controller Pattern
	 * 
	 * 소프트웨어 디자인 패턴 중 하나로 웹 애플리케이션 등에서 사용되는 패턴 중 하나
	 * 애플리케이션의 진입점을 중앙집중화하여 요청을 처리하고, 전체적인 흐름을 제어하는 역할
	 * 
	 * - DipatcherServlet은 자바 기반의 웹 애플리케이션에서
	 * 	FrontControllerPattern을 구현하는데 사용되는 핵심 컴포넌트
	 * - SpringFramework와 관련된 개념으로 많이 사용되는데
	 * 	SpringMVC의 일부로 동작하여 웹 요청을 받아서 적절한 핸들러(컨트롤러)로 라우팅하고,
	 * 	해당 컨트롤러의 실행 및 응답 생성 등을 관리
	 * */
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청이 어디에서 들어온 요청인지 값을 하나 더 받음 - command
		String command = request.getParameter("command");
		String path = "/";
		try {
			if(command.equals("login")) {
				path = login(request, response);
			} else if(command.equals("register")) {
				path = register(request, response);
			} else if(command.equals("search")) {
				path = search(request, response);
			} else if(command.equals("allMember")) {
				path = allMember(request, response);
			} else if(command.equals("logout")) {
				path = logout(request, response);
			}
			request.getRequestDispatcher(path).forward(request, response);
		} catch (SQLException e) {
			
		}
	}
	
	protected String login(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		MemberDAO dao = MemberDAO.getInstance();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		HttpSession session = request.getSession();
		
		Member member = dao.login(id, pwd);
		session.setAttribute("member", member);
		
		return "/index.jsp";
	}
	
	public String register(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		MemberDAO dao = MemberDAO.getInstance();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Member member = new Member(id, name, pwd, age);
		dao.register(member);
		
		return "/index.jsp";
	}
	
	public String search(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		MemberDAO dao = MemberDAO.getInstance();
		
		Member member = dao.search(request.getParameter("id"));
		request.setAttribute("member", member);
		
		return "/views/result.jsp";
	}
	
	public String allMember(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		MemberDAO dao = MemberDAO.getInstance();
		ArrayList<Member> list = dao.viewAll();
		request.setAttribute("list", list);
		
		return "/views/allMember.jsp";
	}
	
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		
		if(member!=null) {
			session.invalidate();
		}
		
		return "/index.jsp";
	}
}
