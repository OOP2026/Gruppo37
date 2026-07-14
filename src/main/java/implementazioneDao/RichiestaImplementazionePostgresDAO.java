package implementazioneDao;

import dao.RichiestaDAO;
import database_connection.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class RichiestaImplementazionePostgresDAO implements RichiestaDAO {
    private Connection connessione;

    public RichiestaImplementazionePostgresDAO() {
        try{
            connessione=ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void creaRichiesta(int idT, int idS, int idD)throws SQLException {
        String sql="INSERT INTO \"richiesta\" (\"ids\", \"idd\", \"idt\", \"stato\", \"dataRichiesta\") " +
                "VALUES (?,?,?,?,?);";
        try (PreparedStatement creaRichiestaPS=connessione.prepareStatement(sql)){
            creaRichiestaPS.setInt(1,idS);
            creaRichiestaPS.setInt(2,idD);
            creaRichiestaPS.setInt(3,idT);
            creaRichiestaPS.setString(4,"InAttesa");
            creaRichiestaPS.setObject(5, LocalDate.now());

            creaRichiestaPS.executeUpdate();
            creaRichiestaPS.close();
        }
    }
}
