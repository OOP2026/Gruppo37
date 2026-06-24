package database_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * La classe ConnessioneDatabase.
 * Rappresenta la connessione del sistema al database.
 */
public class ConnessioneDatabase {
    private static ConnessioneDatabase istance;
    public Connection connection=null;
    private String nome="";
    private String password="";
    private String url="";
    private String driver="org.postgresql.Driver";

    /**
     * Costruttore della classe ConnessioneDatabas.
     * Questo costruttore e' privato, in modo tale da poter istanziare solo un oggetto di questo tipo.
     *
     * @throws SQLException e' un eccezione, in caso di fallimento della connessione al database
     */
    private ConnessioneDatabase() throws SQLException {
        try{
            Class.forName(driver);
            connection=DriverManager.getConnection(url,nome,password);
        } catch(ClassNotFoundException e){
            System.out.println("Database Connection Creazione Fallita : " + e.getMessage());
        }
    }

    /**
     * Ottiene l'stanza.
     *
     * @return l'instanza della conessione
     * @throws SQLException e' un eccezione, in caso di fallimento della connessione al database
     */
    public static ConnessioneDatabase getInstance() throws SQLException {
        if(istance==null){
            istance =new ConnessioneDatabase();
        } else if (istance.connection.isClosed()) {
            istance = new ConnessioneDatabase();
        }
        return istance;
    }

    /**
     * Ottiene la connessione al database.
     *
     * @return la connessione al database
     */
    public Connection getConnection() {
        return connection;
    }

}