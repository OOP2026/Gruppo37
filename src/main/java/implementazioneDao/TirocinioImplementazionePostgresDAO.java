package implementazioneDao;

import dao.TirocinioDAO;
import database_connection.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * La classe TirocinioImplementazionePostgresDAO.
 * Gestidce i dati da passare al databse per conto del tirocinio.
 * E' implementata dalla calsse TirocinioDAO.
 */
public class TirocinioImplementazionePostgresDAO implements TirocinioDAO{
    private Connection connessione;

    /**
     * Costruttore della classe TirocinioImplementazionePostgresDAO.
     */
    public TirocinioImplementazionePostgresDAO() {
        try {
            connessione = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea un nuovo tirocinio all'interno del database.
     *
     * @param idD l'identificativo del docente
     * @param nome il nome del tirocinio
     * @param ente l'ente che amministra il tirocinio
     * @param idA l'identificativo dell'azienda
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public void creaTirocinio(int idD, String nome, boolean ente, int idA) throws SQLException{
        String sql="INSERT INTO \"tirocinio\" (\"idd\",\"nometirocinio\", \"ente\", \"disponibile\", \"incorso\", \"ida\") " +
                "VALUES (?,?,?,?,?,?);";
        try (PreparedStatement aggiungiTirocinioPS=connessione.prepareStatement(sql)){
            aggiungiTirocinioPS.setInt(1,idD);
            aggiungiTirocinioPS.setString(2,nome);
            if (ente) {
                aggiungiTirocinioPS.setString(3,"Interno");
                aggiungiTirocinioPS.setNull(6,java.sql.Types.INTEGER);
            }else {
                aggiungiTirocinioPS.setString(3,"Esterno" );
                aggiungiTirocinioPS.setInt(6,idA);
            }
            aggiungiTirocinioPS.setBoolean(4,true);
            aggiungiTirocinioPS.setBoolean(5,false);

            aggiungiTirocinioPS.executeUpdate();
            aggiungiTirocinioPS.close();
        }
    }

    /**
     * Ottiene i nomi di tutti i tirocini.
     *
     * @param idD l'identificativo del docente
     * @return un array list contenente tutti i nomi dei tirocini
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public ArrayList<String> getNomeTirocinio(int idD) throws SQLException{
        ArrayList<String> tirocinio=new ArrayList<>();
        if (idD == 0) {
            String sql = "SELECT \"nometirocinio\" FROM \"tirocinio\"";
            try (PreparedStatement aggiungiTirocinioPS = connessione.prepareStatement(sql)) {
                ResultSet rs = aggiungiTirocinioPS.executeQuery();
                while (rs.next()) {
                    tirocinio.add(rs.getString("nometirocinio"));
                }
            }
        } else {
            String sql = "SELECT \"nometirocinio\" FROM \"tirocinio\" WHERE idd=?";
            try (PreparedStatement aggiungiTirocinioPS = connessione.prepareStatement(sql)) {
                aggiungiTirocinioPS.setInt(1, idD);
                ResultSet rs = aggiungiTirocinioPS.executeQuery();
                while (rs.next()) {
                    tirocinio.add(rs.getString("nometirocinio"));
                }
            }
        }
        return tirocinio;
    }

    /**
     * Ottiene gli enti di tutti i tirocini.
     *
     * @param idD l'identificativo del docente
     * @return un array list contenente tutti gli enti dei tirocini
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public ArrayList<String> getEnte(int idD) throws SQLException {
        ArrayList<String> tirocinio=new ArrayList<>();
        if (idD == 0) {
            String sql = "SELECT \"ente\" FROM \"tirocinio\"";
            try (PreparedStatement aggiungiTirocinioPS = connessione.prepareStatement(sql)) {
                ResultSet rs = aggiungiTirocinioPS.executeQuery();
                while (rs.next()) {
                    tirocinio.add(rs.getString("ente"));
                }
            }
        } else {
            String sql = "SELECT \"ente\" FROM \"tirocinio\" WHERE idd=?";
            try (PreparedStatement aggiungiTirocinioPS = connessione.prepareStatement(sql)) {
                aggiungiTirocinioPS.setInt(1, idD);
                ResultSet rs = aggiungiTirocinioPS.executeQuery();
                while (rs.next()) {
                    tirocinio.add(rs.getString("ente"));
                }
            }
        }
        return tirocinio;
    }

    /**
     * Ottiene le disponibilita' di tutti i tirocini.
     *
     * @param idD l'identificativo del docente
     * @return un array list contenente tutte le disponibilita' dei tirocini
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public ArrayList<Boolean> getDisponibile(int idD) throws SQLException{
        ArrayList<Boolean> tirocinio=new ArrayList<>();
        if (idD == 0) {
            String sql = "SELECT \"disponibile\" FROM \"tirocinio\"";
            try (PreparedStatement aggiungiTirocinioPS = connessione.prepareStatement(sql)) {
                ResultSet rs = aggiungiTirocinioPS.executeQuery();
                while (rs.next()) {
                    tirocinio.add(rs.getBoolean("disponibile"));
                }
            }
        } else {
            String sql = "SELECT \"disponibile\" FROM \"tirocinio\" WHERE idd=?";
            try (PreparedStatement aggiungiTirocinioPS = connessione.prepareStatement(sql)) {
                aggiungiTirocinioPS.setInt(1, idD);
                ResultSet rs = aggiungiTirocinioPS.executeQuery();
                while (rs.next()) {
                    tirocinio.add(rs.getBoolean("disponibile"));
                }
            }
        }
        return tirocinio;
    }

    /**
     * Ottiene le informazioni sullo svolgimento di tutti i tirocini.
     *
     * @param idD l'identificativo del docente
     * @return un array list contenente tutte le informazioni sullo svolgimento dei tirocini
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public ArrayList<Boolean> getInCorso(int idD) throws SQLException{
        ArrayList<Boolean> tirocinio=new ArrayList<>();
        if (idD == 0) {
            String sql = "SELECT \"incorso\" FROM \"tirocinio\"";
            try (PreparedStatement aggiungiTirocinioPS = connessione.prepareStatement(sql)) {
                ResultSet rs = aggiungiTirocinioPS.executeQuery();
                while (rs.next()) {
                    tirocinio.add(rs.getBoolean("incorso"));
                }
            }
        } else {
            String sql = "SELECT \"incorso\" FROM \"tirocinio\" WHERE idd=?";
            try (PreparedStatement aggiungiTirocinioPS = connessione.prepareStatement(sql)) {
                aggiungiTirocinioPS.setInt(1, idD);
                ResultSet rs = aggiungiTirocinioPS.executeQuery();
                while (rs.next()) {
                    tirocinio.add(rs.getBoolean("incorso"));
                }
            }
        }
        return tirocinio;
    }

    /**
     * Verifica se esiste un determinato tirocinio.
     *
     * @param nome il nome del tirocinio
     * @return informa se esiste il tirocinio
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public ArrayList<Integer> verificaNomeTirocinio(String nome) throws SQLException{
        String sql="SELECT \"idd\", \"idt\" FROM \"tirocinio\" WHERE \"nometirocinio\"=? AND \"disponibile\"=true";
        try(PreparedStatement verificaTirocinioPS=connessione.prepareStatement(sql)){;
            verificaTirocinioPS.setString(1, nome);
            ResultSet rs=verificaTirocinioPS.executeQuery();
            if(rs.next()){
                ArrayList<Integer> info =new ArrayList<>();
                info.add(rs.getInt("idd"));
                info.add(rs.getInt("idt"));
                return info;
            } return null;
        }
    }

    public ArrayList<Object> recuperaInfo(int idD) throws SQLException{
        String sql = "SELECT nometirocinio, ente, disponibile, incorso, ids " +
                " FROM tirocinio t JOIN richiesta r ON t.idt=r.idt " +
                " WHERE t.idd=? AND r.stato='Approvata' ";
        try(PreparedStatement recupeaInfoPS=connessione.prepareStatement(sql)){
            recupeaInfoPS.setInt(1, idD);
            ResultSet rs = recupeaInfoPS.executeQuery();
            ArrayList<Object> info=new ArrayList<>();
            while (rs.next()) {
                info.add(rs.getString("nometirocinio"));
                info.add(rs.getString("ente"));
                info.add(rs.getBoolean("disponibile"));
                info.add(rs.getBoolean("incorso"));
                info.add(rs.getInt("ids"));
            }
            return info;
        }
    }
}
