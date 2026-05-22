package com.NeonF1.infrastructure.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DataConnection {
    //Credenciales para la conexion con la base de datos (guardadas en el .env)
    private static final String KEY = System.getenv("DB_PASSWORD");
    private static final String USER = System.getenv("DB_USER");
    private static final String URL = System.getenv("DB_URL");


    //Metodo para realizar la conexion a la base de datos
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, KEY);
    }
}
