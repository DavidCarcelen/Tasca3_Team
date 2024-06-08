package FlowerStore.Functions;

import FlowerStore.Items.Arbol;
import FlowerStore.Items.Decoracion;
import FlowerStore.Items.Flor;

import java.sql.SQLException;
import java.util.Scanner;

import static FlowerStore.Functions.ShowMethods.*;
import static FlowerStore.Functions.AddMethods.*;
import static Menu.Menu.numCheck;

public class Functions {
    static Scanner sc = new Scanner(System.in);


    public static void addProductStock() {
        int option;
        do {
            System.out.println("Que producto quiere añadir? \n" +
                    "1. Flor. \n" +
                    "2. Arbol. \n" +
                    "3. Decoración. \n" +
                    "4. Salir");

            option = numCheck();
            switch (option) {
                case 1:
                    System.out.println("Dígame el nombre de la flor que quiere anadir: ");
                    String name = sc.nextLine();

                    int color = flowerGetIdColor();

                    System.out.println("Dígame el precio de la flor que quiere anadir: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Dígame la cantidad de la flor que quiere anadir: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();
                    Flor flor = new Flor(name, price, quantity, color);
                    addFLowerToDatabase(flor);
                    break;
                case 2:
                    System.out.println("Dígame el nombre del arbol que quiere anadir: ");
                    name = sc.nextLine();
                    System.out.println("Dígame el tamaño de la flor que quiere anadir: ");
                    int height = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Dígame el precio del arbol que quiere anadir: ");
                    price = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Dígame la cantidad del arbol que quiere anadir: ");
                    quantity = sc.nextInt();
                    sc.nextLine();
                    Arbol arbol = new Arbol(name, price, quantity, height);
                    addTreeToDatabase(arbol);
                    break;
                case 3:
                    System.out.println("Dígame el nombre de la decoración que quiere anadir: ");
                    name = sc.nextLine();
                    int material = decorationGetIdType();
                    System.out.println("Dígame el precio de la decoración que quiere anadir: ");
                    price = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Dígame la cantidad de la decoración que quiere anadir: ");
                    quantity = sc.nextInt();
                    sc.nextLine();
                    Decoracion decoracion = new Decoracion(name, price, quantity, material);
                    addDecorationToDatabase(decoracion);
                    break;
                default:
                    break;
            }
        } while (option != 4);
    }

    public static void removeProductStock() throws SQLException {
        int option;
        do {
            System.out.println("Que producto quiere eliminar? \n" +
                    "1. Flor. \n" +
                    "2. Arbol. \n" +
                    "3. Decoración. \n" +
                    "4. Salir");

            option = numCheck();
            switch (option) {
                case 1:
                    RemoveMethods.removeFlower();
                    break;
                case 2:
                   RemoveMethods.removeTree();
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
            System.out.println("Elija una opción\n" +
                    "1. Mostrar Arboles\n" +
                    "2. Mostrar Flores\n" +
                    "3. Mostrar Decoracion\n" +
                    "4. Mostrar Stock completo\n" +
                    "5. Mostrar Valor total de la tienda\n" +
                    "6. Salir");
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
