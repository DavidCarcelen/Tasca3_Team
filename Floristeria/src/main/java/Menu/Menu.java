package Menu;

import java.util.Scanner;

import static FlowerStore.Functions.AuxiliarMethods.*;
import static FlowerStore.Functions.SubMenus.*;
import static FlowerStore.Tickets.TicketMethods.*;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    public static void menu(){
        int num = 0;
        do {
            System.out.println("BIENVENIDO A LA FLORISTERÍA\n" +
                    "ELIJE UNA OPCIÓN:\n" +
                    "1 AÑADIR PRODUCTOS\n" +
                    "2 VER PRODUCTOS \n" +
                    "3 ELIMINAR PRODUCTOS\n" +
                    "4 NUEVO TICKET\n" +
                    "5 VER TODOS LOS TICKETS\n" +
                    "6 SALIR");

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
                    showAllTickets();
                    break;
                case 6:
                    System.out.println("ADIÓS");
                    break;
                default:
                    System.out.println("No es una opción válida, elije una opción del menu.");
                    break;
            }

        } while (num != 6);
    }
}
