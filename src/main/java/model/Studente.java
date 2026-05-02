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
        System.out.println();
    }

    public void nomeStudenete(){
        System.out.println(this.nome);
    }
}
