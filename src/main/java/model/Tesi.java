package model;
import java.util.*;

public class Tesi {
    private Stato stato;
    private boolean caricata;
    private Studente studente;
    private Docente docente;

    public Tesi(boolean caricata, Studente studente, Docente docente){
        this.stato.inAttesa();
        this.caricata=caricata;
        this.studente=studente;
        this.docente=docente;
    }

    public void approva() {
        this.stato.approvata();
    }

    public void rifiuta(){
        this.stato.rifiutata();
    }
}
