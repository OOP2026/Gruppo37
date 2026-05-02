package model;

import java.util.ArrayList;

public class Azienda {
    String referenteAziendale;
    ArrayList<Tirocinio> tirocini;

    public Azienda(String referenteAziendale) {
        this.referenteAziendale = referenteAziendale;
    }
    public void aggiungiTirocinio(Tirocinio tirocini){
        this.tirocini.add(tirocini);
    }
}
