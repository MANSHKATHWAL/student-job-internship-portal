
package com.aip.portal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static final String URL =
        "jdbc:mysql://localhost:3306/student_portal";

    private static final String USER = "root";

    private static final String PASSWORD = "mansh@146";

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL Driver not found", e);
        }

        return DriverManager.getConnection(
            URL,
            USER,
            PASSWORD
        );
    }
}
