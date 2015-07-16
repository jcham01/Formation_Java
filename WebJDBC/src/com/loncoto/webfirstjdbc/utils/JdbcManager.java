package com.loncoto.webfirstjdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class JdbcManager
 *
 */
public class JdbcManager implements ServletContextListener {
	
	private Connection base;
	
    /**
     * Default constructor. 
     */
    public JdbcManager() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	
    	System.out.println("Demarrage de JdbcManager");    	
    	String driverclass = arg0.getServletContext().getInitParameter("driverclass");
    	String databaseurl = arg0.getServletContext().getInitParameter("databaseurl");
    	String login = arg0.getServletContext().getInitParameter("login");
    	String mdp = arg0.getServletContext().getInitParameter("mdp");
    	
    	try {
			Class.forName(driverclass);
			base = DriverManager.getConnection(databaseurl, login, mdp);
			System.out.println("connecte a la base");
			ClientDao clientDao = new ClientDao(base);
			arg0.getServletContext().setAttribute("clientDao", clientDao);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
}
