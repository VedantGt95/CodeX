package com.vedant.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Contact")
public class Contact extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phoneno = request.getParameter("phoneno");
        String message = request.getParameter("message");
        
        RequestDispatcher rd = request.getRequestDispatcher("ContactLaunch");
        
        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("phoneno", phoneno);
        request.setAttribute("message", message);
        
        rd.forward(request, response);
        
    }
}
