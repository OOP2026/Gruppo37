package model;
import java.util.*;

/**
 * La classe Coordinatore.
 * Rappresenta un coordinatore del corso di laurea.
 * Estende Docente.
 */
public class Coordinatore extends Docente{

    /**
     * Costruttore della classe Coordinatore.
     *
     * @param nome                     il nome del coordinatore
     * @param cognome                  il cognome del coordinatore
     * @param email                    l'email del coordinatore
     * @param login                    il login del coordinatore
     * @param password                 la password del coordinatore
     * @param argomentiTirocinio       l'argomenti di tirocinio del coordinatore
     */
    public Coordinatore(String nome, String cognome, String email, String login, String password, String argomentiTirocinio){
        super(nome,cognome,email,login,password,argomentiTirocinio);
    }
}
