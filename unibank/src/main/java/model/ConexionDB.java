package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    public static Connection getConnection() {
        Connection conexion = null;

        // Configura la información de la base de datos
        String url = "jdbc:mariadb://localhost:3306/mysql";
        String usuario = "root";
        String contraseña = "root";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el controlador JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de conexión a la base de datos: " + e.getMessage());
        }

        return conexion;
    }

    public static void closeConnection(Connection conexion) {
        try {
            if (conexion != null) {
                conexion.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
