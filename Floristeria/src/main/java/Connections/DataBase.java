package Connections;

import java.sql.Connection;

public interface DataBase {

    Connection connect();
    void addNewProduct(DataBase db);
    void addStock(DataBase db, int idProduct);
    void showStock(DataBase db);
    void removeStock(DataBase db, int idProduct);
    void calculateTotalValue(DataBase db);
}
