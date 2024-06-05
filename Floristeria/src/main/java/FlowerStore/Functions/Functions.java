package FlowerStore.Functions;

import FlowerStore.Items.Arbol;
import FlowerStore.Items.Decoracion;
import FlowerStore.Items.Flor;

import java.util.Scanner;

import static FlowerStore.Functions.QuerysGenerator.*;

public class Functions {
    static Scanner sc = new Scanner(System.in);

    //Para crear las diferentes funciones del menu de la floristeria
    // Arraylist de diferentes items

    public static void addProductStock() {
        int option;
        do {
            System.out.println("Que producto quiere añadir? \n" +
                    "1. Flor. \n" +
                    "2. Arbol. \n" +
                    "3. Decoración. \n" +
                    "4. Salir");

            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Dígame el nombre de la flor que quiere anadir: ");
                    String name = sc.nextLine();
                    System.out.println("Dígame el color de la flor que quiere anadir: ");
                    String color = sc.nextLine();
                    System.out.println("Dígame el precio de la flor que quiere anadir: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Dígame la cantidad de la flor que quiere anadir: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();
                    Flor flor = new Flor(name, price, quantity, color);
                    //Genera una query para insertar en la base de datos
                    addFLowerToDatabase(flor);
                    break;
                case 2:
                    System.out.println("Dígame el nombre del arbol que quiere anadir: ");
                    name = sc.nextLine();
                    System.out.println("Dígame el tamaño de la flor que quiere anadir: ");
                    int size = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Dígame el precio del arbol que quiere anadir: ");
                    price = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Dígame la cantidad del arbol que quiere anadir: ");
                    quantity = sc.nextInt();
                    sc.nextLine();
                    Arbol arbol = new Arbol(name, price, quantity, size);
                    addTreeToDatabase(arbol);
                    break;
                case 3:
                    System.out.println("Dígame el nombre de la decoración que quiere anadir: ");
                    name = sc.nextLine();
                    System.out.println("Dígame el material de la decoración que quiere anadir: ");
                    String material = sc.nextLine();
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

}
