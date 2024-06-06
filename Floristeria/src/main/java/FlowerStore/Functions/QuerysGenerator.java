package FlowerStore.Functions;

import Connections.FlowerShopDDBB;
import FlowerStore.Items.Arbol;
import FlowerStore.Items.Decoracion;
import FlowerStore.Items.Flor;
import FlowerStore.Items.Producto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import static Menu.Menu.numCheck;

public class QuerysGenerator {
<<<<<<< HEAD
    private static String allProducts ="Select * from product";

    public static void addFLowerToDatabase(Flor flor) {
        String queryProduct = "INSERT INTO products (idCategory) VALUES (1);";
        String queryFlower = "INSERT INTO flower (flowerName, idColorFlower, flowerStock, flowerPrice) VALUES (" + flor.getName() + ", " + " 1 "+ ", " + flor.getQuantity() + ", " + flor.getPrice() + ");";
        String queryColor = "INSERT INTO color (idcolor, colorName) VALUES ( 1, " + flor.getColor() + ");";
        System.out.println(queryProduct);
        System.out.println(queryFlower);
        System.out.println(queryColor);
    }
    public static void addTreeToDatabase(Arbol arbol) {
        String queryProduct = "INSERT INTO product (idCategory) VALUES (2);";
=======
    static Scanner sc = new Scanner(System.in);

    private static String queryGetIdProduct = "SELECT idProduct FROM product ORDER BY idProduct DESC LIMIT 1;";
    private static String queryGetIdColor = "SELECT idColor FROM color ORDER BY idColor DESC LIMIT 1;";

    public static void addFLowerToDatabase(Flor flor) {

        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        ResultSet resultSet3 = null;
        ResultSet resultSet4 = null;
        Statement statement = null;
        try(Connection connection = FlowerShopDDBB.getConnection()) {
            statement = FlowerShopDDBB.getConnection().createStatement();
            statement.executeUpdate("INSERT INTO product (idCategoryProduct) VALUES (1);");
            resultSet2 = statement.executeQuery(queryGetIdProduct);
            int idProduct = 0;
            if (resultSet2.next()) {
                idProduct = resultSet2.getInt("idProduct");
            }
            statement.executeUpdate("INSERT INTO flower (idProductFlower, flowerName, idColorFlower, flowerStock, flowerPrice) VALUES ( " + idProduct + ",'"+ flor.getName()+"',"+  flor.getColor() + ", " + flor.getQuantity() + ", " + flor.getPrice() + ");");

            /* resultSet4 = statement.executeQuery("INSERT INTO color (idcolor, colorName) VALUES ( 1, " + flor.getColor() + ");");*/
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
    public static void addTreeToDatabase(Arbol arbol) {
        String queryProduct = "INSERT INTO product (idCategory) VALUES (2);";
        // SELECT * FROM PRODUCTS ORDER BY idProduct DESC LIMIT 1
>>>>>>> 9afcedc2273458feb1a683727ba45fba018f9cb4
        String queryTree = "INSERT INTO tree (treeName, treeStock, treePrice) VALUES (" + arbol.getName() + ", " + arbol.getHeight() + ", " + arbol.getQuantity() + ", " + arbol.getPrice() + ");";
        System.out.println(queryProduct);
        System.out.println(queryTree);
    }
    public static void addDecorationToDatabase(Decoracion decoracion) {
        String queryProduct = "INSERT INTO product (idCategory) VALUES (3);";
<<<<<<< HEAD
        String queryDecoration = "INSERT INTO decoration (decorationName, decorationMaterial, decorationStock, decorationPrice) VALUES (" + decoracion.getName() + ", " + decoracion.getMaterialType() + ", " + decoracion.getQuantity() + ", " + decoracion.getPrice() + ");";
        System.out.println(queryProduct);
        System.out.println(queryDecoration);
=======
        // SELECT * FROM PRODUCTS ORDER BY idProduct DESC LIMIT 1
        String queryDecoration = "INSERT INTO decoration (decorationName, decorationMaterial, decorationStock, decorationPrice) VALUES (" + decoracion.getName() + ", " + " 1 " + ", " + decoracion.getQuantity() + ", " + decoracion.getPrice() + ");";
        String queryMaterial = "INSERT INTO material (idMaterial, materialName) VALUES ( 1, " + decoracion.getMaterialType() + ");";
        System.out.println(queryProduct);
        System.out.println(queryDecoration);
        System.out.println(queryMaterial);
    }

    public static int flowerGetIdColor() {
        try(Connection connection = FlowerShopDDBB.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM color;");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("colorName") + " " + resultSet.getInt("idColor"));
            }
            System.out.println("Introduce el id del color o introduce 0 si no existe en la tabla:");
            int num = numCheck();
            if(num == 0){
                System.out.println("Dígame que color quiere añadir a la tabla:");
                String color = sc.nextLine();
                statement.executeUpdate("INSERT INTO color (colorName) VALUES ('" + color + "');");
                ResultSet resultSet1 = statement.executeQuery(queryGetIdColor);
                while (resultSet1.next()) {
                    System.out.println(resultSet1.getString("colorName") + " " + resultSet1.getInt("idColor"));
                }
                return resultSet1.getInt("idColor");
            }else{
                return num;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return 0;
>>>>>>> 9afcedc2273458feb1a683727ba45fba018f9cb4
    }

}
