package FlowerStore.Functions;

import Connections.FlowerShopDDBB;
import FlowerStore.Items.Arbol;
import FlowerStore.Items.Decoracion;
import FlowerStore.Items.Flor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Menu.Menu.numCheck;

public class AddMethods {
    static Scanner sc = new Scanner(System.in);

    private static String queryGetIdProduct = "SELECT idProduct FROM product ORDER BY idProduct DESC LIMIT 1;";
    private static String queryGetIdColor = "SELECT idColor FROM color ORDER BY idColor DESC LIMIT 1;";
    private static String queryGetIdMaterial = "SELECT idMaterial FROM material ORDER BY idMaterial DESC LIMIT 1;";

    public static void addFLowerToDatabase(Flor flor) {
        try(Connection connection = FlowerShopDDBB.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO product (idCategoryProduct) VALUES (2);");
            ResultSet resultSet = statement.executeQuery(queryGetIdProduct);
            int idProduct = 0;
            if (resultSet.next()) {
                idProduct = resultSet.getInt("idProduct");
            }
            statement.executeUpdate("INSERT INTO flower (idProductFlower, flowerName, idColorFlower, flowerStock, flowerPrice) VALUES ( " + idProduct + ",'"+ flor.getName()+"',"+  flor.getColor() + ", " + flor.getQuantity() + ", " + flor.getPrice() + ");");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public static void addTreeToDatabase(Arbol arbol) {
        try(Connection connection = FlowerShopDDBB.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO product (idCategoryProduct) VALUES (1);");
            ResultSet resultSet = statement.executeQuery(queryGetIdProduct);
            int idProduct = 0;
            if (resultSet.next()) {
                idProduct = resultSet.getInt("idProduct");
            }
            statement.executeUpdate("INSERT INTO tree (idProductTree, treeName, height, treeStock, treePrice) VALUES ( " + idProduct + ",'"+ arbol.getName()+"',"+  arbol.getHeight() + ", " + arbol.getQuantity() + ", " + arbol.getPrice() + ");");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public static void addDecorationToDatabase(Decoracion decoracion) {
        String queryMaterial = "INSERT INTO material (idMaterial, materialName) VALUES ( 1, " + decoracion.getMaterialType() + ");";

        try(Connection connection = FlowerShopDDBB.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO product (idCategoryProduct) VALUES (3);");
            ResultSet resultSet = statement.executeQuery(queryGetIdProduct);
            int idProduct = 0;
            if (resultSet.next()) {
                idProduct = resultSet.getInt("idProduct");
            }
            statement.executeUpdate("INSERT INTO decoration (idProductDecoration, DecorationName, idMaterialDecoration, DecorationStock, DecorationPrice) VALUES ( " + idProduct + ",'"+ decoracion.getName()+"',"+  decoracion.getMaterialType() + ", " + decoracion.getQuantity() + ", " + decoracion.getPrice() + ");");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public static int flowerGetIdColor() {
        int idColor = 0;
        int num = 0;
        System.out.println("------------------LISTA DE COLORES-----------------");
        try(Connection connection = FlowerShopDDBB.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM color;");
            ArrayList <Integer> listaId = new ArrayList<>();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("colorName") + " " + resultSet.getInt("idColor"));
                listaId.add(resultSet.getInt("idColor"));
            }
            boolean b = false;
            do{
                System.out.println("Introduce el id del color que aparece en la tabla o introduce 0 si no existe en la tabla:");
                num = numCheck();
                if (num != 0) {
                    int i = 0;
                    while (i< listaId.size() && !b){
                        if(listaId.get(i) == num ){
                            b = true;
                        }
                        i++;
                    }
                    if (!b){
                        System.out.println("No existe ese ID");
                    }
                }
            }while((!b) && (num != 0));
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
        int num = 0;
        System.out.println("------------------LISTA DE MATERIALES-----------------");
        try(Connection connection = FlowerShopDDBB.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM material;");
            ArrayList <Integer> listaId = new ArrayList<>();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("materialName") + " " + resultSet.getInt("idMaterial"));
                listaId.add(resultSet.getInt("idMaterial"));
            }
            boolean b = false;
            do{
                System.out.println("Introduce el id del material que aparece en la tabla o introduce 0 si no existe en la tabla:");
                num = numCheck();
                if (num != 0) {
                    int i = 0;
                    while (i< listaId.size() && !b){
                        if(listaId.get(i) == num ){
                            b = true;
                        }
                        i++;
                    }
                    if (!b){
                        System.out.println("No existe ese ID");
                    }
                }
            }while((!b) && (num != 0));
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