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

    public void salvaTesi(String titolo, String testo, String nomeS) throws SQLException {
        String sql = "UPDATE \"tesi\" SET \"testo\"=?, \"titolo\"=? WHERE \"nomestudente\"=?";
        try (PreparedStatement salvaTesiPS = connessione.prepareStatement(sql)) {
            salvaTesiPS.setString(1, testo);
            salvaTesiPS.setString(2, titolo);
            salvaTesiPS.setString(3, nomeS);
            salvaTesiPS.executeUpdate();
            salvaTesiPS.close();
        }
    }

    public void caricaTesi(String nomeS) throws SQLException {
        String sql = "UPDATE \"tesi\" SET \"caricata\"=? WHERE \"nomestudente\"=?";
        try (PreparedStatement salvaTesiPS = connessione.prepareStatement(sql)) {
            salvaTesiPS.setBoolean(1, true);
            salvaTesiPS.setString(2, nomeS);
            salvaTesiPS.executeUpdate();
            salvaTesiPS.close();
        }
    }
}
