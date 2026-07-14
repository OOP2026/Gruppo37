package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RichiestaDAO {
    public void creaRichiesta(int idT, int idS, int idD)throws SQLException;
    public ArrayList<String> getStudenteETirocinio(int idD) throws SQLException;
    public boolean verificaRichiesta(String nome,String cognome,String tirocinio, boolean stato) throws SQLException;
}
