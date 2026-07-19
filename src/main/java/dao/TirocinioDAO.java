package dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * La classe TirocinioDAO.
 * Essa e' una classe astratta.
 */
public interface TirocinioDAO {

    /**
     * Crea un nuovo tirocinio all'interno del database.
     *
     * @param idD l'identificativo del docente
     * @param nome il nome del tirocinio
     * @param ente l'ente che amministra il tirocinio
     * @param idA l'identificativo dell'azienda
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public void creaTirocinio(int idD, String nome, boolean ente, int idA)throws SQLException;

    /**
     * Ottiene i nomi di tutti i tirocini.
     *
     * @param idD l'identificativo del docente
     * @return un array list contenente tutti i nomi dei tirocini
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public ArrayList<String> getNomeTirocinio(int idD) throws SQLException;

    /**
     * Ottiene gli enti di tutti i tirocini.
     *
     * @param idD l'identificativo del docente
     * @return un array list contenente tutti gli enti dei tirocini
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public ArrayList<String> getEnte(int idD) throws SQLException;

    /**
     * Ottiene le disponibilita' di tutti i tirocini.
     *
     * @param idD l'identificativo del docente
     * @return un array list contenente tutte le disponibilita' dei tirocini
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public ArrayList<Boolean> getDisponibile(int idD) throws SQLException;

    /**
     * Ottiene le informazioni sullo svolgimento di tutti i tirocini.
     *
     * @param idD l'identificativo del docente
     * @return un array list contenente tutte le informazioni sullo svolgimento dei tirocini
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public ArrayList<Boolean> getInCorso(int idD) throws SQLException;

    /**
     * Verifica se esiste un determinato tirocinio.
     *
     * @param nome il nome del tirocinio
     * @return informa se esiste il tirocinio
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public ArrayList<Integer> verificaNomeTirocinio(String nome) throws SQLException;
}
