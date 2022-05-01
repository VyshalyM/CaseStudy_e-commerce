package lk.ac.pdn.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private Map<String, String> errors = new HashMap<String, String>();
	
    public RegistrationServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String surname = request.getParameter("surname");
		String initials = request.getParameter("initials");
		String gender = request.getParameter("gender");
		
		errors = new HashMap<String, String>();  //avoid caching at the server
		String[] hobbies = request.getParameterValues("hobbies");
		
		validation(surname, initials, gender);
		
		
		if(errors.size() > 0) {
			request.setAttribute("errorMsg", errors);
			RequestDispatcher rd = request.getRequestDispatcher("registration-form.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("regisration-success.jsp");
		}
		
		
	}

	private void validation(String surname, String initials, String gender) {
		if(surname.isEmpty()) {
			errors.put("surname", "cannot be empty");
		} else if(surname.indexOf(" ") > 0){
			errors.put("surname", "cannot have spaces");
		}
		
		if(initials.isEmpty()) {
			errors.put("initials", "cannot be empty");
		} 
		
		if(gender == null || gender.isEmpty()) {
			errors.put("gender", "cannot be empty");
		} 
	}
}









