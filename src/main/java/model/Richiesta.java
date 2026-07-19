package model;
import java.util.*;

/**
 * La classe Richiesta.
 * Rappresenta una richiesta ricevuta da un docente, inviata da uno studente per un determinato tirocinio.
 */
public class Richiesta {
    /**
     * Rappresenta lo stato della richiesta.
     */
    private Stato stato;
    /**
     * Rappresenta la data quando e' stata inviata la richiesta.
     */
    private Date dataRichiesta;
    /**
     * Rappresenta il tirocinio al quale lo studente si riferisce.
     */
    private Tirocinio tirocinio;
    /**
     * Rappresenta lo studente che invia la richiesta
     */
    private Studente studente;
    /**
     * Rappresenta il docente che riceve la richiesta
     */
    private Docente docente;

    /**
     * Costruttore della classe Richiesta.
     *
     * @param dataRichiesta la data di invio richiesta
     * @param tirocinio     il tirocinio a cui si riferisce la richiesta
     * @param studente      lo studente a cui si riferisce la richiesta
     * @param docente       il docente a cui si riferisce la richiesta
     */
    public Richiesta(Date dataRichiesta, Tirocinio tirocinio, Studente studente, Docente docente) {
        this.stato=Stato.InAttesa;
        this.dataRichiesta=dataRichiesta;
        this.tirocinio=tirocinio;
        this.studente=studente;
        this.docente=docente;
    }

    public Richiesta(Date dataRichiesta, Stato stato) {
        this.stato=stato;
        this.dataRichiesta=dataRichiesta;
    }
    /**
     * Aggiungie un tircoinio alla richiesta.
     *
     * @param t il tirocinio che deve essere aggiunto alla richiesta
     */
    public void aggiungiTircoinio(Tirocinio t){
        this.tirocinio=t;
    }

    /**
     * Aggiungie uno studente alla richiesta.
     *
     * @param s lo studente che deve essere aggiunto alla richiesta
     */
    public void aggiungiStudente(Studente s){
        this.studente=s;
    }

    /**
     * Aggiungie un docente alla richiesta.
     *
     * @param d il docente che deve essere aggiunto alla richiesta
     */
    public void aggiungiDocente(Docente d){
        this.docente=d;
    }

    /**
     * Approva la richiesta.
     */
    public void approva() {this.stato=Stato.Approvata;}

    /**
     * Rifiuta la richiesta.
     */
    public void rifiuta(){
        this.stato=Stato.Rifiutata;
    }

    /**
     * Ottiene lo stato della richiesta.
     *
     * @return lo stato della richiesta
     */
    public Stato getStato() {
        return stato;
    }

    /**
     * Ottiene il tirocinio della richiesta.
     *
     * @return il tirocinio della richiesta
     */
    public Tirocinio getTirocinio(){
        return tirocinio;
    }

    /**
     * Ottiene lo studente della richiesta.
     *
     * @return lo studente della richiesta
     */
    public Studente getStudente(){
        return studente;
    }
}
