package com.revature.reimbursementapi.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.reimbursementapi.servlets.TestServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//So the contextloadlistener takes over the request routing from the web.xml?

public class ContextLoadListener implements ServletContextListener {
    @Override   //This creates the program on every startup?
    public void contextInitialized(ServletContextEvent sce) {
        //This is where all the servlets will be initialized.

        //First the ObjectMapper (Brought to you by Jackson databind)
        ObjectMapper mapper = new ObjectMapper();

        //Second is initializing any and all servlets.
        TestServlet testServlet = new TestServlet();

        //Third is initializing a ServletContext object. NOTE: to lookup.
        ServletContext context = sce.getServletContext();

        //Fourth is mapping the servlets?
        context.addServlet("TestServlet", testServlet).addMapping("/test");


        //Leaving this to see what it does.
        ServletContextListener.super.contextInitialized(sce);
    }

    @Override   //This destroys the program on every exit?
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("Shutingdown the application... Thank you for using Reimbursement Api.");

        //Leaving this to see what it does.
        ServletContextListener.super.contextDestroyed(sce);
    }
}
