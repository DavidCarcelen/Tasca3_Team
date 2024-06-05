package Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Database {

    private static Database instance;

    private Database (){
    }

    public static Database getInstance(){
        if (instance == null){
            instance = new Database();
        }
        openDatabase();
        return instance;
    }

    public static void openDatabase (){

        System.out.println("conexion abierta");
        try {
            Connection connection = DriverManager.getConnection("direccion", "user", "password");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void closeDatabase(){

        System.out.println("conexion cerrada");

    }

}
