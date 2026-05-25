package model;

import java.io.BufferedWriter;
import java.util.*;

public class Tesi {
    private BufferedWriter testo;
    private Stato stato;
    private boolean caricata;
    private Studente studente;
    private Docente docente;

    public Tesi(BufferedWriter testo, boolean caricata){
        this.testo = testo;
        this.stato.inAttesa();
        this.caricata=caricata;
    }

    public void aggiungiStudente(Studente s){
        this.studente=s;
    }

    public void aggiungiDocente(Docente d){
        this.docente=d;
    }

    public void approva() {
        this.stato.approvata();
    }

    public void rifiuta(){
        this.stato.rifiutata();
    }
}
