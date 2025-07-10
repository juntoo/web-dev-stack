package controller.component;

import java.sql.SQLException;

import controller.Controller;
import controller.ModelAndView;
import dao.MemberDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

public class SearchController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		MemberDAO dao = MemberDAO.getInstance();
		Member member = dao.search(request.getParameter("id"));
		request.setAttribute("member", member);
		
		return new ModelAndView("/views/result.jsp");
	}
	
}
