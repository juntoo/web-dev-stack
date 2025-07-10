package controller;

import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws SQLException;
}
