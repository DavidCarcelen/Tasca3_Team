package Connections;

import java.sql.*;

public class FlowerShopDDBB {
    private static FlowerShopDDBB instance;
    private static final String URL = "jdbc:mysql://localhost/flowershop";
    private static final String USER = "root";
    private static final String PASSWORD = "";

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
                System.err.println(e.getMessage());
            }
        }
    }

    public static void showStock(){
        try (Connection con = FlowerShopDDBB.getConnection()){
            // Crear una declaración y ejecutar una consulta
            Statement statement = null;
            ResultSet resultSet = null;
            ResultSet resultSet1 = null;
            ResultSet resultSet2 = null;

            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tree");
            resultSet1 = statement.executeQuery("SELECT * FROM flower");
            resultSet2 = statement.executeQuery("SELECT * FROM product");

            // Procesar los resultados
            while (resultSet.next()) {
                int id = resultSet.getInt("idProduct"); // Nombre de columna en la tabla
                int categoriaId = resultSet.getInt("idCategoryProduct"); // Nombre de columna en la tabla

                System.out.println("ID: " + id + ", Categoria ID: " + categoriaId);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
