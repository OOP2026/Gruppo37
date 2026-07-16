package dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * La classe SedutaLaureaDAO.
 * Essa e' una classe astratta.
 */
public interface SedutaLaureaDAO {

    /**
     * Verifica se esiste la seduta di laurea.
     *
     * @param data la data della seduta di laurea
     * @param luogo il luogo della seduta di laurea
     * @return informa se esiste la seduta di laurea
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public int verificaSeduta(String data,String luogo) throws SQLException;

    /**
     * Ottiene i luoghi di tutte le sedute di laurea.
     *
     * @return tutti i luoghi dove avvengono le sedute di laurea
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public ArrayList<String> getLuogoSeduta() throws SQLException;

    /**
     * Ottiene le date di tutte le sedute di laurea.
     *
     * @return tutte le date dove avvengono le sedute di laurea
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public ArrayList<Object> getDataSeduta() throws SQLException;

    /**
     * Accede ad una seduta del databse.
     *
     * @param idS l'identificativo della seduta di laurea
     * @return le informazioni per esguire l'accesso della seduta di laurea anche nel model
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public ArrayList<String> accediSeduta(int idS) throws SQLException;
}
