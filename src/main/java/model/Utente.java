package model;

import java.util.ArrayList;

public class Utente {
    private String nome;
    private String cognome;
    private String email;
    private String login;
    private String password;

    public Utente(String nome, String cognome, String email, String login, String password) {
        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
        this.login = login;
        this.password = password;
    }

    public boolean login(String login, String password) {
        return ( login.equals(this.login) && password.equals(this.password));
    }
}
