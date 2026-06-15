package model;
import java.util.ArrayList;

/**
 * The type Utente.
 */
public class Utente {
    /**
     * The Nome.
     */
    protected String nome;
    /**
     * The Cognome.
     */
    protected String cognome;
    /**
     * The Email.
     */
    protected String email;
    /**
     * The Login.
     */
    protected String login;
    /**
     * The Password.
     */
    protected String password;

    /**
     * Instantiates a new Utente.
     *
     * @param nome     the nome
     * @param cognome  the cognome
     * @param email    the email
     * @param login    the login
     * @param password the password
     */
    public Utente(String nome, String cognome, String email, String login, String password) {
        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
        this.login = login;
        this.password = password;
    }

    /**
     * Login boolean.
     *
     * @param login    the login
     * @param password the password
     * @return the boolean
     */
    public boolean login(String login, String password) {
        return ( login.equals(this.login) && password.equals(this.password));
    }

    /**
     * Get nome utente string.
     *
     * @return the string
     */
    public String getNomeUtente(){
        return this.nome;
    }

    /**
     * Get cognome utente string.
     *
     * @return the string
     */
    public String getCognomeUtente(){
        return this.cognome;
    }
}
