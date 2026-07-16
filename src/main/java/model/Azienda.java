package model;

import java.util.ArrayList;

/**
 * La classe Azienda.
 * Rappresenta un'azienda esterna che puo' collabborare per promuovere i tirocini.
 */
public class Azienda {
    /**
     * Rappresenta il referente aziendale.
     */
    String referenteAziendale;
    /**
     * Rappresentano tutti i tirocini con cui ha collaborato l'azienda.
     */
    ArrayList<Tirocinio> tirocini;

    /**
     * Costruttore della classe Azienda.
     *
     * @param referenteAziendale il referente aziendale
     */
    public Azienda(String referenteAziendale) {
        this.referenteAziendale = referenteAziendale;
    }
}
