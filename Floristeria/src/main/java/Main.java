import Connections.Database;
import Menu.Menu;

public class Main {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        Menu menu = new Menu();
        menu.menu();
        Database.closeDatabase();
    }
}
