package model;

import java.util.ArrayList;

/**
 * Rappresenta un'azienda esterna che puo' collabborare per promuovere i tirocini.
 */
public class Azienda {
    /**
     * The Referente aziendale.
     */
    String referenteAziendale;
    /**
     * The Tirocini.
     */
    ArrayList<Tirocinio> tirocini;

    /**
     * Instantiates a new Azienda.
     *
     * @param referenteAziendale the referente aziendale
     */
    public Azienda(String referenteAziendale) {
        this.referenteAziendale = referenteAziendale;
    }

    /**
     * Aggiungi tirocinio.
     *
     * @param tirocini the tirocini
     */
    public void aggiungiTirocinio(Tirocinio tirocini){
        this.tirocini.add(tirocini);
    }
}
