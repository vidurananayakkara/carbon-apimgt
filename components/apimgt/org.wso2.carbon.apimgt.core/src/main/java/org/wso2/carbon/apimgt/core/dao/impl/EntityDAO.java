package org.wso2.carbon.apimgt.core.dao.impl;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.wso2.carbon.apimgt.core.exception.APIMgtDAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Queries that accessing columns that are common to all entity tables goes into this class
 */
class EntityDAO {

    /**
     * Returns the last access time of the given entity identified by the UUID.
     * 
     * @param resourceTableName Table name of the entity
     * @param uuid UUID of the entity
     * @return Last access time of the requested resource
     * @throws APIMgtDAOException
     */
    @SuppressFBWarnings("SQL_PREPARED_STATEMENT_GENERATED_FROM_NONCONSTANT_STRING")
    static String getLastUpdatedTimeOfResource(String resourceTableName, String uuid)
            throws APIMgtDAOException {
        final String query = "SELECT LAST_UPDATED_TIME FROM " + resourceTableName + " WHERE UUID = ?";
        String lastUpdatedTime = null;
        try (Connection connection = DAOUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, uuid);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    lastUpdatedTime = rs.getString("LAST_UPDATED_TIME");
                }
            }
            return lastUpdatedTime;
        } catch (SQLException e) {
            throw new APIMgtDAOException(
                    "Error while retrieving last access time from table : " + resourceTableName + " and entity " + uuid,
                    e);
        }
    }
}
