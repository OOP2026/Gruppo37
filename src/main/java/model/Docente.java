package model;
import java.util.*;

/**
 * La classe Docente.
 * Rappresenta un docente relatore di un corso di laurea.
 * Estende Utente.
 */
public class Docente extends Utente{
    /**
     * Rappresenta l'argomento di tirocinio richiesto dal docente.
     */
    protected String argomentoTirocinio;
    /**
     * Rappresenta tutti i tirocini che il docente ha ideato.
     */
    protected ArrayList<Tirocinio> tirocini= new ArrayList();

    /**
     * Costruttore della classe Docente.
     *
     * @param nome               il nome del docente
     * @param cognome            il cognome del docente
     * @param email              il email del docente
     * @param login              il login del docente
     * @param password           la password del docente
     * @param argomentoTirocinio l'argomento di tirocinio del docente
     */
    public Docente(String nome, String cognome, String email, String login,
                   String password, String argomentoTirocinio){
        super(nome,cognome,email,login,password);
        this.argomentoTirocinio=argomentoTirocinio;
    }

    /**
     * Crea un tirocinio ideato da un docente.
     *
     * @param nomeTirocinio   il nome del tirocinio
     * @param spazioTirocinio lo spazio dove viene svolto il tirocinio
     * @param disponibile     la disponibilita' del tirocinio
     */
    public void creaTirocinio(String nomeTirocinio, Ente spazioTirocinio, boolean disponibile){
        Tirocinio t= new Tirocinio(nomeTirocinio, spazioTirocinio, disponibile, false);
        tirocini.add(t);
    }

    /**
     * Stampa a video i tirocini che si stanno svolgendo.
     */
    public void visualizza(){
        for(Tirocinio t:tirocini){
            if(t.getInCorsoTirocinio()) {
                System.out.println(t.getNomeTirocinio());
                t.vediStudenti();
            }
        }
    }

    /**
     * Approva una richiesta.
     *
     * @param r la richiesta da apporvare
     */
    public void approvaRichiesta(Richiesta r){
        r.approva();
    }

    /**
     * Rifiuta una richiesta.
     *
     * @param r la richiesta da rifiutare
     */
    public void rifiutaRichiesta(Richiesta r){
        r.rifiuta();
    }

    /**
     * Approva una tesi.
     *
     * @param t la tesi da apporvare
     */
    public void approvaTesi(Tesi t){
        t.approva();
    }

    /**
     * Rifiuta una tesi.
     *
     * @param t la tesi da rifiutare
     */
    public void rifiutaTesi(Tesi t){t.rifiuta();}
}
