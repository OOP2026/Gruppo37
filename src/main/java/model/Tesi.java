package model;


/**
 * La classe Tesi.
 * Rappresenta una tesi ricevuta da un docente, sritta da uno studente
 */
public class Tesi {
    /**
     * Rappresenta il titolo della tesi.
     */
    private String titolo;
    /**
     * Rappresenta il testo della tesi.
     */
    private String testo;
    /**
     * Rappresenta lo stato della tesi.
     */
    private Stato stato;
    /**
     * Informa se la tesi e' stata caricata.
     */
    private boolean caricata;
    /**
     * Rappresenta lo studente che scrive la tesi.
     */
    private Studente studente;
    /**
     * Rappresenta il docente a cui viene inviata la tesi.
     */
    private Docente docente;

    /**
     * Costruttore della classe Tesi.
     *
     * @param titolo   il titolo della tesi
     * @param testo    il testo della tesi
     * @param caricata stabilisce se la tesi e' stata caricata
     */
    public Tesi(String titolo,String testo, boolean caricata){
        this.titolo = titolo;
        this.testo = testo;
        this.stato = Stato.InAttesa;
        this.caricata=caricata;
    }

    /**
     * Aggiungie uno studente alla tesi.
     *
     * @param s lo studente che deve essere aggiunto alla tesi
     */
    public void aggiungiStudente(Studente s){
        this.studente=s;
    }

    /**
     * Aggiungie un docente alla tesi.
     *
     * @param d il docente che deeve essere aggiunto alla tesi
     */
    public void aggiungiDocente(Docente d){
        this.docente=d;
    }

    /**
     * Approva la tesi.
     */
    public void approva() {
        this.stato=Stato.Approvata;
    }

    /**
     * Rifiuta la tesi.
     */
    public void rifiuta(){

        this.stato=Stato.Rifiutata;
    }

    /**
     * Ottiene il titolo della tesi.
     *
     * @return il titolo della tesi
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * Ottiene il testo della tesi.
     *
     * @return il testo della tesi
     */
    public String getTesto() {
        return testo;
    }

    /**
     * Carica la tesi.
     */
    public void caricaTesi(){
        this.caricata=true;
    }
}
