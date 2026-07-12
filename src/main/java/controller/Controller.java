package controller;

import model.*;
import implementazioneDao.*;
import dao.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * La classe Controller.
 * Rappresenta il controller che segue i calcoli richiesti dalla gui.
 */
public class Controller {
	private Studente studente;
	private Docente docente;
	private Tesi tesi;
	private Tirocinio tirocinio;
	private Richiesta richiesta;
	private SedutaLaurea sedutaLaurea;
	private StudenteDAO studenteDAO =new StudenteImplementazionePostgresDAO();
	private DocenteDAO docenteDAO = new DocenteImplementazionePostgresDAO();
	private TesiDAO tesiDAO = new TesiImplementazionePostgresDAO();
	

    /**
     * Costruttore della classe Controller.
     */
    public Controller() {
	}

    /**
     * Aggiungi l'utente al sistema.
     *
     * @param login    il login dell'utente
     * @param password la password dell'utente
     * @param nome     il nome dell'utente
     * @param cognome  il cognome dell'utente
     * @param email    l'email dell'utente
     * @param stuDoc   informa se e' uno studente o un docente
     * @return infroma se l'inserimento e' avvenuto con successo
     */
    public boolean aggiungiUtente(String login, String password, String nome, String cognome, String email, boolean stuDoc){
		if(stuDoc==true)
		{
			try {
				studenteDAO.aggiungiStudente(nome, cognome, email, login, password);
			} catch (SQLException e0){
				throw new RuntimeException(e0);
			}
				studente=new Studente(nome,cognome,email,login,password,null);
		}
		else{
			try{
			docenteDAO.aggiungiDocente(nome,cognome,email,login,password);
			} catch (SQLException e1){
				throw new RuntimeException(e1);
			}
			docente=new Docente(nome,cognome,email,login,password,null);
		}
		return true;
	}

    /**
     * Permette all'utente di accedere al sistema.
     *
     * @param login    il login utente
     * @param password la password utente
     * @param stuDoc   informa se e' uno studente o un docente
     * @return infroma se l'accesso e' avvenuto con successo
     */
    public String accediUtente(String login, String password, boolean stuDoc) {
		if (stuDoc == true) {
			try {
				ArrayList info = new ArrayList();
				info = studenteDAO.accediStudente(login, password);
				if (info != null) {
					studente = new Studente(info.get(0), info.get(1), info.get(2), info.get(3), info.get(4), info.get(5));
					tesi= new Tesi(info.get(6), info.get(7), info.get(8), info.get(9), info.get(10));
					return info.get(0);
			    }
			} catch (SQLException e2) {
				throw new RuntimeException(e2);
			}
			return null;
		} else {
			try {
				ArrayList<String> info = new ArrayList<String>();
				info = docenteDAO.accediDocente(login, password);
				if (info != null) {
					docente = new Docente(info.get(0), info.get(1), info.get(2), info.get(3), info.get(4), info.get(5));
					return info.get(0);
				}
			} catch (SQLException e3) {
				throw new RuntimeException(e3);
			}
			return null;
		}
	}

    /**
     * Ottiene il nome dell'utente.
     *
     * @param stuDoc informa se e' uno studente o un docente
     * @return il nome dell'utente
     */
    public String getNome(boolean stuDoc) {
		if (stuDoc == true){
			return studente.getNomeUtente();
	}else{
			return docente.getNomeUtente();
	}
	}

    /**
     * Ottine il cognome dell'utente.
     *
     * @param stuDoc informa se e' uno studente o un docente
     * @return il cognome dell'utente
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
     * Salva la tesi scritta dallo studente.
     *
     * @param titolo il titolo della tesi
     * @param testo  il testo della tesi
     * @return infroma se il salvataggio e' avvenuto con successo
     */
    public boolean salvaTesi(String titolo, String testo, String nomeS){
		try{
		tesiDAO.salvaTesi(titolo,testo,nomeS);
		tesi = new Tesi(titolo, testo, false);
		return true;}
		catch(Exception e4){
			throw new RuntimeException(e4);
		}
	}

