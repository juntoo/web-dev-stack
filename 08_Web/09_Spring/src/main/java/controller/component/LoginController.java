package controller.component;

import java.sql.SQLException;

import controller.Controller;
import controller.ModelAndView;
import dao.MemberDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vo.Member;

public class LoginController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		MemberDAO dao = MemberDAO.getInstance();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		HttpSession session = request.getSession();
		
		Member member = dao.login(id, pwd);
		session.setAttribute("member", member);
		
		return new ModelAndView("index.jsp", true);
	}

}
