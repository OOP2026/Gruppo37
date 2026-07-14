package dao;

import model.Tirocinio;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TirocinioDAO {
    public void creaTirocinio(int idD, String nome, boolean ente)throws SQLException;
    public ArrayList<String> getNomeTirocinio(int idD) throws SQLException;
    public ArrayList<String> getEnte(int idD) throws SQLException;
    public ArrayList<Boolean> getDisponibile(int idD) throws SQLException;
    public ArrayList<Boolean> getInCorso(int idD) throws SQLException;
    public ArrayList<Integer> verificaNomeTirocinio(String nome) throws SQLException;
}
