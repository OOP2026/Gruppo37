package implementazioneDao;

import dao.StudenteDAO;
import database_connection.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

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
        String sql1="INSERT INTO \"tesi\" (\"nomestudente\", \"titolo\", \"testo\", \"stato\", \"caricata\") VALUES (?,?,?,?,?);";
        try (PreparedStatement aggiungiStudentePS=connessione.prepareStatement(sql);
        PreparedStatement aggiungiTesiPS=connessione.prepareStatement(sql1);){
            aggiungiStudentePS.setString(1,nome);
            aggiungiStudentePS.setString(2,cognome);
            aggiungiStudentePS.setString(3,email);
            aggiungiStudentePS.setString(4,login);
            aggiungiStudentePS.setString(5,password);
            aggiungiStudentePS.setString(6,null);

            aggiungiStudentePS.executeUpdate();
            aggiungiStudentePS.close();

            aggiungiTesiPS.setString(1,nome);
            aggiungiTesiPS.setString(2,null);
            aggiungiTesiPS.setString(3,null);
            aggiungiTesiPS.setString(4,null);
            aggiungiTesiPS.setBoolean(5,false);
            aggiungiTesiPS.executeUpdate();
            aggiungiTesiPS.close();
        }
    }

    public ArrayList<Objects> accediStudente(String login, String password) throws SQLException {
        String sql="SELECT \"nome\",\"cognome\",\"email\",\"login\", \"password\", \"matricola\" FROM \"studente\"" +
                   " WHERE \"login\"=? AND \"password\"=?";
        String sql1="SELECT \"nomestudente\",\"titolo\",\"testo\",\"stato\",\"caricata\" FROM \"tesi\" " +
                "WHERE \"nomestudente\"=?\"";
        try(PreparedStatement accediStudentePS=connessione.prepareStatement(sql);
        PreparedStatement accediTesiPS=connessione.prepareStatement(sql1);) {
            accediStudentePS.setString(1, login);
            accediStudentePS.setString(2, password);
            ResultSet rs=accediStudentePS.executeQuery();

            if(rs.next()) {
                accediTesiPS.setString(1, rs.getString("nome"));
                ResultSet rs1 = accediTesiPS.executeQuery();
                ArrayList<Objects> info = new ArrayList<Objects>();
                info.add(rs.getString("nome"));
                info.add(rs.getString("cognome"));
                info.add(rs.getString("email"));
                info.add(rs.getString("login"));
                info.add(rs.getString("password"));
                info.add(rs.getString("matricola"));
                if (rs1.next()) {
                    info.add(rs1.getString("nomestudente"));
                    info.add(rs1.getString("titolo"));
                    info.add(rs1.getString("testo"));
                    info.add(rs1.getString("stato"));
                    info.add(rs1.getBoolean("caricata"));
                }
                return info;
            }
            return null;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
