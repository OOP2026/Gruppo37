package model;
import java.util.*;

/**
 * La classe SedutaLaurea.
 * Rappresenta una seduta di laurea in cui gli studenti si possono prenotare.
 */
public class SedutaLaurea {
    /**
     * Rappresenta la data in cui si svolgera' la seduta di laurea.
     */
    private String dataSeduta;
    /**
     * Rappresenta il luogo in cui si svolgera' la seduta di laurea.
     */
    private String luogoSeduta;

    /**
     * Costruttore della classe SedutaLaurea.
     *
     * @param dataSeduta  la data della seduta di laurea
     * @param luogoSeduta il luogo della seduta di laurea
     */
    public SedutaLaurea(String dataSeduta, String luogoSeduta){
        this.dataSeduta=dataSeduta;
        this.luogoSeduta=luogoSeduta;
    }

    /**
     * Ottiene la data della seduta di laurea.
     *
     * @return la data della seduta di laurea
     */
    public String getDataSeduta() {
        return dataSeduta;
    }

    /**
     * Ottiene il luogo della seduta di laurea.
     *
     * @return il luogo della seduta di laurea
     */
    public String getLuogoSeduta() {
        return luogoSeduta;
    }
}
