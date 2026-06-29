package dao;

import java.sql.SQLException;

public interface DocenteDAO {
    public void aggiungiDocente(String nome,String cognome,String email,String login,String password)throws SQLException;
}
