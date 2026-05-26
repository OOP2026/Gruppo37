package model;
import java.util.*;

public class Studente extends Utente {
    private String matricola;
    private SedutaLaurea sedutaLaurea;
    private Richiesta ultimaRiciesta;
    private Tesi ultimaTesi;

    public Studente(String nome, String cognome, String email, String login, String password, String matricola){
        super(nome,cognome,email,login,password);
        this.matricola=matricola;
    }

    public void prenotaSedutaLaurea(SedutaLaurea sL){
        this.sedutaLaurea=sL;
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

    public void creaTesi(Tesi t){
        this.ultimaTesi=t;
        t.aggiungiStudente(this);
    }

    public String getNomeStudenete(){
        return this.nome;
    }
}



/*
DA FARE:
Aggiungere= att nel UML di Tirocinio: inCorso
Studente e Tirocinio N:N
Nuova ASSOCIAZIONE= Docente e Tirocinio con "CREARE" 1:N (trova parola migliore)
Aggiungere= metodo Studente: visualizzaRichiesta e creaRichiesta e creaTesi e prenotaSeduta
Toglere= metodo Studente: visualizza
Docente: l'att elencoArgomentiTirocinio diventa: argomentoTirocinio
Tirocinio: l'att spazioTirocinio diventa: enteTirocinio
Aggiungere= metodo Docente: creaTirocinio
Tesi; att testo, att titolo

 */