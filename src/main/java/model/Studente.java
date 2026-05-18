package model;
import java.util.*;

public class Studente extends Utente {
    private String matricola;
    private Richiesta ultimaRiciesta;

    public Studente(String nome, String cognome, String email, String login, String password, String matricola){
        super(nome,cognome,email,login,password);
        this.matricola=matricola;
    }

    public void creaRichiesta(Richiesta r) {
        this.ultimaRiciesta=r;
        r.aggiungiStudente(this);
    }

    public void visualizzaRichiesta(){
        if(ultimaRiciesta.getStato().equals("Approvato")){
            System.out.println("Richiesta approvata");
        }
        if(ultimaRiciesta.getStato().equals("Rifiutata")){
            System.out.println("Richiesta rifiutata");
        }
        if(ultimaRiciesta.getStato().equals("InAttesa")){
            System.out.println("Richiesta in attesa");
        }
    }

    public String getNomeStudenete(){
        return this.nome;
    }
}



/*
DA FARE:
Aggiungere= att nel UML di Tirocinio: inCorso
Studente e Tirocinio N:N
Aggiungere= metodo Studente: visualizzaRichiesta e creaRichiesta
Toglere= metodo Studente: visualizza
Docente: l'att elencoArgomentiTirocinio diventa: argomentoTirocinio

 */