package com.NeonF1.infrastructure.persistence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DataConnection {
    private static final String KEY = "QUEMIRASSAPO";
    private static final String USER = "neondb_owner";
    private static final String URL = "jdbc:postgresql://ep-plain-leaf-apzhfpja-pooler.c-7.us-east-1.aws.neon.tech/neondb?sslmode=require&channelBinding=require";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, KEY);
    }
}
