package dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * La classe DocenteDAO.
 * Essa e' una classe astratta.
 */
public interface DocenteDAO {

    /**
     * Crea un nuovo docente all'interno del database.
     *
     * @param nome il nome del docente
     * @param cognome il cognome del docente
     * @param email l'email del docente
     * @param login il login del docente
     * @param password la password del docente
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public void aggiungiDocente(String nome,String cognome,String email,String login,String password)throws SQLException;

    /**
     * Accede ad un docente del databse.
     *
     * @param login il login del docente
     * @param password la password del docente
     * @return le informazioni per esguire l'accesso del docente anche nel model
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public ArrayList<Object> accediDocente(String login, String password) throws SQLException;
}
