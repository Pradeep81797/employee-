package com.task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


/**
 * Servlet implementation class Logindb
 */
@WebServlet("/Logindb")
public class Logindb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logindb() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Perform a select query using HQL
            String hql = "FROM InserPojo WHERE email = :username AND password = :password";
            InserPojo user = (InserPojo) session.createQuery(hql)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .uniqueResult();

            if (user != null) {
                // Valid credentials, redirect to success page or perform further actions
            	
            	
            	request.setAttribute("user", user);
            	request.getRequestDispatcher("Loginsuccess.jsp").forward(request, response);
            	
               
            } else {
                // Invalid credentials, redirect back to login page with an error message
                response.sendRedirect("index.jsp?error=true");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            // Add error handling here, e.g., redirect to an error page
            response.sendRedirect("error.jsp");
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
		
	}


