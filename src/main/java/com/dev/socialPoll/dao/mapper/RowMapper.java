package com.dev.socialPoll.dao.mapper;

import com.dev.socialPoll.entity.Identifiable;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T extends Identifiable> {

    /**
     * Method to create entity object from ResultSet
     *
     * @param resultSet {@link ResultSet} pointer that is set to row data to be mapped on the entity object
     * @return Entity object with fields set from row data
     * @throws SQLException if a database access error occurs or this method is called on a closed result set
     */
    T map(ResultSet resultSet) throws SQLException;
}