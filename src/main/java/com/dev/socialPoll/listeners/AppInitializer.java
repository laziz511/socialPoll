package com.dev.socialPoll.listeners;

import com.dev.socialPoll.dao.connection.ConnectionPool;
import com.dev.socialPoll.exception.ConnectionException;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ConnectionPool.getInstance().initialize();
        } catch (ConnectionException e) {
            // Handle the exception or log an error
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Clean up resources, if needed
        try {
            ConnectionPool.getInstance().destroy();
        } catch (ConnectionException e) {
            throw new RuntimeException(e);
        }
    }
}
