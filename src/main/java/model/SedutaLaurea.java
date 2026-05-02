package model;
import java.util.*;

public class SedutaLaurea {
    private Date dataSeduta;
    private String luogoSeduta;
    private ArrayList<Studente> studenti;

    public SedutaLaurea(Date dataSeduta, String luogoSeduta){
        this.dataSeduta=dataSeduta;
        this.luogoSeduta=luogoSeduta;
    }

    public void aggiungiStuudente(Studente studenti){
            this.studenti.add(studenti);
    }
}
