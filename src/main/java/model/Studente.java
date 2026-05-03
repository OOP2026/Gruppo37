package model;
import java.util.*;

public class Studente extends Utente {
    private String matricola;
    private ArrayList<Tesi> tesi;

    public Studente(String nome, String cognome, String email, String login, String password, String matricola){
        super(nome,cognome,email,login,password);
        this.matricola=matricola;
    }

    public void aggiungiTesi(Tesi tesi){
        this.tesi.add(tesi);
    }

    public void visualizza(){
        //visualizza docenti e tirocini disponibili
    }

    public void nomeStudenete(){
        if (this!=null)
        System.out.println(this.nome);
    }
}
