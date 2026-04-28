package model;
import java.util.*;

public class Richiesta {
    String stato;
    Date dataRichiesta;

    public Richiesta(String stato, Date dataRichiesta){
        this.stato=stato;
        this.dataRichiesta=dataRichiesta;
    }
}
