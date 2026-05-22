package com.NeonF1.infrastructure.persistence;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DataConnection {
    private static final String KEY = System.getenv("DB_PASSWORD");
    private static final String USER = System.getenv("DB_USER");
    private static final String URL = System.getenv("DB_URL");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, KEY);
    }
}
