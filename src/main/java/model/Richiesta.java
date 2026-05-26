package model;
import java.util.*;

public class Richiesta {
    private Stato stato;
    private Date dataRichiesta;
    private Tirocinio tirocinio;
    private Studente studente;
    private Docente docente;

    public Richiesta(Date dataRichiesta, Tirocinio tirocinio, Studente studente, Docente docente) {
        this.stato=Stato.InAttesa;
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

    public void approva() {this.stato=Stato.Approvata;}

    public void rifiuta(){
        this.stato=Stato.Rifiutata;
    }

    public Stato getStato() {
        return stato;
    }
}
