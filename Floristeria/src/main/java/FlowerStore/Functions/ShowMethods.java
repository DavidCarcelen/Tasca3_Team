package FlowerStore.Functions;

import Connections.FlowerShopDDBB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowMethods {
    private static FlowerShopDDBB flowerShopDDBB = FlowerShopDDBB.getInstance();
    public static void showTree(){
        System.out.println("-----------------ARBOLES----------------");
        try(Connection connection = flowerShopDDBB.getConnection2()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT \n" +
                    "    p.idProduct,\n" +
                    "    p.idCategoryProduct,\n" +
                    "    pc.CategoryName,\n" +
                    "    t.idProductTree,\n" +
                    "    t.treeName,\n" +
                    "    t.height,\n" +
                    "    t.treeStock,\n" +
                    "    t.treePrice\n" +
                    "FROM\n" +
                    "    Product p\n" +
                    "    INNER JOIN Tree t ON p.idProduct = t.idProductTree\n" +
                    "    LEFT JOIN ProductCategory pc ON p.idCategoryProduct = pc.idCategory\n" +
                    "ORDER BY p.idProduct;\n");

            while (resultSet.next()) {
                int idProduct = resultSet.getInt("idProduct");
                int idCategoryProduct = resultSet.getInt("idCategoryProduct");
                String categoryName = resultSet.getString("CategoryName");
                String treeName = resultSet.getString("treeName");
                float height = resultSet.getFloat("height");
                int treeStock = resultSet.getInt("treeStock");
                float treePrice = resultSet.getFloat("treePrice");

                System.out.println("ID: " + idProduct + ", Categoria: " + idCategoryProduct + " (" + categoryName + "), Nombre: " + treeName + ", Altura: " + height + ", Stock: " + treeStock + ", Precio: " + treePrice);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public static void showFlower(){
        System.out.println("------------------FLORES----------------");
        try(Connection connection = flowerShopDDBB.getConnection2()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT \n" +
                    "    p.idProduct,\n" +
                    "    p.idCategoryProduct,\n" +
                    "    pc.CategoryName,\n" +
                    "    f.idProductFlower,\n" +
                    "    f.flowerName,\n" +
                    "    f.flowerStock,\n" +
                    "    f.flowerPrice,\n" +
                    "    c.colorName\n" +
                    "FROM\n" +
                    "    Product p\n" +
                    "    INNER JOIN Flower f ON p.idProduct = f.idProductFlower\n" +
                    "    LEFT JOIN ProductCategory pc ON p.idCategoryProduct = pc.idCategory\n" +
                    "    LEFT JOIN Color c ON f.idColorFlower = c.idColor\n" +
                    "ORDER BY p.idProduct;\n");

            while (resultSet.next()) {
                int idProduct = resultSet.getInt("idProduct");
                int idCategoryProduct = resultSet.getInt("idCategoryProduct");
                String categoryName = resultSet.getString("CategoryName");
                String flowerName = resultSet.getString("flowerName");
                int flowerStock = resultSet.getInt("flowerStock");
                float flowerPrice = resultSet.getFloat("flowerPrice");
                String colorName = resultSet.getString("colorName");

                System.out.println("ID: " + idProduct + ", Categoria: " + idCategoryProduct + " (" + categoryName + "), Nombre: " + flowerName + ", Stock: " + flowerStock + ", Precio: " + flowerPrice + ", Color: " + colorName);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public static void showDecoration(){
        System.out.println("---------------DECORACION---------------");
        try(Connection connection = flowerShopDDBB.getConnection2()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT \n" +
                    "    p.idProduct,\n" +
                    "    p.idCategoryProduct,\n" +
                    "    pc.CategoryName,\n" +
                    "    d.idProductDecoration,\n" +
                    "    d.DecorationName,\n" +
                    "    d.DecorationStock,\n" +
                    "    d.DecorationPrice,\n" +
                    "    m.materialName\n" +
                    "FROM\n" +
                    "    Product p\n" +
                    "    INNER JOIN Decoration d ON p.idProduct = d.idProductDecoration\n" +
                    "    LEFT JOIN ProductCategory pc ON p.idCategoryProduct = pc.idCategory\n" +
                    "    LEFT JOIN Material m ON d.idMaterialDecoration = m.idMaterial\n" +
                    "ORDER BY p.idProduct;\n");

            while (resultSet.next()) {
                int idProduct = resultSet.getInt("idProduct");
                int idCategoryProduct = resultSet.getInt("idCategoryProduct");
                String categoryName = resultSet.getString("CategoryName");
                String decorationName = resultSet.getString("DecorationName");
                int decorationStock = resultSet.getInt("DecorationStock");
                float decorationPrice = resultSet.getFloat("DecorationPrice");
                String materialName = resultSet.getString("materialName");

                System.out.println("ID: " + idProduct + ", Categoria: " + idCategoryProduct + " (" + categoryName + "), Nombre: " + decorationName + ", Stock: " + decorationStock + ", Precio: " + decorationPrice + ", Material: " + materialName);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public static void totalValue (){
        String queryTotalValue = "SELECT (SUM(f.flowerStock * f.flowerPrice) + SUM(t.treeStock * t.treePrice) + SUM(d.DecorationStock * d.DecorationPrice)) AS totalValue FROM Product p LEFT JOIN Flower f ON p.idProduct = f.idProductFlower LEFT JOIN Tree t ON p.idProduct = t.idProductTree LEFT JOIN Decoration d ON p.idProduct = d.idProductDecoration;";

        try(Connection connection = flowerShopDDBB.getConnection2()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryTotalValue);

            if (resultSet.next()) {
                float totalValue = resultSet.getFloat("totalValue");
                System.out.println("VALOR TOTAL DE LA FLORISTERÍA: " + totalValue + "€");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public static float getPrecioProduct(int idCategory, int idProduct){
        String tabla = "";
        String columnaId = "";
        String columna = "";
        float precio = 0;
        switch(idCategory){
            case 1:
                tabla = "Tree";
                columnaId = "idProductTree";
                columna = "treePrice";
                break;
            case 2:
                tabla = "Flower";
                columnaId = "idProductFlower";
                columna = "flowerPrice";
                break;
            case 3:
                tabla = "Decoration";
                columnaId = "idProductDecoration";
                columna = "decorationPrice";
                break;
        }
        String queryPrecio = "SELECT " + columna + " FROM " + tabla + " WHERE " + columnaId + " = " + idProduct +";";

        try(Connection connection = flowerShopDDBB.getConnection2()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryPrecio);

            if (resultSet.next()) {
                precio = resultSet.getFloat(columna);
            } else {
                System.err.println("NO EXISTE ESTE ID");

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return precio;
    }

}
