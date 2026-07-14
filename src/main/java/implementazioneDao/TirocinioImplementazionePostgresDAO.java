package implementazioneDao;

import dao.TirocinioDAO;
import database_connection.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class TirocinioImplementazionePostgresDAO implements TirocinioDAO{
    private Connection connessione;

    public TirocinioImplementazionePostgresDAO() {
        try {
            connessione = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void creaTirocinio(int idD, String nome, boolean ente) throws SQLException{
        String sql="INSERT INTO \"tirocinio\" (\"idd\",\"nometirocinio\", \"ente\", \"disponibile\", \"incorso\") " +
                "VALUES (?,?,?,?,?);";
        try (PreparedStatement aggiungiTirocinioPS=connessione.prepareStatement(sql)){
            aggiungiTirocinioPS.setInt(1,idD);
            aggiungiTirocinioPS.setString(2,nome);
            if (ente) {
                aggiungiTirocinioPS.setString(3,"Interno" );
            }else {
                aggiungiTirocinioPS.setString(3,"Esterno" );
            }
            aggiungiTirocinioPS.setBoolean(4,true);
            aggiungiTirocinioPS.setBoolean(5,false);

            aggiungiTirocinioPS.executeUpdate();
            aggiungiTirocinioPS.close();
        }
    }

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

}
