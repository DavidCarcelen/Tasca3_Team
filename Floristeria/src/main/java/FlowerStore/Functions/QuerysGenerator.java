package FlowerStore.Functions;

import FlowerStore.Items.Arbol;
import FlowerStore.Items.Decoracion;
import FlowerStore.Items.Flor;
import FlowerStore.Items.Producto;

public class QuerysGenerator {

    public static void addFLowerToDatabase(Flor flor) {
        String queryProduct = "INSERT INTO products (idCategory) VALUES (1);";
        String queryFlower = "INSERT INTO flower (flowerName, idColorFlower, flowerStock, flowerPrice) VALUES (" + flor.getName() + ", " + flor.getColor() + ", " + flor.getQuantity() + ", " + flor.getPrice() + ");";
        System.out.println(queryProduct);
        System.out.println(queryFlower);
    }
    public static void addTreeToDatabase(Arbol arbol) {
        String queryProduct = "INSERT INTO products (idCategory) VALUES (2);";
        String queryTree = "INSERT INTO tree (treeName, treeStock, treePrice) VALUES (" + arbol.getName() + ", " + arbol.getHeight() + ", " + arbol.getQuantity() + ", " + arbol.getPrice() + ");";
        System.out.println(queryProduct);
        System.out.println(queryTree);
    }

    public static void addDecorationToDatabase(Decoracion decoracion) {
        String queryProduct = "INSERT INTO products (idCategory) VALUES (3);";
        String queryDecoration = "INSERT INTO decoration (decorationName, decorationMaterial, decorationStock, decorationPrice) VALUES (" + decoracion.getName() + ", " + decoracion.getMaterialType() + ", " + decoracion.getQuantity() + ", " + decoracion.getPrice() + ");";
        System.out.println(queryProduct);
        System.out.println(queryDecoration);

    }
}
