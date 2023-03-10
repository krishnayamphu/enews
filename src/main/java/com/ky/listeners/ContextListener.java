package com.ky.listeners;

import com.ky.database.Database;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Database.run();
        new ContextMediaListener(sce.getServletContext()).updateValue(null);
        new ContextPostListener(sce.getServletContext()).updateValue(null);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Database.remove();
    }
}
