package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudenteDAO {
    public void aggiungiStudente(String nome,String cognome,String email,String login,String password) throws SQLException;
    public ArrayList<Object> accediStudente(String login, String password) throws SQLException;
}
