package edu.ycp.cs320.jhofmann1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.jhofmann1.controller.NumbersController;
import edu.ycp.cs320.jhofmann1.model.Numbers;

public class AddNumbersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/addNumbers.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Decode form parameters and dispatch to controller
		String errorMessage = null;
		Double result = null;
		Numbers model = new Numbers();
		try {
			Double first = getDoubleFromParameter(req.getParameter("first"));
			Double second = getDoubleFromParameter(req.getParameter("second"));
			Double third = getDoubleFromParameter(req.getParameter("third"));

			if (first == null || second == null || third == null) {
				errorMessage = "Please specify three numbers";
			} else {
				NumbersController controller = new NumbersController();
				model.setFirst(first);
				model.setSecond(second);
				model.setThird(third);
				result = controller.add(first, second, third);
				model.setResult(result);
			}
		} catch (NumberFormatException e) {
			errorMessage = "Invalid double";
		}
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("model", model);
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/addNumbers.jsp").forward(req, resp);
	}

	private Double getDoubleFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return Double.parseDouble(s);
		}
	}
}
