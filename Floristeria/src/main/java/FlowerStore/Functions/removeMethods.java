package FlowerStore.Functions;

import Connections.FlowerShopDDBB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static Menu.Menu.numCheck;

public class removeMethods {
    //escoger que tipo de producto vamos a eliminar
    //imprimir todos los productos de ese tipo
    //eliminar el producto con un int de id

    static Scanner sc = new Scanner(System.in);
    //me ha obligado a lanzar las excepciones porke?
    public static void removeFlower() throws SQLException {
        int idFlor = 0;
        System.out.println("------------------LISTA DE FLORES-----------------");
        try(Connection connection = FlowerShopDDBB.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM flower;");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("flowerName") + " " + resultSet.getInt("idProductFlower"));
            }
            System.out.println("Introduce el id de la flor que quieres eliminar:");
            int num = numCheck();
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM flower WHERE idProductFlower = '" + num+"'");
                if (resultSet1.next()) {
                    //problemas para eliminar la calse producto
                    //statement.executeUpdate("DELETE FROM product WHERE idProduct = 5");
                    statement.executeUpdate("DELETE FROM flower WHERE idProductFlower ='"+num+"'");

                }
            else{
            System.out.println("NO EXISTE ESTE ID");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public static void removeTree() throws SQLException {
        int idFlor = 0;
        System.out.println("------------------LISTA DE ARBOLES-----------------");
        try(Connection connection = FlowerShopDDBB.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tree;");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("treeName") + " " + resultSet.getInt("idProductTree"));
            }
            System.out.println("Introduce el id del arbol que quieres eliminar:");
            int num = numCheck();
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM tree WHERE idProductTree = '" + num+"'");
            if (resultSet1.next()) {
                //problemas para eliminar la calse producto
                //statement.executeUpdate("DELETE FROM product WHERE idProduct = 5");
                statement.executeUpdate("DELETE FROM tree WHERE idProductTree ='"+num+"'");

            }
            else{
                System.out.println("NO EXISTE ESTE ID");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public static void removeDecoration() throws SQLException {
        int idFlor = 0;
        System.out.println("------------------LISTA DE DECORACIONES-----------------");
        try(Connection connection = FlowerShopDDBB.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM decoration;");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("decorationName") + " " + resultSet.getInt("idProductDecoration"));
            }
            System.out.println("Introduce el id de la decoracion que quieres eliminar:");
            int num = numCheck();
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM decoration WHERE idProductDecoration = '" + num+"'");
            if (resultSet1.next()) {
                //problemas para eliminar la calse producto
                //statement.executeUpdate("DELETE FROM product WHERE idProduct = 5");
                statement.executeUpdate("DELETE FROM decoration WHERE idProductDecoration  ='"+num+"'");

            }
            else{
                System.out.println("NO EXISTE ESTE ID");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
