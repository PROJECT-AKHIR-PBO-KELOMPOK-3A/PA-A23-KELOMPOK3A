/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author ideapadGAMING
 */
import java.sql.*;

public class DatabaseInterface {

    private Connection connection;

    public DatabaseInterface() throws SQLException {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public ResultSet executeSelectQuery(String query, Object... params) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(query);

        // Set parameter jika ada
        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }

        return stmt.executeQuery();
    }

    public int executeUpdateQuery(String query, Object... params) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(query);

        // Set parameter jika ada
        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }

        return stmt.executeUpdate();
    }

    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
