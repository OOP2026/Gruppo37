package model;
import java.util.ArrayList;

/**
 * La classe Utente.
 * Rappresenta un'utente del sistema.
 */
public class Utente {
    /**
     * Rappresenta il nome dello studente.
     */
    protected String nome;
    /**
     * Rappresenta il cognome dello studente.
     */
    protected String cognome;
    /**
     * Rappresenta l'email dello studente.
     */
    protected String email;
    /**
     * Rappresenta il login dello studente.
     */
    protected String login;
    /**
     * Rappresenta la password dello studente.
     */
    protected String password;

    /**
     * Costruttore della classe Utente.
     *
     * @param nome     il nome dell'utente
     * @param cognome  il cognome dell'utente
     * @param email    l'email dell'utente
     * @param login    il login dell'utente
     * @param password la password dell'utente
     */
    public Utente(String nome, String cognome, String email, String login, String password) {
        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
        this.login = login;
        this.password = password;
    }

    /**
     * Permette ad un utente di entrare nel sistema.
     *
     * @param login    il login dell'utente
     * @param password la password dell'utente
     * @return informa se l'accesso e' avvenuto con successo
     */
    public boolean login(String login, String password) {
        return ( login.equals(this.login) && password.equals(this.password));
    }

    /**
     * Ottiene il nome dell'utente.
     *
     * @return il nome dello studente
     */
    public String getNomeUtente(){
        return this.nome;
    }

    /**
     * Ottiene il cognome dell'utente.
     *
     * @return il cognome dell'utente
     */
    public String getCognomeUtente(){
        return this.cognome;
    }
}
