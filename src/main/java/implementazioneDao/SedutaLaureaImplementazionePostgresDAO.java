package implementazioneDao;

import dao.SedutaLaureaDAO;
import database_connection.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;


public class SedutaLaureaImplementazionePostgresDAO implements SedutaLaureaDAO {
    private Connection connessione;

    public SedutaLaureaImplementazionePostgresDAO() {
        try {
            connessione = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int verificaSeduta(String data, String luogo) throws SQLException {
        String query = "select \"ids\" from \"seduta\" where \"data\"=? and \"luogo\"=?";
        try (PreparedStatement verificaSedutaPS = connessione.prepareStatement(query)) {
            verificaSedutaPS.setObject(1, data);
            verificaSedutaPS.setString(2, luogo);
            ResultSet rs = verificaSedutaPS.executeQuery();
            if (rs.next()) {
                return rs.getInt("ids");
            }  else {
                return 0;
            }
        }
    }

    public ArrayList<String> getLuogoSeduta() throws SQLException{
        String sql="SELECT \"luogo\" FROM \"seduta\"";
        try (PreparedStatement aggiungiLuogoPS = connessione.prepareStatement(sql)) {
            ResultSet rs = aggiungiLuogoPS.executeQuery();
            ArrayList<String> luogo = new ArrayList<>();
            while (rs.next()) {
                luogo.add(rs.getString("luogo"));
            }
            return luogo;
        }
    }

    public ArrayList<String> getDataSeduta() throws SQLException{
        String sql="SELECT \"data\" FROM \"seduta\"";
        try (PreparedStatement aggiungiDataPS = connessione.prepareStatement(sql)) {
            ResultSet rs = aggiungiDataPS.executeQuery();
            ArrayList<String> data = new ArrayList<>();
            while (rs.next()) {
                data.add(rs.getString("data"));
            }
            return data;
        }
    }
}
