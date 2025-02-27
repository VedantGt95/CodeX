package com.arnav.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.mindrot.jbcrypt.BCrypt;

import com.vedant.model.signup_organizationmodel;

/**
 * Servlet implementation class signup_organizationLaunch
 */
@WebServlet("/signup_organizationLaunch")
public class signup_organizationLaunch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup_organizationLaunch() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String companyname = (String)request.getAttribute("companyname");
		
		String companyemail = (String)request.getAttribute("companyemail");
		
		String industry = (String)request.getAttribute("industry");
		
		String password = (String)request.getAttribute("password");
		
		Configuration config = new Configuration();
		
		config.configure("hibernate.cfg.xml");
		
		config.addAnnotatedClass(signup_organizationmodel.class);
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = null;
		
		Transaction transaction = null;
		
		boolean flag = false;
		
		String hashedpassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
		
		
		signup_organizationmodel signup = new signup_organizationmodel();
		signup.setCompanyname(companyname);
		signup.setCompanyemail(companyemail);
		signup.setIndustry(industry);
		signup.setPassword(hashedpassword);
		
		try {
			
			session = factory.openSession();
			
			transaction = session.beginTransaction();
			
			session.persist(signup);
			
			flag = true;
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			if(flag == true) {
				transaction.commit();
				session.close();
				factory.close();
			}else {
				transaction.rollback();
				session.close();
				factory.close();
			}
			
		}
		
	}

}
