package model;
import java.util.*;

public class Tesi {
    private Stato stato;
    private boolean caricata;
    Studente studente;

    public Tesi(boolean caricata, Studente studente){
        this.stato.inAttesa();
        this.caricata=caricata;
        this.studente=studente;
    }

    public void approva() {
        this.stato.approvata();
    }

    public void rifiuta(){
        this.stato.rifiutata();
    }
}
