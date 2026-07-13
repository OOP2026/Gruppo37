package implementazioneDao;

import dao.TesiDAO;
import database_connection.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TesiImplementazionePostgresDAO implements TesiDAO {
    private Connection connessione;

    public TesiImplementazionePostgresDAO() {
        try {
            connessione = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salvaTesi(String titolo, String testo, int idS) throws SQLException {
        String sqlQ="SELECT \"idt\" FROM \"tesi\" WHERE \"idS\"=? AND \"stato\"<>Rifiutata";
        String sql = "UPDATE \"tesi\" SET \"testo\"=?, \"titolo\"=? WHERE \"ids\"=? AND \"idt\"=?";
        try(PreparedStatement st = connessione.prepareStatement(sqlQ);){
            st.setInt(1,idS);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                int idT=rs.getInt("idt");
                try (PreparedStatement salvaTesiPS = connessione.prepareStatement(sql)) {
                    salvaTesiPS.setString(1, testo);
                    salvaTesiPS.setString(2, titolo);
                    salvaTesiPS.setInt(3, idS);
                    salvaTesiPS.setInt(4, idT);
                    salvaTesiPS.executeUpdate();
                    salvaTesiPS.close();
                }
            }else{
                String sql1="INSERT INTO \"tesi\" (\"ids\", \"titolo\", \"testo\", \"stato\", \"caricata\")" +
                        " VALUES (?,?,?,?,?)";
                try(PreparedStatement aggiungiTesiPS=connessione.prepareStatement(sql1);){
                    aggiungiTesiPS.setInt(1,idS);
                    aggiungiTesiPS.setString(2,titolo);
                    aggiungiTesiPS.setString(3,testo);
                    aggiungiTesiPS.setString(4,null);
                    aggiungiTesiPS.setBoolean(5,false);
                    aggiungiTesiPS.executeUpdate();
                    aggiungiTesiPS.close();
                }
            }
        }
    }

    public void caricaTesi(int idS) throws SQLException {
        String sql = "UPDATE \"tesi\" SET \"caricata\"=? WHERE \"idS\"=? AND \"stato\"<>Rifiutata";
        try (PreparedStatement salvaTesiPS = connessione.prepareStatement(sql)) {
            salvaTesiPS.setBoolean(1, true);
            salvaTesiPS.setInt(2, idS);
            salvaTesiPS.executeUpdate();
            salvaTesiPS.close();
        }
    }

    public boolean notNullTesi(int idS) throws SQLException {
        String sqlQ="EXISTS (SELECT 1 FROM \"tesi\" WHERE \"idS\"=? AND \"stato\"<>Rifiutata)";
        try(PreparedStatement st = connessione.prepareStatement(sqlQ);) {
            st.setInt(1, idS);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                return rs.getBoolean(1);
            } return false;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
