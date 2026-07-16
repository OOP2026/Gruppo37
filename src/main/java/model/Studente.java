package model;


/**
 * La classe Studente.
 * Rappresenta un studente registrato ad un corso di laurea.
 * Estende Utente.
 */
public class Studente extends Utente {
    /**
     * Rappresenta la matricola dello studente.
     */
    private String matricola;
    /**
     * Rappresenta la seduta di laurea a cui lo studente si e' prenotato.
     */
    private SedutaLaurea sedutaLaurea;
    /**
     * Rappresenta l'ultima richiesta inviata dallo studente.
     */
    private Richiesta ultimaRiciesta;
    /**
     * Rappresenta l'ultima tesi inviata dallo studente.
     */
    private Tesi ultimaTesi;

    /**
     * Costruttore della classe Studente.
     *
     * @param nome      il nome dello studente
     * @param cognome   il cognome dello studente
     * @param email     l'email dello studente
     * @param login     il login dello studente
     * @param password  la password dello studente
     * @param matricola la matricola dello studente
     */
    public Studente(String nome, String cognome, String email, String login, String password, String matricola){
        super(nome,cognome,email,login,password);
        this.matricola=matricola;
    }

    /**
     * Prenota una seduta laurea.
     *
     * @param data la data della seduta di laurea a cui lo studente si vuole prenotare
     * @param luogo il luogo della seduta di laurea a cui lo studente si vuole prenotare
     */
    public void prenotaSedutaLaurea(String data, String luogo){
        SedutaLaurea sl = new SedutaLaurea(data,luogo);
    }

    /**
     * Crea una nuova richiesta.
     *
     * @param r la richiesta che lo studente vuole creare
     */
    public void creaRichiesta(Richiesta r) {
        this.ultimaRiciesta=r;
        r.aggiungiStudente(this);
    }

    /**
     * Visualizza lo stato della richiesta creata dallo studente.
     */
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

    /**
     * Crea una nuova tesi.
     *
     * @param t il tirocinio che lo studente vuole creare
     */
    public void creaTesi(Tesi t){
        this.ultimaTesi=t;
        t.aggiungiStudente(this);
    }

    /**
     * Ottiene il nome dello studenete.
     *
     * @return il nome dello studente
     */
    public String getNomeStudenete(){
        return this.nome;
    }
}