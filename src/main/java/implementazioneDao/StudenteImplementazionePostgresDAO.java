package implementazioneDao;

import dao.StudenteDAO;
import database_connection.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudenteImplementazionePostgresDAO implements StudenteDAO {
    private Connection connessione;

    public StudenteImplementazionePostgresDAO() {
        try{
            connessione=ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void aggiungiStudente(String nome, String cognome, String email, String login, String password) throws SQLException {
        String sql="INSERT INTO \"studente\" (\"nome\", \"cognome\", \"email\", \"login\", \"password\", \"matricola\") VALUES (?,?,?,?,?,?);";
        try (PreparedStatement aggiungiStudentePS=connessione.prepareStatement(sql)){
            aggiungiStudentePS.setString(1,nome);
            aggiungiStudentePS.setString(2,cognome);
            aggiungiStudentePS.setString(3,email);
            aggiungiStudentePS.setString(4,login);
            aggiungiStudentePS.setString(5,password);
            aggiungiStudentePS.setString(6,null);

            aggiungiStudentePS.executeUpdate();
            aggiungiStudentePS.close();
        }
    }
}
