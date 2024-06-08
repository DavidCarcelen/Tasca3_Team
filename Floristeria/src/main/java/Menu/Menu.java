package Menu;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static FlowerStore.Functions.AuxiliarMethods.*;
import static FlowerStore.Functions.Functions.*;
import static FlowerStore.Tickets.Ticket.createNewTicket;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    public static void menu() throws SQLException {
        int num = 0;
        do {
            System.out.println("Bienvenido a la floristeria\n" +
                    "1 Añadir Productos\n" +
                    "2 Ver Productos \n" +
                    "3 Eliminar Productos\n" +
                    "4 Ticket Nuevo\n" +
                    "5 Ver todos los Tickets\n" +
                    "6 Salir");

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
                    createNewTicket();
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
