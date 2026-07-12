package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TesiDAO{
    public void salvaTesi(String titolo, String testo, String nomeS)throws SQLException;
    public void caricaTesi(String nomeS) throws SQLException;
}
