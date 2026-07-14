package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SedutaLaureaDAO {
    public int verificaSeduta(String data,String luogo) throws SQLException;
    public ArrayList<String> getLuogoSeduta() throws SQLException;
    public ArrayList<String> getDataSeduta() throws SQLException;
}
