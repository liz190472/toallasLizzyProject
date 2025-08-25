package com.mycompany.toallaslizzyproject.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    private static final String URL  = "jdbc:mysql://localhost:3306/toallas_lizzy";
    private static final String USER = "root";
    private static final String PASS = "";
    public static Connection getConexion() throws SQLException {
        try {
            // Carga el driver JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se pudo encontrar el driver JDBC de MySQL.");
            e.printStackTrace();
            throw new SQLException("Error al cargar el driver", e);
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }
}