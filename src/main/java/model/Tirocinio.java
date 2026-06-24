package model;
import java.util.*;

/**
 * La classe Tirocinio.
 * Rappresenta un tirocinio a cui gli studenti si possono iscrivere.
 */
public class Tirocinio {
    /**
     * Rappresenta il nome del tirocinio.
     */
    private String nomeTirocinio;
    /**
     * Rappresenta l'ente che idea il tirocinio.
     */
    private Ente enteTirocinio;
    /**
     * Informa se il tirocinio e' disponibile.
     */
    private boolean disponibile;
    /**
     * Informa se il tirocinio e' incominciato.
     */
    private boolean inCorso;
    /**
     * Rappresentano tutti gli studenti che si sono iscritti al triocinio
     */
    private ArrayList<Studente> studenti=new ArrayList();


    /**
     * Costruttore della classe Tirocinio.
     *
     * @param nomeTirocinio il nome tirocinio
     * @param enteTirocinio l'ente tirocinio
     * @param disponibile   la disponibilita'
     * @param inCorso       se il tirocinio e' gia' incominciato
     */
    public Tirocinio(String nomeTirocinio, Ente enteTirocinio, boolean disponibile, boolean inCorso) {
        this.nomeTirocinio=nomeTirocinio;
        this.enteTirocinio=enteTirocinio;
        this.disponibile=disponibile;
        this.inCorso=inCorso;
    }

    /**
     * Aggiungie uno studente al tirocinio.
     *
     * @param studenti lo studenti aggiunto al tirocinio
     */
    public void aggiungiStudente(Studente studenti){
        this.studenti.add(studenti);
    }

    /**
     * Stampa tutti i nomi degli studenti iscritti al tirocinio.
     */
    public void vediStudenti() {
        for(Studente s: studenti){
            System.out.println(s.getNomeStudenete());
        }

    }

    /**
     * Ottiene il nome tirocinio.
     *
     * @return il nome del tirocinio
     */
    public String getNomeTirocinio(){
        return this.nomeTirocinio;
    }

    /**
     * Ottiene se il tirocinio e' incominciato.
     *
     * @return se il tirocinio e' incominciato
     */
    public boolean getInCorsoTirocinio(){
        return this.inCorso;
    }

    /**
     * Ottiene l'ente del tirocinio.
     *
     * @return l'ente del tirocinio
     */
    public Ente getEnteTirocinio(){
        return this.enteTirocinio;
    }

    /**
     * Ottiene la disponibilita' del tirocinio.
     *
     * @return la disponibilita' del tirocinio
     */
    public boolean getDisponibileTirocinio(){
        return this.disponibile;
    }
}
