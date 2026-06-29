package dao;

import java.sql.SQLException;

public interface StudenteDAO {
    public void aggiungiStudente(String nome,String cognome,String email,String login,String password) throws SQLException;
}
