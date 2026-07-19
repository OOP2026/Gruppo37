package dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * La classe RichiestaDAO.
 * Essa e' una classe astratta.
 */
public interface RichiestaDAO {

    /**
     * Crea una nuova richiesta all'interno del database.
     *
     * @param idT l'identificativo del tirocinio
     * @param idS l'identificativo dello studente
     * @param idD l'identificativo del docente
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public void creaRichiesta(int idT, int idS, int idD)throws SQLException;

    /**
     * Ottiene le informazioni dello studente e del tirocinio delle varie richieste.
     *
     * @param idD l'identificativo del docente
     * @return le informazioni per ricavare lo studente e il tirocinio
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public ArrayList<String> getStudenteETirocinio(int idD) throws SQLException;

    /**
     * Verifica se esiste la richiesta.
     *
     * @param nome il nome dello studente
     * @param cognome il cognome dello studente
     * @param tirocinio il nome del tirocinio
     * @param stato lo stato della richiesta
     * @return informa se la richiesta esiste
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public boolean verificaRichiesta(String nome,String cognome,String tirocinio, boolean stato) throws SQLException;

    public ArrayList<Object> accediRichiesta(int idS) throws SQLException;
}
