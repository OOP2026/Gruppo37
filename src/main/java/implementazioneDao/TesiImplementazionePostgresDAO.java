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
        String sqlQ="SELECT \"idt\" FROM \"tesi\" WHERE \"ids\"=? AND \"stato\"<>'Rifiutata'";
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
                    aggiungiTesiPS.setString(4,"inAttesa");
                    aggiungiTesiPS.setBoolean(5,false);
                    aggiungiTesiPS.executeUpdate();
                    aggiungiTesiPS.close();
                }
            }
        }
    }

    public void caricaTesi(int idS) throws SQLException {
        String sql = "UPDATE \"tesi\" SET \"caricata\"=? WHERE \"ids\"=? AND \"stato\"<>'Rifiutata'";
        try (PreparedStatement caricaTesiPS = connessione.prepareStatement(sql)) {
            caricaTesiPS.setBoolean(1, true);
            caricaTesiPS.setInt(2, idS);
            caricaTesiPS.executeUpdate();
            caricaTesiPS.close();
        }
    }

    public ArrayList<Object> notNullTesi(int idS) throws SQLException {
        String sqlQ="SELECT \"ids\", \"idt\", \"titolo\", \"testo\", \"stato\", \"caricata\" FROM \"tesi\" " +
                "WHERE \"ids\"=? AND \"stato\"<>'Rifiutata'";
        ArrayList<Object> info = new ArrayList<>();
        try(PreparedStatement st = connessione.prepareStatement(sqlQ);) {
            st.setInt(1, idS);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                info.add(rs.getInt("ids"));
                info.add(rs.getInt("idt"));
                info.add(rs.getString("titolo"));
                info.add(rs.getString("testo"));
                info.add(rs.getString("stato"));
                info.add(rs.getBoolean("caricata"));
                return info;}
            return null;
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
