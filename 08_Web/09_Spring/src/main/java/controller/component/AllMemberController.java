package controller.component;

import java.sql.SQLException;
import java.util.ArrayList;

import controller.Controller;
import controller.ModelAndView;
import dao.MemberDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

public class AllMemberController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		MemberDAO dao = MemberDAO.getInstance();
		ArrayList<Member> list = dao.viewAll();
		request.setAttribute("list", list);
		
		return new ModelAndView("/views/allMember.jsp");
	}

}
