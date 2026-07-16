package dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * La classe StudenteDAO.
 * Essa e' una classe astratta.
 */
public interface StudenteDAO {

    /**
     * Crea un nuovo studente all'interno del database.
     *
     * @param nome il nome dello studente
     * @param cognome il cognome dello studente
     * @param email l'email dello studente
     * @param login il login dello studente
     * @param password la password dello studente
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public void aggiungiStudente(String nome,String cognome,String email,String login,String password) throws SQLException;

    /**
     * Accede ad uno studente del databse.
     *
     * @param login il login dello studente
     * @param password la password dello studente
     * @return le informazioni per esguire l'accesso dello studente anche nel model
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public ArrayList<Object> accediStudente(String login, String password) throws SQLException;

    /**
     * Aggiunge una seduta di laurea nei dati dello studente.
     *
     * @param idS l'identificativo dello studente
     * @param idSeduta l'identificativo della seduta di laurea
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public void aggiungiSeduta(int idS, int idSeduta) throws SQLException;
}
