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
        String sql="INSERT INTO \"richiesta\" (\"ids\", \"idd\", \"idt\", \"stato\", \"data\") " +
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

    public ArrayList<String> getStudenteETirocinio(int idD) throws SQLException{
        ArrayList<String> info=new ArrayList<>();
        String sql =
                "SELECT s.nome, s.cognome, t.nometirocinio " +
                        "FROM richiesta r " +
                        "JOIN tirocinio t ON r.idt = t.idt " +
                        "JOIN studente s ON r.ids = s.ids " +
                        "WHERE r.idd = ? AND r.stato = 'InAttesa'";

        try (PreparedStatement getStudenteETirocinioPS=connessione.prepareStatement(sql)){
            getStudenteETirocinioPS.setInt(1,idD);
            ResultSet rs=getStudenteETirocinioPS.executeQuery();
            while (rs.next()) {
                info.add(rs.getString("nome"));
                info.add(rs.getString("cognome"));
                info.add(rs.getString("nometirocinio"));
            }
        }
        return info;
    }

    public boolean verificaRichiesta(String nome,String cognome, String tirocinio, boolean stato) throws SQLException{
        String sqlQ="SELECT idr " +
                "FROM richiesta r " +
                "JOIN tirocinio t ON r.idt = t.idt " +
                "JOIN studente s ON r.ids = s.ids " +
                "WHERE r.stato = 'InAttesa' AND t.nometirocinio=? " +
                "AND s.nome=? AND s.cognome=?";
                String sqlU = "UPDATE \"richiesta\" SET \"stato\"=? WHERE \"idr\"=?";
                try(PreparedStatement verificaRichiestaPS=connessione.prepareStatement(sqlQ)) {
                    verificaRichiestaPS.setString(1, tirocinio);
                    verificaRichiestaPS.setString(2, nome);
                    verificaRichiestaPS.setString(3, cognome);
                    ResultSet rs = verificaRichiestaPS.executeQuery();
                    if (rs.next()) {
                        int idR = rs.getInt("idr");
                        try(PreparedStatement updateStatoPS = connessione.prepareStatement(sqlU)){
                        if(stato){
                            updateStatoPS.setString(1, "Approvata");
                        }else{
                            updateStatoPS.setString(1, "Rifiutata");
                        }
                        updateStatoPS.setInt(2, idR);
                        updateStatoPS.executeUpdate();
                        updateStatoPS.close();
                        return true;
                    }}
                }return false;
    }
}
