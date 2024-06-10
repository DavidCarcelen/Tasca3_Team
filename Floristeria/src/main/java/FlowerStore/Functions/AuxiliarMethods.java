package FlowerStore.Functions;

import FlowerStore.Items.Product;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AuxiliarMethods {
    static Scanner sc = new Scanner(System.in);

    public static int numCheck() {
        int num = 0;
        boolean b = false;
        while (!b) {
            try {
                num = sc.nextInt();
                b = true;
            } catch (InputMismatchException e) {
                System.out.println("INSERTA UN NÚMERO");
                sc.nextLine();
            }
        }
        return num;
    }

    public static double doubleCheck() {
        double num = 0;
        boolean b = false;
        while (!b) {
            try {
                num = sc.nextDouble();
                b = true;
            } catch (InputMismatchException e) {
                System.err.println("INSERTA UN NÚMERO");
                sc.nextLine();
            }
        }
        return num;
    }

    public static int idCheck(ArrayList<Integer> listaId) {
        boolean b = false;
        int num;
        do {
            System.out.println("INTRODUCE UN ID DE LA TABLA, INTRODUCE 0 SI NO ESTÁ:");
            num = numCheck();
            if (num != 0) {
                int i = 0;
                while (i < listaId.size() && !b) {
                    if (listaId.get(i) == num) {
                        b = true;
                    }
                    i++;
                }
                if (!b) {
                    System.err.println("NO EXISTE ESE ID");
                }
            }
        } while ((!b) && (num != 0));

        return num;
    }

    public static Product productData() {
        sc.nextLine();
        System.out.println("INDICA UN NOMBRE:");
        String name = sc.nextLine();
        System.out.println("INDICA UN PRECIO: ");
        double price = doubleCheck();
        System.out.println("INDICA UNA CANTIDAD: ");
        int quantity = numCheck();
        Product product = new Product(name, price, quantity);
        return product;
    }
}
