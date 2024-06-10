package Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FlowerShopDDBB {
    private static FlowerShopDDBB instance;
    private static final String URL = "jdbc:mysql://localhost:3306/flowershop";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private FlowerShopDDBB(){
    }

    public static FlowerShopDDBB getInstance(){
        if (instance == null){
            instance = new FlowerShopDDBB();
        }
        return instance;
    }


    public Connection getConnection2() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}