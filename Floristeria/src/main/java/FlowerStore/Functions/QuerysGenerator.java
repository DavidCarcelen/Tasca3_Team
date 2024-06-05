package FlowerStore.Functions;

import FlowerStore.Items.Arbol;
import FlowerStore.Items.Decoracion;
import FlowerStore.Items.Flor;
import FlowerStore.Items.Producto;

public class QuerysGenerator {

    private static String queryGetIdProduct = "SELECT idProduct FROM product ORDER BY idProduct DESC LIMIT 1;";

    public static void addFLowerToDatabase(Flor flor) {
        String queryProduct = "INSERT INTO product (idCategory) VALUES (1);";
        int idProduct = getIdProduct(queryGetIdProduct);
        String queryFlower = "INSERT INTO flower (flowerName, idColorFlower, flowerStock, flowerPrice) VALUES ( " + idProduct + "," + flor.getName() + ", " + " 1 "+ ", " + flor.getQuantity() + ", " + flor.getPrice() + ");";
        String queryColor = "INSERT INTO color (idcolor, colorName) VALUES ( 1, " + flor.getColor() + ");";
        System.out.println(queryProduct);
        System.out.println(queryFlower);
        System.out.println(queryColor);
    }
    public static void addTreeToDatabase(Arbol arbol) {
        String queryProduct = "INSERT INTO product (idCategory) VALUES (2);";
        // SELECT * FROM PRODUCTS ORDER BY idProduct DESC LIMIT 1
        String queryTree = "INSERT INTO tree (treeName, treeStock, treePrice) VALUES (" + arbol.getName() + ", " + arbol.getHeight() + ", " + arbol.getQuantity() + ", " + arbol.getPrice() + ");";
        System.out.println(queryProduct);
        System.out.println(queryTree);
    }
    public static void addDecorationToDatabase(Decoracion decoracion) {
        String queryProduct = "INSERT INTO product (idCategory) VALUES (3);";
        // SELECT * FROM PRODUCTS ORDER BY idProduct DESC LIMIT 1
        String queryDecoration = "INSERT INTO decoration (decorationName, decorationMaterial, decorationStock, decorationPrice) VALUES (" + decoracion.getName() + ", " + " 1 " + ", " + decoracion.getQuantity() + ", " + decoracion.getPrice() + ");";
        String queryMaterial = "INSERT INTO material (idMaterial, materialName) VALUES ( 1, " + decoracion.getMaterialType() + ");";
        System.out.println(queryProduct);
        System.out.println(queryDecoration);
        System.out.println(queryMaterial);
    }

    public static int getIdProduct(String queryGetIdProduct) {
        return 0;
    }
}
