package FlowerStore.Functions;

import FlowerStore.Items.Product;
import FlowerStore.Items.Tree;
import FlowerStore.Items.Decoration;
import FlowerStore.Items.Flower;

import java.util.Scanner;

import static FlowerStore.Functions.AuxiliarMethods.*;
import static FlowerStore.Functions.ShowMethods.*;
import static FlowerStore.Functions.AddMethods.*;

public class SubMenus {
    static Scanner sc = new Scanner(System.in);
    public static void addProductStock() {
        int option;
        Product product;
        do {
            System.out.println("ELIJE TIPO DE PRODUCTO A AÑADIR: \n" +
                    "1 ARBOL \n" +
                    "2 FLOR \n" +
                    "3 DECORACIÓN \n" +
                    "4 SALIR");

            option = numCheck();
            switch (option) {
                case 1:
                    product = productData();
                    System.out.println("INDICA ALTURA DEL ARBOL:");
                    double height = doubleCheck();
                    Tree tree = new Tree(product.getName(), product.getPrice(), product.getQuantity(), height);
                    addTreeToDatabase(tree);
                    break;
                case 2:
                    product = productData();
                    int color = flowerGetIdColor();
                    Flower flower = new Flower(product.getName(), product.getPrice(), product.getQuantity(), color);
                    addFLowerToDatabase(flower);
                    break;
                case 3:
                    product = productData();
                    int material = decorationGetIdType();
                    Decoration decoration = new Decoration(product.getName(), product.getPrice(), product.getQuantity(), material);
                    addDecorationToDatabase(decoration);
                    break;
                default:
                    break;
            }
        } while (option != 4);
    }
    public static void removeProductStock(){
        int option;
        do {
            System.out.println("ELIJE TIPO DE PRODUCTO A ELIMINAR: \n" +
                    "1 ARBOL \n" +
                    "2 FLOR \n" +
                    "3 DECORACIÓN \n" +
                    "4 SALIR");

            option = numCheck();
            switch (option) {
                case 1:
                    RemoveMethods.removeTree();
                    break;
                case 2:
                    RemoveMethods.removeFlower();
                    break;
                case 3:
                    RemoveMethods.removeDecoration();
                    break;
                default:
                    break;
            }
        } while (option != 4);
    }
    public static void showStock(){
        int option;
        do{
            System.out.println("ELIJE QUÉ MOSTRAR:\n" +
                    "1. ÁRBOLES\n" +
                    "2. FLORES\n" +
                    "3. DECORACIÓN\n" +
                    "4. STOCK COMPLETO\n" +
                    "5. VALOR TOTAL DE LA TIENDA\n" +
                    "6. SALIR");
            option = numCheck();

            switch (option){
                case 1:
                    showTree();
                    break;
                case 2:
                    showFlower();
                    break;
                case 3:
                    showDecoration();
                    break;
                case 4:
                    System.out.println("-----------------STOCK-----------------");
                    showTree();
                    showFlower();
                    showDecoration();
                    break;
                case 5:
                    totalValue();
                    break;
                default:
                    break;
            }

        }while (option != 6);

    }


}
