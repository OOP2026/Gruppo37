package implementazioneDao;

import dao.SedutaLaureaDAO;
import database_connection.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
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
        String query = "select \"ids\" from \"sedutalaurea\" where \"data\"=? and \"luogo\"=?";
        try (PreparedStatement verificaSedutaPS = connessione.prepareStatement(query)) {
            Date date= Date.valueOf(data);
            verificaSedutaPS.setObject(1, date);
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
        String sql="SELECT \"luogo\" FROM \"sedutalaurea\"";
        try (PreparedStatement aggiungiLuogoPS = connessione.prepareStatement(sql)) {
            ResultSet rs = aggiungiLuogoPS.executeQuery();
            ArrayList<String> luogo = new ArrayList<>();
            while (rs.next()) {
                luogo.add(rs.getString("luogo"));
            }
            return luogo;
        }
    }

    public ArrayList<Object> getDataSeduta() throws SQLException{
        String sql="SELECT \"data\" FROM \"sedutalaurea\"";
        try (PreparedStatement aggiungiDataPS = connessione.prepareStatement(sql)) {
            ResultSet rs = aggiungiDataPS.executeQuery();
            ArrayList<Object> data = new ArrayList<>();
            while (rs.next()) {
                data.add(rs.getObject("data"));
            }
            return data;
        }
    }

    public ArrayList<String> accediSeduta(int idS) throws SQLException {
        String sql="SELECT sl.data,sl.luogo FROM sedutalaurea sl " +
                "JOIN studente s ON s.idseduta=sl.ids" +
                " WHERE s.ids=?";
        try (PreparedStatement accediSedutaPS = connessione.prepareStatement(sql)) {
            accediSedutaPS.setInt(1, idS);
            ResultSet rs = accediSedutaPS.executeQuery();
            ArrayList<String> info = new ArrayList<>();
            if (rs.next()) {
                info.add(rs.getString("data"));
                info.add(rs.getString("luogo"));
                return info;
            }
            return null;
        }
    }
}
