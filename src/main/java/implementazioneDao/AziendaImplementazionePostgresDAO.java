package implementazioneDao;

import database_connection.ConnessioneDatabase;

import dao.AziendaDAO;
import database_connection.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * La classe AziendaImplementazionePostgresDAO.
 * Gestidce i dati da passare al databse per conto dell'azienda.
 * E' implementata dalla calsse AziendaDAO.
 */

public class AziendaImplementazionePostgresDAO implements AziendaDAO {
    private Connection connessione;

    /**
     * Costruttore della classe AziendaImplementazionePostgresDAO.
     */
    public AziendaImplementazionePostgresDAO() {
        try {
            connessione = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifica se esiste l'azienda.
     *
     * @param idA l'identificativo dell'azienda
     * @return stabilisce se esiste l'azienda
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public boolean verificaAzienda(int idA) throws SQLException{
        String query = "SELECT 1 FROM \"azienda\" WHERE \"ida\" = ?";
        PreparedStatement verificaAzienda = connessione.prepareStatement(query);
        verificaAzienda.setInt(1,idA);
        ResultSet rs = verificaAzienda.executeQuery();
        if(rs.next()){
            return true;
        }
        return false;
    }
}
