package edu.ucr.rp.db.util;

import java.sql.*;

public class ConnectionDB {

    private static final String URL =  "jdbc:sqlserver://163.178.107.10:1433;databaseName=Quideros;";
    private static final String USER = "laboratorios";
    private static final String PASSWORD = "KmZpo.2796";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
