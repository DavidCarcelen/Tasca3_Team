package FlowerStore.Functions;

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
                System.out.println("Entra un numero");
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
                num = sc.nextInt();
                b = true;
            } catch (InputMismatchException e) {
                System.out.println("Entra un numero");
                sc.nextLine();
            }
        }
        return num;
    }
    public static int idCheck(ArrayList<Integer> listaId) {
        boolean b = false;
        int num = 0;
        do{
            System.out.println("Introduce el id que aparece en la tabla o introduce 0 si no existe en la tabla:");
            num = numCheck();
            if (num != 0) {
                int i = 0;
                while (i< listaId.size() && !b){
                    if(listaId.get(i) == num ){
                        b = true;
                    }
                    i++;
                }
                if (!b){
                    System.out.println("No existe ese ID");
                }
            }
        }while((!b) && (num != 0));

        return num;
    }

}
