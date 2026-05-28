package model;
import java.util.*;

public class SedutaLaurea {
    private Date dataSeduta;
    private String luogoSeduta;

    public SedutaLaurea(Date dataSeduta, String luogoSeduta){
        this.dataSeduta=dataSeduta;
        this.luogoSeduta=luogoSeduta;
    }

    public Date getDataSeduta() {
        return dataSeduta;
    }
    public String getLuogoSeduta() {
        return luogoSeduta;
    }
}
