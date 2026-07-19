package dao;

import java.sql.SQLException;

/**
 * La classe AziendaDAO.
 * Essa e' una classe astratta.
 */
public interface AziendaDAO {

    /**
     * Verifica se esiste l'azienda.
     *
     * @param idA l'identificativo dell'azienda
     * @return stabilisce se esiste l'azienda
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public boolean verificaAzienda(int idA) throws SQLException;
}
