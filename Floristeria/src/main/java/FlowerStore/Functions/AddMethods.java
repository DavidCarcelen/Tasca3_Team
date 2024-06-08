package FlowerStore.Functions;

import Connections.FlowerShopDDBB;
import FlowerStore.Items.Tree;
import FlowerStore.Items.Decoration;
import FlowerStore.Items.Flower;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import static FlowerStore.Functions.AuxiliarMethods.*;

public class AddMethods {
    static Scanner sc = new Scanner(System.in);

    private static String queryGetIdProduct = "SELECT idProduct FROM product ORDER BY idProduct DESC LIMIT 1;";
    private static String queryGetIdColor = "SELECT idColor FROM color ORDER BY idColor DESC LIMIT 1;";
    private static String queryGetIdMaterial = "SELECT idMaterial FROM material ORDER BY idMaterial DESC LIMIT 1;";

    public static void addFLowerToDatabase(Flower flower) {
        try(Connection connection = FlowerShopDDBB.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO product (idCategoryProduct) VALUES (2);");
            ResultSet resultSet = statement.executeQuery(queryGetIdProduct);
            int idProduct = 0;
            if (resultSet.next()) {
                idProduct = resultSet.getInt("idProduct");
            }
            statement.executeUpdate("INSERT INTO flower (idProductFlower, flowerName, idColorFlower, flowerStock, flowerPrice) VALUES ( " + idProduct + ",'"+ flower.getName()+"',"+  flower.getColor() + ", " + flower.getQuantity() + ", " + flower.getPrice() + ");");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public static void addTreeToDatabase(Tree tree) {
        try(Connection connection = FlowerShopDDBB.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO product (idCategoryProduct) VALUES (1);");
            ResultSet resultSet = statement.executeQuery(queryGetIdProduct);
            int idProduct = 0;
            if (resultSet.next()) {
                idProduct = resultSet.getInt("idProduct");
            }
            statement.executeUpdate("INSERT INTO tree (idProductTree, treeName, height, treeStock, treePrice) VALUES ( " + idProduct + ",'"+ tree.getName()+"',"+  tree.getHeight() + ", " + tree.getQuantity() + ", " + tree.getPrice() + ");");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public static void addDecorationToDatabase(Decoration decoration) {
        String queryMaterial = "INSERT INTO material (idMaterial, materialName) VALUES ( 1, " + decoration.getMaterialType() + ");";

        try(Connection connection = FlowerShopDDBB.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO product (idCategoryProduct) VALUES (3);");
            ResultSet resultSet = statement.executeQuery(queryGetIdProduct);
            int idProduct = 0;
            if (resultSet.next()) {
                idProduct = resultSet.getInt("idProduct");
            }
            statement.executeUpdate("INSERT INTO decoration (idProductDecoration, DecorationName, idMaterialDecoration, DecorationStock, DecorationPrice) VALUES ( " + idProduct + ",'"+ decoration.getName()+"',"+  decoration.getMaterialType() + ", " + decoration.getQuantity() + ", " + decoration.getPrice() + ");");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public static int flowerGetIdColor() {
        int idColor = 0;
        System.out.println("------------------LISTA DE COLORES-----------------");
        try(Connection connection = FlowerShopDDBB.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM color ORDER BY idColor ASC;");
            ArrayList <Integer> listaId = new ArrayList<>();
            while (resultSet.next()) {
                System.out.println("- " + resultSet.getInt("idColor") + " " + resultSet.getString("colorName") );
                listaId.add(resultSet.getInt("idColor"));
            }
            int num = idCheck(listaId);
            if(num == 0){
                System.out.println("Dígame que color quiere añadir a la tabla:");
                String color = sc.nextLine();
                statement.executeUpdate("INSERT INTO color (colorName) VALUES ('" + color + "');");
                ResultSet resultSet1 = statement.executeQuery(queryGetIdColor);
                if (resultSet1.next()) {
                    idColor = resultSet1.getInt("idColor");
                }
            }else{
                idColor = num;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return idColor;
    }
    public static int decorationGetIdType() {
        int idMaterial = 0;
        System.out.println("------------------LISTA DE MATERIALES-----------------");
        try(Connection connection = FlowerShopDDBB.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM material ORDER BY idMaterial ASC;");
            ArrayList <Integer> listaId = new ArrayList<>();
            while (resultSet.next()) {
                System.out.println("- " + resultSet.getInt("idMaterial") + " " + resultSet.getString("materialName"));
                listaId.add(resultSet.getInt("idMaterial"));
            }
            int num = idCheck(listaId);
            if(num == 0){
                System.out.println("Dígame que material quiere añadir a la tabla:");
                String material = sc.nextLine();
                statement.executeUpdate("INSERT INTO material (materialName) VALUES ('" + material + "');");
                ResultSet resultSet1 = statement.executeQuery(queryGetIdMaterial);
                if (resultSet1.next()) {
                    idMaterial = resultSet1.getInt("idMaterial");
                }
            }else{
                idMaterial = num;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return idMaterial;
    }

}