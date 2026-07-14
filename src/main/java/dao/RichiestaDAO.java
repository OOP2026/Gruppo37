package dao;

import java.sql.SQLException;

public interface RichiestaDAO {
    public void creaRichiesta(int idT, int idS, int idD)throws SQLException;
}
