package FlowerStore.Functions;

import Connections.FlowerShopDDBB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import static FlowerStore.Functions.AuxiliarMethods.*;

public class RemoveMethods {
    static Scanner sc = new Scanner(System.in);

    public static void removeFlower(){
        System.out.println("------------------LISTA DE FLORES-----------------");
        try(Connection connection = FlowerShopDDBB.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM flower ORDER BY idProductFlower ASC;");
            while (resultSet.next()) {
                System.out.println("- "+ resultSet.getInt("idProductFlower") + " " + resultSet.getString("flowerName"));
            }
            System.out.println("Introduce el id de la flor que quieres eliminar:");
            int num = numCheck();
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM flower WHERE idProductFlower = '" + num +"'");
                if (resultSet1.next()) {
                    statement.executeUpdate("DELETE FROM flower WHERE idProductFlower ='" + num + "'");
                    System.out.println("Producto eliminado");
                }
            else{
            System.err.println("NO EXISTE ESTE ID");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public static void removeTree(){
        System.out.println("------------------LISTA DE ARBOLES-----------------");
        try(Connection connection = FlowerShopDDBB.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tree ORDER BY idProductTree ASC;");
            while (resultSet.next()) {
                System.out.println("- " + resultSet.getInt("idProductTree") + " " + resultSet.getString("treeName"));
            }
            System.out.println("Introduce el id del arbol que quieres eliminar:");
            int num = numCheck();
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM tree WHERE idProductTree = '" + num+"'");
            if (resultSet1.next()) {
                statement.executeUpdate("DELETE FROM tree WHERE idProductTree ='"+num+"'");
                System.out.println("Producto eliminado");
            }
            else{
                System.err.println("NO EXISTE ESTE ID");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public static void removeDecoration(){
        System.out.println("------------------LISTA DE DECORACIONES-----------------");
        try(Connection connection = FlowerShopDDBB.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM decoration ORDER BY idProductDecoration ASC;");
            while (resultSet.next()) {
                System.out.println("- " + resultSet.getInt("idProductDecoration") + " " + resultSet.getString("decorationName"));
            }
            System.out.println("Introduce el id de la decoracion que quieres eliminar:");
            int num = numCheck();
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM decoration WHERE idProductDecoration = '" + num+"'");
            if (resultSet1.next()) {
                statement.executeUpdate("DELETE FROM decoration WHERE idProductDecoration  ='"+num+"'");
                System.out.println("Producto eliminado");
            }
            else{
                System.err.println("NO EXISTE ESTE ID");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void updateQuantityStock(int idProduct,int idCategory, int quantity){
        String tabla = "";
        String columnaId = "";
        String columna= "";
        switch(idCategory){
            case 1:
                tabla = "Tree";
                columnaId = "idProductTree";
                columna = "treeStock";

                break;
            case 2:
                tabla = "Flower";
                columnaId = "idProductFlower";
                columna = "flowerStock";

                break;
            case 3:
                tabla = "Decoration";
                columnaId = "idProductDecoration";
                columna = "DecorationStock";

                break;
        }
        String queryStock = "SElECT " + columna + " FROM " + tabla + " WHERE " + columnaId + " = " + idProduct +";";
        int stockActual = 0;

        try(Connection connection = FlowerShopDDBB.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryStock);

            if (resultSet.next()) {
                stockActual = resultSet.getInt(columna);
            }

            int CalculateStock = stockActual - quantity;
            String updateStock = "UPDATE " + tabla + " SET " + columna + " = " + CalculateStock + " WHERE " + columnaId + " = " + idProduct +";";
            statement.executeUpdate(updateStock);
            System.out.println("¡Stock Actualizado!");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
