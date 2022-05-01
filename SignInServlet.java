package lk.ac.pdn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignIn")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignInServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		validate(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		validate(request, response);
	}

	private void validate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");

		String userName = request.getParameter("userName");
		String password = request.getParameter("userPassword");

		if (userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			response.getWriter().append("Authentication Success");
		} else {
			response.getWriter().append("Invalid authentication");
		}
	}

}
