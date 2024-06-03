package FlowerStore;

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
    }

    public static void closeDatabase(){
        System.out.println("conexion cerrada");
    }

}
