package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/Proshop";
    private static final String USER = "mi_usuario";
    private static final String PASSWORD = "mi_password";

    public static Connection conectar (){
        Connection conexion = null;
        try {
            conexion= DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Conexión a BBDD exitosa");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la BBDD");
            e.printStackTrace();
        }return conexion;
    }
}
