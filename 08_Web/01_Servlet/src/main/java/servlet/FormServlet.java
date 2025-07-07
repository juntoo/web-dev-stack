package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		String gender = request.getParameter("gender");
		String[] menus = request.getParameterValues("menu");
		
		gender = gender.equals("M") ? "남자" : "여자";
		
		out.print("<html><body>");
		out.print("<h2>아이디 : "+ id +"</h2>");
		out.print("<h2>비밀번호 : "+ pwd +"</h2>");
		out.print("<h2>성별 : "+ gender +"</h2>");
//		out.print("<h2>좋아하는 메뉴 : " + String.join(", ", menus) + "</h2>");
		if(menus!=null) {
			out.print("<h2>좋아하는 메뉴</h2>");
			out.print("<ul>");
			for(String m : menus) {
				out.print("<li>"+m+"</li>");
			}
			out.print("</ul>");
		}
		out.print("</body></html>");
		
		out.close();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
