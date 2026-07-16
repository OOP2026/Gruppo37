package implementazioneDao;

import dao.DocenteDAO;
import database_connection.ConnessioneDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * La classe DocenteImplementazionePostgresDAO.
 * Gestidce i dati da passare al databse per conto del docente.
 */
public class DocenteImplementazionePostgresDAO implements DocenteDAO {
    private Connection connessione;

    /**
     * Costruttore della classe DocenteImplementazionePostgresDAO.
     */
    public DocenteImplementazionePostgresDAO() {
        try {
            connessione = ConnessioneDatabase.getInstance().connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
    @Override
    public void aggiungiDocente(String nome, String cognome, String email, String login, String password) throws SQLException {
        String sql = "INSERT INTO \"docente\" (\"nome\", \"cognome\", \"email\", \"login\", \"password\", " +
                      "\"argomentotirocinio\") VALUES (?,?,?,?,?,?);";
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

    /**
     * Accede ad un docente del databse.
     *
     * @param login il login del docente
     * @param password la password del docente
     * @return le informazioni per esguire l'accesso del docente anche nel model
     * @throws SQLException e' un errore che si verifica tramite un errato accesso al databse
     */
    public ArrayList<Object> accediDocente(String login, String password) throws SQLException {
        String sql="SELECT \"idd\",\"nome\",\"cognome\",\"email\",\"login\", \"password\", \"argomentotirocinio\" FROM \"docente\" WHERE \"login\"=? AND \"password\"=?";
        try(PreparedStatement accediStudentePS=connessione.prepareStatement(sql)) {
            accediStudentePS.setString(1, login);
            accediStudentePS.setString(2, password);
            ResultSet rs=accediStudentePS.executeQuery();

            if(rs.next()){
                ArrayList<Object> info=new ArrayList();
                info.add(rs.getInt("idd"));
                info.add(rs.getString("nome"));
                info.add(rs.getString("cognome"));
                info.add(rs.getString("email"));
                info.add(rs.getString("login"));
                info.add(rs.getString("password"));
                info.add(rs.getString("argomentotirocinio"));
                return info;}
            return null;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