    /**
     * Carica la tesi.
     *
     * @return infroma se il caricamento e' avvenuto con successo
     */
    public boolean caricaTesi(String nomeS){
		try{
			tesiDAO.caricaTesi(nomeS);
			tesi.caricaTesi();
			return true;}
		catch(Exception e5){
			throw new RuntimeException(e5);
		}
	}

    /**
     * Indica se la tesi e' stata gia' salvata prima
     *
     * @return infroma se la tesi era gia' stata salvata
     */
    public boolean notNullTesi(){
		if(tesi==null){
			return false;
		}
		return true;
	}

    /**
     * Ottiene il titolo della tesi.
     *
     * @return il titolo della tesi
     */
    public String getTitolo(){
		return tesi.getTitolo();
	}

    /**
     * Ottiene il testo della tesi.
     *
     * @return il testo della tesi
     */
    public String getTesto(){
		return tesi.getTesto();
	}

    /**
     * Crea un nuovo tirocinio.
     *
     * @param nome il nome del tricoinio
     * @param ente l'ente del tricoinio
     * @return infroma se la creazione e' avvenuto con successo
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
     * Leggi il nome del tirocinio.
     *
     * @return il nome del tirocinio
     */
    public String leggiNomeTirocinio(){
		return tirocinio.getNomeTirocinio();
	}

    /**
     * Leggi l'ente del tirocinio.
     *
     * @return l'ente del tricoinio
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
     * Leggi la disponibilita' del tirocinio.
     *
     * @return infroma se il tirocinio e' disponibile
     */
    public boolean leggiDisponibilitaTirocinio(){
		return tirocinio.getDisponibileTirocinio();
	}

    /**
     * Leggi se il tirocinio e' incominciato
     *
     * @return infroma se il tirocinio e' incominciato
     */
    public boolean leggiInCorsoTirocinio(){
		return tirocinio.getInCorsoTirocinio();
	}

    /**
     * Verifica se il tirocinio esiste.
     *
     * @param nome il nome del tirocinio
     * @return infroma se la verifica e' avvenuta con successo
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
     * Ottiene il nome tirocinio.
     *
     * @return il nome tirocinio
     */
    public String getTirocinio(){
		return richiesta.getTirocinio().getNomeTirocinio();
	}

    /**
     * Ottiene gli studenti iscritti al tirocinio.
     *
     * @return glu studenti iscritti
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
     * Verifica se la richiesta esiste.
     *
     * @param nomeStudente    il nome dello studente
     * @param cognomeStudente il cognome dello studente
     * @param nomeTirocinio   il nome del tirocinio
     * @return infroma se la verifica e' avvenuta con successo
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
     * Cambia lo stato della richiesta.
     *
     * @param stato lo stato della richiesta
     */
    public void cambiaStatoRichiesta(boolean stato){
		if(stato){
			richiesta.approva();
		}else{
			richiesta.rifiuta();
		}
	}

    /**
     * Ottiene la data della seduta di laurea.
     *
     * @return la data della seduta di laurea
     */
    public String getDataSeduta(){
		if(sedutaLaurea==null){
			return"";
		}
		return String.valueOf(sedutaLaurea.getDataSeduta());
	}

    /**
     * Ottiene il luogo della seduta di laurea.
     *
     * @return il luogo della seduta di laurea
     */
    public String getLuogoSeduta(){
		return sedutaLaurea.getLuogoSeduta();
	}

    /**
     * Verifica se la seduta di lairea esiste.
     *
     * @param data  la data
     * @param luogo il luogo
     * @return infroma se la verifica e' avvenuta con successo
     */
    public boolean verificaSeduta(String data, String luogo){
		if(data.equals(String.valueOf(sedutaLaurea.getDataSeduta())) && luogo.equals(sedutaLaurea.getLuogoSeduta())){
			studente.prenotaSedutaLaurea(sedutaLaurea);
			return true;
		}
		return false;
	}
}

