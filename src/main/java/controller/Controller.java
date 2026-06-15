package controller;

import model.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * The type Controller.
 */
public class Controller {
	private Studente studente;
	private Docente docente;
	private Tesi tesi;
	private Tirocinio tirocinio;
	private Richiesta richiesta;
	private SedutaLaurea sedutaLaurea;


    /**
     * Instantiates a new Controller.
     */
    public Controller() {
	}

    /**
     * Aggiungi utente boolean.
     *
     * @param login    the login
     * @param password the password
     * @param nome     the nome
     * @param cognome  the cognome
     * @param email    the email
     * @param stuDoc   the stu doc
     * @return the boolean
     */
    public boolean aggiungiUtente(String login, String password, String nome, String cognome, String email, boolean stuDoc){
		if(stuDoc==true)
		{
			studente=new Studente(nome,cognome,email,login,password,null);
		}
		else{
			docente=new Docente(nome,cognome,email,login,password,null);
		}
		return true;
	}

    /**
     * Accedi utente boolean.
     *
     * @param login    the login
     * @param password the password
     * @param stuDoc   the stu doc
     * @return the boolean
     */
    public boolean accediUtente(String login, String password, boolean stuDoc){
		if(stuDoc==true){
			if(studente==null){
				return false;
			}
			if(studente.login(login,password)){
				return true;
			}
		}
		else{
			if(docente==null){
				return false;
			}
			if(docente.login(login,password)){
				return true;
			}
		}
		return false;
		}

    /**
     * Gets nome.
     *
     * @param stuDoc the stu doc
     * @return the nome
     */
    public String getNome(boolean stuDoc) {
		if (stuDoc == true){
			return studente.getNomeUtente();
	}else{
			return docente.getNomeUtente();
	}
	}

    /**
     * Gets cognome.
     *
     * @param stuDoc the stu doc
     * @return the cognome
     */
    public String getCognome(boolean stuDoc) {
		if (stuDoc == true){
			return studente.getCognomeUtente();
		}
		else{
			return docente.getCognomeUtente();
		}
	}

    /**
     * Salva tesi boolean.
     *
     * @param titolo the titolo
     * @param testo  the testo
     * @return the boolean
     */
    public boolean salvaTesi(String titolo, String testo){
		tesi = new Tesi(titolo, testo, false);
		return true;
	}

    /**
     * Carica tesi boolean.
     *
     * @return the boolean
     */
    public boolean caricaTesi(){
		tesi.caricaTesi();
		return true;
	}

    /**
     * Not null tesi boolean.
     *
     * @return the boolean
     */
    public boolean notNullTesi(){
		if(tesi==null){
			return false;
		}
		return true;
	}

    /**
     * Get titolo string.
     *
     * @return the string
     */
    public String getTitolo(){
		return tesi.getTitolo();
	}

    /**
     * Get testo string.
     *
     * @return the string
     */
    public String getTesto(){
		return tesi.getTesto();
	}

    /**
     * Crea tirocinio boolean.
     *
     * @param nome the nome
     * @param ente the ente
     * @return the boolean
     */
    public boolean creaTirocinio(String nome, String ente){
		if("Interno".equals(ente)) {
			tirocinio = new Tirocinio(nome, Ente.Interno, true, false);
			return true;
		}else{
			tirocinio = new Tirocinio(nome, Ente.Esterno, true, false);
			return true;
		}
	}

    /**
     * Leggi nome tirocinio string.
     *
     * @return the string
     */
    public String leggiNomeTirocinio(){
		return tirocinio.getNomeTirocinio();
	}

    /**
     * Leggi ente tirocinio string.
     *
     * @return the string
     */
    public String leggiEnteTirocinio(){
		if(Ente.Interno.equals(tirocinio.getEnteTirocinio()))
		{
			return "Interno";
		}else{
			return "Esterno";
		}
	}

    /**
     * Leggi disponibilita tirocinio boolean.
     *
     * @return the boolean
     */
    public boolean leggiDisponibilitaTirocinio(){
		return tirocinio.getDisponibileTirocinio();
	}

    /**
     * Leggi in corso tirocinio boolean.
     *
     * @return the boolean
     */
    public boolean leggiInCorsoTirocinio(){
		return tirocinio.getInCorsoTirocinio();
	}

    /**
     * Verifica nome tirocinio boolean.
     *
     * @param nome the nome
     * @return the boolean
     */
    public boolean verificaNomeTirocinio(String nome){
		if(tirocinio.getNomeTirocinio().equals(nome)){
			if(tirocinio.getDisponibileTirocinio()==true){
			richiesta= new Richiesta(null, tirocinio, studente, docente);
			return true;
		}}
		return false;
	}

    /**
     * Get tirocinio string.
     *
     * @return the string
     */
    public String getTirocinio(){
		return richiesta.getTirocinio().getNomeTirocinio();
	}

    /**
     * Gets studente e tirocinio.
     *
     * @return the studente e tirocinio
     */
    public ArrayList<String> getStudenteETirocinio() {
		ArrayList<String> arrayStudente = new ArrayList<>();
		if (Stato.InAttesa.equals(richiesta.getStato())) {
			Studente s = richiesta.getStudente();
			arrayStudente.add(s.getNomeUtente());
			arrayStudente.add(s.getCognomeUtente());
			return arrayStudente;
		}
		return null;
	}

    /**
     * Verifica richiesta boolean.
     *
     * @param nomeStudente    the nome studente
     * @param cognomeStudente the cognome studente
     * @param nomeTirocinio   the nome tirocinio
     * @return the boolean
     */
    public boolean verificaRichiesta(String nomeStudente,String cognomeStudente,
										String nomeTirocinio){
		if(nomeStudente.equals(richiesta.getStudente().getNomeUtente()) &&
				cognomeStudente.equals(richiesta.getStudente().getCognomeUtente()) &&
				nomeTirocinio.equals(richiesta.getTirocinio())){
			return true;
		}
		return false;
	}

    /**
     * Cambia stato richiesta.
     *
     * @param stato the stato
     */
    public void cambiaStatoRichiesta(boolean stato){
		if(stato){
			richiesta.approva();
		}else{
			richiesta.rifiuta();
		}
	}

    /**
     * Get data seduta string.
     *
     * @return the string
     */
    public String getDataSeduta(){
		if(sedutaLaurea==null){
			return"";
		}
		return String.valueOf(sedutaLaurea.getDataSeduta());
	}

    /**
     * Get luogo seduta string.
     *
     * @return the string
     */
    public String getLuogoSeduta(){
		return sedutaLaurea.getLuogoSeduta();
	}

    /**
     * Verifica seduta boolean.
     *
     * @param data  the data
     * @param luogo the luogo
     * @return the boolean
     */
    public boolean verificaSeduta(String data, String luogo){
		if(data.equals(String.valueOf(sedutaLaurea.getDataSeduta())) && luogo.equals(sedutaLaurea.getLuogoSeduta())){
			studente.prenotaSedutaLaurea(sedutaLaurea);
			return true;
		}
		return false;
	}
}

