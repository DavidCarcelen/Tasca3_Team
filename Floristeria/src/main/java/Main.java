import Connections.FlowerShopDDBB;
import Menu.Menu;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        FlowerShopDDBB flowerShopDDBB = FlowerShopDDBB.getInstance();
        Menu menu = new Menu();
        menu.menu();
    }
}
