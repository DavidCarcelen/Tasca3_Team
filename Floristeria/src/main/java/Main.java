import Connections.FlowerShopDDBB;
import Menu.Menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Obtener una conexión a la base de datos
            connection = FlowerShopDDBB.getConnection();
            System.out.println("¡Conexión Realizada!");

            // Crear una declaración y ejecutar una consulta
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM product");

            // Procesar los resultados
            while (resultSet.next()) {
                int id = resultSet.getInt("idProduct"); // Nombre de columna en la tabla
                int categoriaId = resultSet.getInt("idCategoryProduct"); // Nombre de columna en la tabla

                System.out.println("ID: " + id + ", Categoria ID: " + categoriaId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el ResultSet
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // Cerrar el Statement
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // Cerrar la conexión a la base de datos
            FlowerShopDDBB.closeConnection(connection);
            System.out.println("¡Conexión Cerrada!");
        }
    }
}