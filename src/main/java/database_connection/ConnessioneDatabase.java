package database_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnessioneDatabase {
    private static ConnessioneDatabase istance;
    public Connection connection=null;
    private String nome="";
    private String password="";
    private String url="";
    private String driver="org.postgresql.Driver";

    private ConnessioneDatabase() throws SQLException {
        try{
            Class.forName(driver);
            connection=DriverManager.getConnection(url,nome,password);
        } catch(ClassNotFoundException e){
            System.out.println("Database Connection Creazione Fallita : " + e.getMessage());
        }
    }

    public static ConnessioneDatabase getInstance() throws SQLException {
        if(istance==null){
            istance =new ConnessioneDatabase();
        } else if (istance.connection.isClosed()) {
            istance = new ConnessioneDatabase();
        }
        return istance;
    }

    public Connection getConnection() {
        return connection;
    }

}