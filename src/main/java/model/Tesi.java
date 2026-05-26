package model;

import java.util.*;

public class Tesi {
    private String titolo;
    private String testo;
    private Stato stato;
    private boolean caricata;
    private Studente studente;
    private Docente docente;

    public Tesi(String titolo,String testo, boolean caricata){
        this.titolo = titolo;
        this.testo = testo;
        this.stato = Stato.InAttesa;
        this.caricata=caricata;
    }

    public void aggiungiStudente(Studente s){
        this.studente=s;
    }

    public void aggiungiDocente(Docente d){
        this.docente=d;
    }

    public void approva() {
        this.stato=Stato.Approvata;
    }

    public void rifiuta(){

        this.stato=Stato.Rifiutata;
    }

    public String getTitolo() {
        return titolo;
    }
    public String getTesto() {
        return testo;
    }
    public void caricaTesi(){
        this.caricata=true;
    }
}
