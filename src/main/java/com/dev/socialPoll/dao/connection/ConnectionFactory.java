package com.dev.socialPoll.dao.connection;

import com.dev.socialPoll.exception.ConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final Logger logger = LogManager.getLogger();
    private static final String DB_URL = "url";
    private static final String DB_USER = "user";
    private static final String DB_PASSWORD = "password";
    private static final String DB_DRIVER = "driver";

    static ProxyConnection createConnection(Properties dbProperties) throws ConnectionException {
        ProxyConnection proxyConnection = null;
        try {
            String dbUrl = dbProperties.getProperty(DB_URL);
            String dbUser = dbProperties.getProperty(DB_USER);
            String dbPassword = dbProperties.getProperty(DB_PASSWORD);
            Class.forName(dbProperties.getProperty(DB_DRIVER));
            proxyConnection = new ProxyConnection(DriverManager.getConnection(dbUrl, dbUser, dbPassword));
        } catch (ClassNotFoundException e) {
            logger.error("PostgreSQL JDBC driver not found!", e);
            throw new ConnectionException(e.getMessage(), e);
        } catch (SQLException e) {
            logger.error("Unable to connect to DB!", e);
            throw new ConnectionException(e.getMessage(), e);
        }
        return proxyConnection;
    }

}
