package model;
import java.util.*;

public class Richiesta {
    private Stato stato;
    private Date dataRichiesta;
    private Tirocinio tirocinio;
    private Studente studente;
    private Docente docente;

    public Richiesta(Date dataRichiesta, Tirocinio tirocinio, Studente studente, Docente docente) {
        this.stato.inAttesa();
        this.dataRichiesta=dataRichiesta;
        this.tirocinio=tirocinio;
        this.studente=studente;
        this.docente=docente;
    }

    public void aggiungiTircoinio(Tirocinio t){
        this.tirocinio=t;
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

    public Stato getStato() {
        return stato;
    }
}
