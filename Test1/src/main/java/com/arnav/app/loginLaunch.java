package com.arnav.app;

import jakarta.servlet.RequestDispatcher;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;

import com.vedant.model.Signup_individualmodel;
import com.vedant.model.signup_organizationmodel;


@WebServlet("/loginLaunch")
public class loginLaunch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginLaunch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String)request.getAttribute("email");
		String password = (String)request.getAttribute("pass");
		String usertype = (String)request.getAttribute("usertype");
		
		Configuration config = new Configuration();
		
		config.configure("hibernate.cfg.xml");
		
		config.addAnnotatedClass(Signup_individualmodel.class);
		
		config.addAnnotatedClass(signup_organizationmodel.class);
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = null;
		
		session = factory.openSession();
	
		try {
			
			if ("individual".equals(usertype)) {
                Query<Signup_individualmodel> query = session.createQuery(
                        "FROM Signup_individualmodel WHERE email = :email", Signup_individualmodel.class);
                query.setParameter("email", email);
                Signup_individualmodel user = query.uniqueResult();
                System.out.println("Checking user");
                System.out.println(user);
                if (user != null && BCrypt.checkpw(password, user.getPassword())) {
                	System.out.println("User authenticated successfully. Redirecting...");
                	response.sendRedirect("index.html");
                
                } else {
                	System.out.println("in else block");
                    response.sendRedirect("login.jsp");
                }

            } else if ("organization".equals(usertype)) {
                Query<signup_organizationmodel> query = session.createQuery(
                        "FROM signup_organizationmodel WHERE companyemail = :email", signup_organizationmodel.class);
                query.setParameter("email", email);
                signup_organizationmodel org = query.uniqueResult();

                if (org != null && BCrypt.checkpw(password, org.getPassword())) {
                	RequestDispatcher rd = request.getRequestDispatcher("index.html");
                	rd.forward(request, response);
                } else {
                    RequestDispatcher rd =  request.getRequestDispatcher("login.jsp");
                    rd.forward(request, response);
                }
            } else {
                response.getWriter().println("Invalid user type.");
}
			
			}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			
			session.close();
			factory.close();
			
		}
	}

}
