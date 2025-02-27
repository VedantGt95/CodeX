package com.vedant.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class signupservlet
 */
@WebServlet("/signup_individual")
public class signup_individual extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup_individual() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstName");
		
		String lastname = request.getParameter("lastName");
		
		String email = request.getParameter("email");
		
		String password = request.getParameter("password");
		
		RequestDispatcher rd = request.getRequestDispatcher("signup_individualLaunch");
		
		request.setAttribute("firstname", firstname);
		
		request.setAttribute("lastname", lastname);
		
		request.setAttribute("email", email);
		
		request.setAttribute("password", password);
		
		rd.forward(request, response);
	}

}
