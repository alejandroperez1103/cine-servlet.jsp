package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Datos de conexión a tu base de datos MariaDB
    private static final String URL = "jdbc:mariadb://localhost:3306/cine";
    private static final String USUARIO = "root";
    private static final String CLAVE = "";

    public static Connection conectar() throws SQLException {
        try {
            // Cargar el driver de MariaDB que pusimos en el pom.xml
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error al cargar el driver JDBC.");
        }
        // Retornar la conexión establecida
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}