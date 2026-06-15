package model;
import java.util.*;

/**
 * The type Richiesta.
 */
public class Richiesta {
    private Stato stato;
    private Date dataRichiesta;
    private Tirocinio tirocinio;
    private Studente studente;
    private Docente docente;

    /**
     * Instantiates a new Richiesta.
     *
     * @param dataRichiesta the data richiesta
     * @param tirocinio     the tirocinio
     * @param studente      the studente
     * @param docente       the docente
     */
    public Richiesta(Date dataRichiesta, Tirocinio tirocinio, Studente studente, Docente docente) {
        this.stato=Stato.InAttesa;
        this.dataRichiesta=dataRichiesta;
        this.tirocinio=tirocinio;
        this.studente=studente;
        this.docente=docente;
    }

    /**
     * Aggiungi tircoinio.
     *
     * @param t the t
     */
    public void aggiungiTircoinio(Tirocinio t){
        this.tirocinio=t;
    }

    /**
     * Aggiungi studente.
     *
     * @param s the s
     */
    public void aggiungiStudente(Studente s){
        this.studente=s;
    }

    /**
     * Aggiungi docente.
     *
     * @param d the d
     */
    public void aggiungiDocente(Docente d){
        this.docente=d;
    }

    /**
     * Approva.
     */
    public void approva() {this.stato=Stato.Approvata;}

    /**
     * Rifiuta.
     */
    public void rifiuta(){
        this.stato=Stato.Rifiutata;
    }

    /**
     * Gets stato.
     *
     * @return the stato
     */
    public Stato getStato() {
        return stato;
    }

    /**
     * Get tirocinio tirocinio.
     *
     * @return the tirocinio
     */
    public Tirocinio getTirocinio(){
        return tirocinio;
    }

    /**
     * Get studente studente.
     *
     * @return the studente
     */
    public Studente getStudente(){
        return studente;
    }
}
