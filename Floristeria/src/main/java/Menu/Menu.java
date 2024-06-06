package Menu;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static FlowerStore.Functions.Functions.*;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    public static void menu() throws SQLException {
        int num = 0;
        do {
            System.out.println("Bienvenido a la floristeria\n" +
                    "1 addProductStock\n" +
                    "2 showStock\n" +
                    "3 removeProductStock\n" +
                    "4 newTicket\n" +
                    "5 showTickets(+totalValueSales)\n" +
                    "6 Exit");

            num = numCheck();
            switch (num) {
                case 1:
                    addProductStock();
                    break;
                case 2:

                    break;
                case 3:
                    removeProductStock();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("adios");
                    break;
                default:
                    System.out.println("no es una opcion valida");
                    break;
            }

        } while (num != 6);
    }

    public static int numCheck() {
        int num = 0;
        boolean b = false;
        while (!b) {
            try {
                num = sc.nextInt();
                b = true;
            } catch (InputMismatchException e) {
                System.out.println("Entra un numero");
                sc.nextLine();
            }
        }
        return num;
    }
}
