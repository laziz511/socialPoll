package com.dev.socialPoll.dao;

import com.dev.socialPoll.dao.connection.ConnectionPool;
import com.dev.socialPoll.dao.connection.ProxyConnection;
import com.dev.socialPoll.dao.mapper.RowMapper;
import com.dev.socialPoll.entity.Identifiable;
import com.dev.socialPoll.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AbstractQueryExecutor<T extends Identifiable> {
    private static final Logger logger = LogManager.getLogger();

    private final RowMapper<T> rowMapper;

    public AbstractQueryExecutor(RowMapper<T> rowMapper) {
        this.rowMapper = rowMapper;
    }

    protected List<T> executeQuery(String query, Object... params) throws DaoException {
        List<T> entities;
        try (PreparedStatement statement = createStatement(query, params);
             ResultSet resultSet = statement.executeQuery()) {
            entities = createEntitiesList(resultSet);
        } catch (SQLException e) {
            logger.error("Unable to execute query", e);
            throw new DaoException(e.getMessage(), e);
        }
        return entities;
    }

    protected Optional<T> executeQueryForSingleResult(String query, Object... params) throws DaoException {
        List<T> items = executeQuery(query, params);
        if (items.isEmpty()) {
            return Optional.empty();
        }

        if (items.size() != 1) {
            return Optional.empty();
        }

        return Optional.of(items.get(0));
    }

    protected long executeInsertQuery(String query, Object... params) throws DaoException {
        long result = 0;
        try (PreparedStatement statement = createStatement(query, params)) {
            statement.executeUpdate();
            ResultSet generatedKey = statement.getGeneratedKeys();
            if (generatedKey.next()) {
                result = generatedKey.getLong(1);
            }
        } catch (SQLException e) {
            logger.error("Unable to execute insert query", e);
            throw new DaoException(e.getMessage(), e);
        }
        return result;
    }

    protected int executeCountQuery(String query, Object... params) throws DaoException {
        int count = 0;
        try (PreparedStatement statement = createStatement(query, params);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            logger.error("Unable to execute count query", e);
            throw new DaoException(e.getMessage(), e);
        }
        return count;
    }

    protected int executeUpdateQuery(String query, Object... params) throws DaoException {
        int rowsAffected;
        try (PreparedStatement statement = createStatement(query, params)) {
            rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Unable to execute update query", e);
            throw new DaoException(e.getMessage(), e);
        }
        return rowsAffected;
    }


    private PreparedStatement createStatement(String query, Object... params) throws DaoException {
        try {
            ProxyConnection proxyConnection = ConnectionPool.getInstance().getConnection();
            PreparedStatement preparedStatement = proxyConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            ConnectionPool.getInstance().releaseConnection(proxyConnection);
            return preparedStatement;
        } catch (SQLException e) {
            logger.error("Unable to create statement!", e);
            throw new DaoException(e.getMessage(), e);
        }
    }

    protected List<Long> executeQueryForList(String query, Object... params) throws DaoException {
        List<Long> ids = new ArrayList<>();
        try (PreparedStatement statement = createStatement(query, params);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                ids.add(id);
            }
        } catch (SQLException e) {
            logger.error("Unable to execute query", e);
            throw new DaoException(e.getMessage(), e);
        }
        return ids;
    }


    private List<T> createEntitiesList(ResultSet resultSet) throws DaoException {
        List<T> entities = new ArrayList<>();
        try {
            while (resultSet.next()) {
                T entity = rowMapper.map(resultSet);
                entities.add(entity);
            }
        } catch (SQLException e) {
            logger.error("Unable to create entity list!", e);
            throw new DaoException(e.getMessage(), e);
        }
        return entities;
    }
}
