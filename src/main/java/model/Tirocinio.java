package model;
import java.util.*;

/**
 * The type Tirocinio.
 */
public class Tirocinio {
    private String nomeTirocinio;
    private Ente enteTirocinio;
    private boolean disponibile;
    private boolean inCorso;
    private ArrayList<Studente> studenti=new ArrayList();


    /**
     * Instantiates a new Tirocinio.
     *
     * @param nomeTirocinio the nome tirocinio
     * @param enteTirocinio the ente tirocinio
     * @param disponibile   the disponibile
     * @param inCorso       the in corso
     */
    public Tirocinio(String nomeTirocinio, Ente enteTirocinio, boolean disponibile, boolean inCorso) {
        this.nomeTirocinio=nomeTirocinio;
        this.enteTirocinio=enteTirocinio;
        this.disponibile=disponibile;
        this.inCorso=inCorso;
    }

    /**
     * Aggiungi studente.
     *
     * @param studenti the studenti
     */
    public void aggiungiStudente(Studente studenti){
        this.studenti.add(studenti);
    }

    /**
     * Vedi studenti.
     */
    public void vediStudenti() {
        for(Studente s: studenti){
            System.out.println(s.getNomeStudenete());
        }

    }

    /**
     * Get nome tirocinio string.
     *
     * @return the string
     */
    public String getNomeTirocinio(){
        return this.nomeTirocinio;
    }

    /**
     * Get in corso tirocinio boolean.
     *
     * @return the boolean
     */
    public boolean getInCorsoTirocinio(){
        return this.inCorso;
    }

    /**
     * Get ente tirocinio ente.
     *
     * @return the ente
     */
    public Ente getEnteTirocinio(){
        return this.enteTirocinio;
    }

    /**
     * Get disponibile tirocinio boolean.
     *
     * @return the boolean
     */
    public boolean getDisponibileTirocinio(){
        return this.disponibile;
    }
}
