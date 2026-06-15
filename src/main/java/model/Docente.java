package model;
import java.util.*;

/**
 * The type Docente.
 */
public class Docente extends Utente{
    /**
     * The Argomento tirocinio.
     */
    protected String argomentoTirocinio;
    /**
     * The Tirocini.
     */
    protected ArrayList<Tirocinio> tirocini= new ArrayList();

    /**
     * Instantiates a new Docente.
     *
     * @param nome               the nome
     * @param cognome            the cognome
     * @param email              the email
     * @param login              the login
     * @param password           the password
     * @param argomentoTirocinio the argomento tirocinio
     */
    public Docente(String nome, String cognome, String email, String login,
                   String password, String argomentoTirocinio){
        super(nome,cognome,email,login,password);
        this.argomentoTirocinio=argomentoTirocinio;
    }

    /**
     * Crea tirocinio.
     *
     * @param nomeTirocinio   the nome tirocinio
     * @param spazioTirocinio the spazio tirocinio
     * @param disponibile     the disponibile
     * @param inCorso         the in corso
     */
    public void creaTirocinio(String nomeTirocinio, Ente spazioTirocinio, boolean disponibile, boolean inCorso){
        Tirocinio t= new Tirocinio(nomeTirocinio, spazioTirocinio, disponibile,  inCorso);
        tirocini.add(t);
    }

    /**
     * Visualizza.
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
     * Approva richiesta.
     *
     * @param r the r
     */
    public void approvaRichiesta(Richiesta r){
        r.approva();
    }

    /**
     * Rifiuta richiesta.
     *
     * @param r the r
     */
    public void rifiutaRichiesta(Richiesta r){
        r.rifiuta();
    }

    /**
     * Approva tesi.
     *
     * @param t the t
     */
    public void approvaTesi(Tesi t){
        t.approva();
    }

    /**
     * Rifiuta tesi.
     *
     * @param t the t
     */
    public void rifiutaTesi(Tesi t){t.rifiuta();}
}
