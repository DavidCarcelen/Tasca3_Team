package Menu;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static FlowerStore.Functions.AuxiliarMethods.*;
import static FlowerStore.Functions.Functions.*;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    public static void menu() throws SQLException {
        int num = 0;
        do {
            System.out.println("Bienvenido a la floristeria\n" +
                    "1 addProductStock\n" +
                    "2 showStock \n" +
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
                    showStock();
                    break;
                case 3:
                    removeProductStock();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Adios.");
                    break;
                default:
                    System.out.println("No es una opción valida. Introduce una opcion que exista en el menu.");
                    break;
            }

        } while (num != 6);
    }
}
