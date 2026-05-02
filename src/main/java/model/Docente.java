package model;
import java.util.*;

public class Docente extends Utente{
    protected String elencoArgomentiTirocinio;
    protected ArrayList<Richiesta> richieste;
    protected ArrayList<Tesi> tesi;

    public Docente(String nome, String cognome, String email, String login, String password, String elencoArgomentiTirocinio){
        super(nome,cognome,email,login,password);
        this.elencoArgomentiTirocinio=elencoArgomentiTirocinio;
    }

    public void aggiungiRichiesta (Richiesta richieste){
        this.richieste.add(richieste);
    }

    public void aggiungiTesi(Tesi tesi){
        this.tesi.add(tesi);
    }

    public void visualizza(){
        for(Richiesta r: richieste){
            Studente s=r.ottieniStudente();
            s.nomeStudenete();
        }
        for(Richiesta r: richieste){
            Tirocinio t=r.ottieniTirocinio();
            t.getNomeTirocinio();
        }
    }
    public void approvaRichiesta(int n){
        Richiesta r=this.richieste.get(n);
        r.approva();
    }
    public void rifiutaRichiesta(int n){
        Richiesta r=this.richieste.get(n);
        r.rifiuta();
    }
    public void approvaTesi(int n){
        Tesi t=this.tesi.get(n);
        t.rifiuta();
    }
    public void rifiutaTesi(int n){
        Tesi t=this.tesi.get(n);
        t.rifiuta();
    }
}
