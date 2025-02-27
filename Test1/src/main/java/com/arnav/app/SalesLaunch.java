package com.arnav.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.vedant.model.SalesModel;


/**
 * Servlet implementation class AffiliateLaunch
 */
@WebServlet("/SalesLaunch")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024,  // 1MB before saving to disk
	    maxFileSize = 1024 * 1024 * 10,   // 10MB max per file
	    maxRequestSize = 1024 * 1024 * 20 // 20MB max for the whole request
	)
public class SalesLaunch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalesLaunch() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String profile = request.getParameter("profile");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String linkedin = request.getParameter("linkedin");
		String project_type = request.getParameter("project_type");
		String technologies = request.getParameter("technologies");
		Part filePart = request.getPart("textfile");
		String filename = filePart.getSubmittedFileName();
		
		@SuppressWarnings("resource")
		String filecontent = new BufferedReader(new InputStreamReader(filePart.getInputStream())).lines().collect(Collectors.joining("\n"));
		
		Configuration config = new Configuration();
		
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(SalesModel.class);
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = null;
		
		Transaction transaction = null;
		
		boolean flag = false;
		
		SalesModel sm = new SalesModel();
		sm.setName(name);
		sm.setPhone(phone);
		sm.setEmail(email);
		sm.setProfile(profile);
		sm.setLinkedin(linkedin);
		sm.setProject_type(project_type);
		sm.setTechnologies(technologies);
		sm.setContent(filecontent);
		sm.setFilename(filename);
		
		
		try {
			
			session = factory.openSession();
			
			transaction = session.beginTransaction();
			
			session.persist(sm);
			
			response.sendRedirect("index.html");
			
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
