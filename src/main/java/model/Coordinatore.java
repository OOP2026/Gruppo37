package model;
import java.util.*;

/**
 * The type Coordinatore.
 */
public class Coordinatore extends Docente{

    /**
     * Instantiates a new Coordinatore.
     *
     * @param nome                     the nome
     * @param cognome                  the cognome
     * @param email                    the email
     * @param login                    the login
     * @param password                 the password
     * @param elencoArgomentiTirocinio the elenco argomenti tirocinio
     */
    public Coordinatore(String nome, String cognome, String email, String login, String password, String elencoArgomentiTirocinio){
        super(nome,cognome,email,login,password,elencoArgomentiTirocinio);
    }
}
