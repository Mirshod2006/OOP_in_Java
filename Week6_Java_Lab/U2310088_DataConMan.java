class DatabaseConnectionManager{
    private static DatabaseConnectionManager instance = new DatabaseConnectionManager();
    static boolean  isConnected = false;
    private  DatabaseConnectionManager(){}
    public static DatabaseConnectionManager getInstance(){
        return instance;
    } 
    public static void openConnection(){
        if(isConnected==false){
            isConnected = true;
            System.out.println("Connection is open!");
            return;
        }
        System.out.println("Connection is already open with somebody!");
    }
    public static void closeConnection(){
        if(isConnected==true){
            isConnected = false;
            System.out.println("Connection is closed!");
            return;
        }
        System.out.println("Your Connection is already closed!");
    }
}

public class U2310088_DataConMan{
    public static void main(String[] args){
        DatabaseConnectionManager  db1 = DatabaseConnectionManager.getInstance();
        db1.openConnection();
        db1.closeConnection();
        DatabaseConnectionManager  db2 = DatabaseConnectionManager.getInstance();
        db2.openConnection();
        DatabaseConnectionManager  db3 = DatabaseConnectionManager.getInstance();
        db3.openConnection();
    }
}

