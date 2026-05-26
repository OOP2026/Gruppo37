package model;
import java.util.*;

public class Docente extends Utente{
    protected String argomentoTirocinio;
    protected ArrayList<Tirocinio> tirocini= new ArrayList();

    public Docente(String nome, String cognome, String email, String login,
                   String password, String argomentoTirocinio){
        super(nome,cognome,email,login,password);
        this.argomentoTirocinio=argomentoTirocinio;
    }

    public void creaTirocinio(String nomeTirocinio, Ente spazioTirocinio, boolean disponibile, boolean inCorso){
        Tirocinio t= new Tirocinio(nomeTirocinio, spazioTirocinio, disponibile,  inCorso);
        tirocini.add(t);
    }

    public void visualizza(){
        for(Tirocinio t:tirocini){
            if(t.getInCorsoTirocinio()) {
                System.out.println(t.getNomeTirocinio());
                t.vediStudenti();
            }
        }
    }

    public void approvaRichiesta(Richiesta r){
        r.approva();
    }
    public void rifiutaRichiesta(Richiesta r){
        r.rifiuta();
    }
    public void approvaTesi(Tesi t){
        t.approva();
    }
    public void rifiutaTesi(Tesi t){
        t.rifiuta();
    }
}
