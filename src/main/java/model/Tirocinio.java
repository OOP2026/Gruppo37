package model;
import java.util.*;

public class Tirocinio {
    private String nomeTirocinio;
    private Spazio spazioTirocinio;
    private boolean disponibile;
    private boolean inCorso;
    private ArrayList<Studente> studenti=new ArrayList();


    public Tirocinio(String nomeTirocinio, Spazio spazioTirocinio, boolean disponibile,  boolean inCorso) {
        this.nomeTirocinio=nomeTirocinio;
        this.spazioTirocinio=spazioTirocinio;
        this.disponibile=disponibile;
        this.inCorso=inCorso;
    }

    public void aggiungiStudente(Studente studenti){
        this.studenti.add(studenti);
    }

    public void vediStudenti() {
        for(Studente s: studenti){
            System.out.println(s.getNomeStudenete());
        }

    }

    public String getNomeTirocinio(){
        return this.nomeTirocinio;
    }

    public boolean getInCorsoTirocinio(){
        return this.inCorso;
    }
}
