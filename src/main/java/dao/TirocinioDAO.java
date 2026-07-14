package dao;

import model.Tirocinio;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TirocinioDAO {
    public void creaTirocinio(int idD, String nome, boolean ente)throws SQLException;
    public ArrayList<String> getNomeTirocinio() throws SQLException;
    public ArrayList<String> getEnte() throws SQLException;
    public ArrayList<Boolean> getDisponibile() throws SQLException;
    public ArrayList<Boolean> getInCorso() throws SQLException;
    public ArrayList<Integer> verificaNomeTirocinio(String nome) throws SQLException;
}
