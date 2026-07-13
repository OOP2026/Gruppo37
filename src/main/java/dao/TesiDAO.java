package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TesiDAO{
    public void salvaTesi(String titolo, String testo, int idS)throws SQLException;
    public void caricaTesi(int idS) throws SQLException;
    public ArrayList<Object> notNullTesi(int idS) throws SQLException;
}
