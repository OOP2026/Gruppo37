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
        String sql="INSERT INTO \"studente\" (\"nome\", \"cognome\", \"email\", \"login\", \"password\", \"matricola\", \"idseduta\") " +
                "VALUES (?,?,?,?,?,?,?);";
        try (PreparedStatement aggiungiStudentePS=connessione.prepareStatement(sql)){
            aggiungiStudentePS.setString(1,nome);
            aggiungiStudentePS.setString(2,cognome);
            aggiungiStudentePS.setString(3,email);
            aggiungiStudentePS.setString(4,login);
            aggiungiStudentePS.setString(5,password);
            aggiungiStudentePS.setString(6,null);
            aggiungiStudentePS.setNull(7,java.sql.Types.INTEGER);

            aggiungiStudentePS.executeUpdate();
            aggiungiStudentePS.close();
        }
    }

    public ArrayList<Object> accediStudente(String login, String password) throws SQLException {
        String sql="SELECT \"ids\",\"nome\",\"cognome\",\"email\",\"login\", \"password\", \"matricola\" FROM \"studente\"" +
                   " WHERE \"login\"=? AND \"password\"=?";
        try(PreparedStatement accediStudentePS=connessione.prepareStatement(sql)){
            accediStudentePS.setString(1, login);
            accediStudentePS.setString(2, password);
            ResultSet rs=accediStudentePS.executeQuery();

            if(rs.next()) {
                ArrayList<Object> info = new ArrayList<>();
                info.add(rs.getInt("ids"));
                info.add(rs.getString("nome"));
                info.add(rs.getString("cognome"));
                info.add(rs.getString("email"));
                info.add(rs.getString("login"));
                info.add(rs.getString("password"));
                info.add(rs.getString("matricola"));
                return info;
            }
            return null;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public void aggiungiSeduta(int idS, int idSeduta) throws SQLException {
        String sql="UPDATE \"studente\" SET \"idseduta\"=? WHERE \"ids\"=? ";
        try (PreparedStatement aggiungiSedutaPS=connessione.prepareStatement(sql)){
            aggiungiSedutaPS.setInt(1, idSeduta);
            aggiungiSedutaPS.setInt(2, idS);
            aggiungiSedutaPS.executeUpdate();
            aggiungiSedutaPS.close();
        }
    }
}
