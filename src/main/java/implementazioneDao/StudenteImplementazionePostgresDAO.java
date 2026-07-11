package implementazioneDao;

import dao.StudenteDAO;
import database_connection.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<String> accediStudente(String login, String password) throws SQLException {
        String sql="SELECT \"nome\",\"cognome\",\"email\",\"login\", \"password\", \"matricola\" FROM \"studente\" WHERE \"login\"=?, \"password\"=?";
        try(PreparedStatement accediStudentePS=connessione.prepareStatement(sql)) {
            accediStudentePS.setString(1, login);
            accediStudentePS.setString(2, password);

            ResultSet rs = accediStudentePS.executeQuery();
            ArrayList<String> info=new ArrayList<String>();
            info.add(rs.getString("nome"));
            info.add(rs.getString("cognome"));
            info.add(rs.getString("email"));
            info.add(rs.getString("login"));
            info.add(rs.getString("password"));
            info.add(rs.getString("matricola"));
            return info;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
