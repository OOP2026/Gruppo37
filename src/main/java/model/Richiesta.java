package model;
import java.util.*;

public class Richiesta {
    private Stato stato;
    private Date dataRichiesta;
    private Tirocinio tirocinio;
    private Studente studente;

    public Richiesta(Date dataRichiesta, Tirocinio tirocinio, Studente studente) {
        this.stato.inAttesa();
        this.dataRichiesta=dataRichiesta;
        this.tirocinio=tirocinio;
        this.studente=studente;
    }

    public void approva() {
        this.stato.approvata();
    }

    public void rifiuta(){
        this.stato.rifiutata();
    }

    public Studente ottieniStudente() {
        if (this.stato.equals("Approvata"))
            return this.studente;
        return null;
    }

    public Tirocinio ottieniTirocinio(){
        return this.tirocinio;
    }
}
