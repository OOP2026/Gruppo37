package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DocenteDAO {
    public void aggiungiDocente(String nome,String cognome,String email,String login,String password)throws SQLException;
    public ArrayList<Object> accediDocente(String login, String password) throws SQLException;
}
