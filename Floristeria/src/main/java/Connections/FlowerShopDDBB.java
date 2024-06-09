package Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FlowerShopDDBB { //hacer singleton
    private static FlowerShopDDBB instance;
    private static final String URL = "jdbc:mysql://localhost:3306/flowershop";
    private static final String USER = "root";
    private static final String PASSWORD = "XarawtID";

    // Método para obtener una conexión a la base de datos
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para cerrar una conexión a la base de datos
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}