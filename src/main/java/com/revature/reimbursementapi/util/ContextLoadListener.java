package com.revature.reimbursementapi.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//So the contextloadlistener takes over the request routing from the web.xml?

public class ContextLoadListener implements ServletContextListener {
    @Override   //This creates the program on every startup?
    public void contextInitialized(ServletContextEvent sce) {
        //This is where all the servlets will be initialized.

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
