package com.vedant.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class signup_organization
 */
@WebServlet("/signup_organization")
public class signup_organization extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup_organization() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String companyname = request.getParameter("companyName");
		
		String companyemail = request.getParameter("companyEmail");
		
		String industry = request.getParameter("industry");
		
		String password = request.getParameter("password");
		
		RequestDispatcher rd = request.getRequestDispatcher("signup_organizationLaunch");
		
		request.setAttribute("companyname", companyname);
		
		request.setAttribute("companyemail", companyemail);
		
		request.setAttribute("industry", industry);
		
		request.setAttribute("password", password);
		
		rd.forward(request, response);
		
	}

}
