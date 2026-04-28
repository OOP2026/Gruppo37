package model;

public class Docente extends Utente{
    protected String elencoArgomentiTirocinio;

    public Docente(String nome, String cognome, String email, String login, String password, String elencoArgomentiTirocinio){
        super(nome,cognome,email,login,password);
        this.elencoArgomentiTirocinio=elencoArgomentiTirocinio;
    }

    public void visualizza(){}
}
