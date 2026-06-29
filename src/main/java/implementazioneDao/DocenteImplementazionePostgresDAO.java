package implementazioneDao;

import dao.DocenteDAO;
import database_connection.ConnessioneDatabase;
import org.postgresql.core.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocenteImplementazionePostgresDAO implements DocenteDAO {
    private Connection connessione;

    public DocenteImplementazionePostgresDAO() {
        try {
            connessione = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void aggiungiDocente(String nome, String cognome, String email, String login, String password) throws SQLException {
        String sql = "INSERT INTO \"Docente\" (\"Nome\", \"Cognome\", \"Email\", \"Login\", \"Password\", \"argomentoTirocinio\") VALUES (?,?,?,?,?,?);";
        try (PreparedStatement aggiungiDocentePS = connessione.prepareStatement(sql)) {
            aggiungiDocentePS.setString(1, nome);
            aggiungiDocentePS.setString(2, cognome);
            aggiungiDocentePS.setString(3, email);
            aggiungiDocentePS.setString(4, login);
            aggiungiDocentePS.setString(5, password);
            aggiungiDocentePS.setString(6, null);

            aggiungiDocentePS.executeUpdate();
            aggiungiDocentePS.close();
        }
    }
}
