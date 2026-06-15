package model;

import java.util.*;

/**
 * The type Tesi.
 */
public class Tesi {
    private String titolo;
    private String testo;
    private Stato stato;
    private boolean caricata;
    private Studente studente;
    private Docente docente;

    /**
     * Instantiates a new Tesi.
     *
     * @param titolo   the titolo
     * @param testo    the testo
     * @param caricata the caricata
     */
    public Tesi(String titolo,String testo, boolean caricata){
        this.titolo = titolo;
        this.testo = testo;
        this.stato = Stato.InAttesa;
        this.caricata=caricata;
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
    public void approva() {
        this.stato=Stato.Approvata;
    }

    /**
     * Rifiuta.
     */
    public void rifiuta(){

        this.stato=Stato.Rifiutata;
    }

    /**
     * Gets titolo.
     *
     * @return the titolo
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * Gets testo.
     *
     * @return the testo
     */
    public String getTesto() {
        return testo;
    }

    /**
     * Carica tesi.
     */
    public void caricaTesi(){
        this.caricata=true;
    }
}
