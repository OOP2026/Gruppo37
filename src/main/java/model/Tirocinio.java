package model;
import java.util.*;

public class Tirocinio {
    private String nomeTirocinio;
    private Spazio spazioTirocinio;
    private boolean disponibile;
    private ArrayList<Studente> studenti;


    public Tirocinio(String nomeTirocinio, Spazio spazioTirocinio, boolean disponibile){
        this.nomeTirocinio=nomeTirocinio;
        this.spazioTirocinio=spazioTirocinio;
        this.disponibile=disponibile;
    }

    public void aggiungiStudente(Studente studenti){
        this.studenti.add(studenti);
    }

    public void getNomeTirocinio(){
        System.out.println(this.nomeTirocinio);
    }
}
