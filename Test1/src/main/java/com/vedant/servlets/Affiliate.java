package com.vedant.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Affiliate
 */
@WebServlet("/affiliate")
public class Affiliate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Affiliate() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String age = request.getParameter("age");
		String profile = request.getParameter("profile");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String nationality = request.getParameter("nationality");
		
	RequestDispatcher rd = request.getRequestDispatcher("AffiliateLaunch");
		request.setAttribute("firstname", firstname);
		request.setAttribute("lastname", lastname);
		request.setAttribute("age", age);
		request.setAttribute("profile", profile);
		request.setAttribute("phone", phone);
		request.setAttribute("email", email);
		request.setAttribute("nationality", nationality);
		
		rd.forward(request, response);
	}

}
