package model;
import java.util.*;

/**
 * The type Seduta laurea.
 */
public class SedutaLaurea {
    private Date dataSeduta;
    private String luogoSeduta;

    /**
     * Instantiates a new Seduta laurea.
     *
     * @param dataSeduta  the data seduta
     * @param luogoSeduta the luogo seduta
     */
    public SedutaLaurea(Date dataSeduta, String luogoSeduta){
        this.dataSeduta=dataSeduta;
        this.luogoSeduta=luogoSeduta;
    }

    /**
     * Gets data seduta.
     *
     * @return the data seduta
     */
    public Date getDataSeduta() {
        return dataSeduta;
    }

    /**
     * Gets luogo seduta.
     *
     * @return the luogo seduta
     */
    public String getLuogoSeduta() {
        return luogoSeduta;
    }
}
