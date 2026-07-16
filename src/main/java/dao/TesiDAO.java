package dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * La classe TesiDAO.
 * Essa e' una classe astratta.
 */
public interface TesiDAO{

    /**
     * Salva la tesi all'interno del database.
     *
     * @param titolo il titolo della tesi
     * @param testo il testo della tesi
     * @param idS l'identificativo dello studente
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public void salvaTesi(String titolo, String testo, int idS)throws SQLException;

    /**
     * Cambia il valore di caricata in true.
     *
     * @param idS l'identificativo dello studente
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public void caricaTesi(int idS) throws SQLException;

    /**
     * Verifica se gia' esiste una tesi per un determinato studente.
     *
     * @param idS l'identificativo dello studente
     * @return informa se gia' esiste una tesi per il rispettivo studente
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public ArrayList<Object> notNullTesi(int idS) throws SQLException;
}
