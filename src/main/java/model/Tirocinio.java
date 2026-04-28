package model;
import java.util.*;

public class Tirocinio {
    private String nomeTirocinio;
    private String spazioTirocinio;
    private boolean disponibile;


    public Tirocinio(String nomeTirocinio, String spazioTirocinio, boolean disponibile){
        this.nomeTirocinio=nomeTirocinio;
        this.spazioTirocinio=spazioTirocinio;
        this.disponibile=disponibile;
    }
}
