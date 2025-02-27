package com.arnav.app;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.vedant.model.AffiliateModel;

/**
 * Servlet implementation class AffiliateLaunch
 */
@WebServlet("/AffiliateLaunch")
public class AffiliateLaunch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffiliateLaunch() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = (String)request.getAttribute("firstname");
		String lastname = (String)request.getAttribute("lastname");
		String Age = (String)request.getAttribute("age");
		String Profile = (String)request.getAttribute("profile");
		String Phone = (String)request.getAttribute("phone");
		String Email = (String)request.getAttribute("email");
		String Nationality = (String)request.getAttribute("nationality");
		
		
		Configuration config = new Configuration();
		
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(AffiliateModel.class);
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = null;
		
		Transaction transaction = null;
		
		boolean flag = false;
		
		Random rand = new Random();
		
		int random = 100 + rand.nextInt(900);
		
		StringBuffer buffer = new StringBuffer(firstname);
		
		String referralcode = buffer.append(random).toString();
		
		
		AffiliateModel am = new AffiliateModel();
		am.setFirstname(firstname);
		am.setLastname(lastname);
		am.setAge(Age);
		am.setEmail(Email);
		am.setPhone(Phone);
		am.setProfile(Profile);
		am.setNationality(Nationality);
		am.setReferralcode(referralcode);
		
		try {
			
			session = factory.openSession();
			
			transaction = session.beginTransaction();
			
			session.persist(am);
			
			RequestDispatcher rd = request.getRequestDispatcher("referral.jsp");
			request.setAttribute("referralcode", referralcode);
			rd.forward(request, response);
			
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
