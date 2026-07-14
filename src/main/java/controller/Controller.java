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
	private TirocinioDAO tirocinioDAO=new TirocinioImplementazionePostgresDAO();
	private RichiestaDAO richiestaDAO=new RichiestaImplementazionePostgresDAO();
	

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
    public int accediUtente(String login, String password, boolean stuDoc) {
		if (stuDoc == true) {
			try {
				ArrayList<Object> info = new ArrayList();
				info = studenteDAO.accediStudente(login, password);
				if (info != null) {
					studente = new Studente((String)info.get(1),(String) info.get(2), (String)info.get(3), (String)info.get(4),
							(String)info.get(5),(String)info.get(6));
					return (int)info.get(0);
			    }
			} catch (SQLException e2) {
				throw new RuntimeException(e2);
			}
			return 0;
		} else {
			try {
				ArrayList<Object> info = new ArrayList();
				info = docenteDAO.accediDocente(login, password);
				if (info != null) {
					docente = new Docente((String)info.get(1), (String)info.get(2), (String)info.get(3), (String)info.get(4),
							(String)info.get(5),(String)info.get(6));
					return (int)info.get(0);
				}
			} catch (SQLException e3) {
				throw new RuntimeException(e3);
			}
			return 0;
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
    public boolean salvaTesi(String titolo, String testo, int idS){
		try{
		tesiDAO.salvaTesi(titolo,testo,idS);
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
    public boolean caricaTesi(int idS){
		try{
			tesiDAO.caricaTesi(idS);
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
    public boolean notNullTesi(int idS) {
		try {
			ArrayList<Object> info = new ArrayList();
			info=tesiDAO.notNullTesi(idS);
		    if (info != null) {
				tesi= new Tesi((String)info.get(2),(String)info.get(3),(boolean)info.get(5));
				return true;
			}else{
			return false;}
	    } catch (Exception e5) {
			throw new RuntimeException(e5);
		}
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
    public boolean creaTirocinio(String nome, String ente,int idD){
		try{if("Interno".equals(ente)) {
			tirocinioDAO.creaTirocinio(idD,nome,true);
			tirocinio = new Tirocinio(nome, Ente.Interno, true, false);
			return true;
		}else{
			tirocinioDAO.creaTirocinio(idD,nome,false);
			tirocinio = new Tirocinio(nome, Ente.Esterno, true, false);
			return true;
		}
	} catch (SQLException e6) {
			throw new RuntimeException(e6);
		}
	}

    /**
     * Leggi il nome del tirocinio.
     *
     * @return il nome del tirocinio
     */
    public ArrayList<String> leggiNomeTirocinio(int idD){
		try{ArrayList<String> nomeTirocinio=tirocinioDAO.getNomeTirocinio(idD);
		return nomeTirocinio;
		}catch(SQLException e7){
			throw new RuntimeException(e7);
		}
	}

    /**
     * Leggi l'ente del tirocinio.
     *
     * @return l'ente del tricoinio
     */
    public ArrayList<String> leggiEnteTirocinio(int idD){
		try{ArrayList<String> ente=tirocinioDAO.getEnte(idD);
			return ente;
		}catch(SQLException e8){
			throw new RuntimeException(e8);
		}
	}

    /**
     * Leggi la disponibilita' del tirocinio.
     *
     * @return infroma se il tirocinio e' disponibile
     */
    public ArrayList<Boolean> leggiDisponibilitaTirocinio(int idD){
		try{ArrayList<Boolean> disponibile=tirocinioDAO.getDisponibile(idD);
			return disponibile;
		}catch(SQLException e9){
			throw new RuntimeException(e9);
		}
	}

    /**
     * Leggi se il tirocinio e' incominciato
     *
     * @return infroma se il tirocinio e' incominciato
     */
    public ArrayList<Boolean> leggiInCorsoTirocinio(int idD){
		try{ArrayList<Boolean> inCorso=tirocinioDAO.getInCorso(idD);
			return inCorso;
		}catch(SQLException e10){
			throw new RuntimeException(e10);
		}
	}

    /**
     * Verifica se il tirocinio esiste.
     *
     * @param nome il nome del tirocinio
     * @return infroma se la verifica e' avvenuta con successo
     */
    public boolean verificaNomeTirocinio(String nome,int idS){
		try{ArrayList<Integer> info=tirocinioDAO.verificaNomeTirocinio(nome);
			if(info!=null){
			richiestaDAO.creaRichiesta(info.get(1),idS,info.get(0));
			richiesta= new Richiesta(null, tirocinio, studente, docente);
			return true;
		}
		return false;
		}catch(SQLException e11){
		throw new RuntimeException(e11);
		}
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
     * @return gli studenti iscritti
     */
    public ArrayList<String> getStudenteETirocinio(int idD) {
		try{ArrayList<String> info=richiestaDAO.getStudenteETirocinio(idD);
			return info;
		}catch(SQLException e12){
			throw new RuntimeException(e12);
		}
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
										String nomeTirocinio, boolean stato){
		try{
		if(richiestaDAO.verificaRichiesta(nomeStudente,cognomeStudente,nomeTirocinio,stato)){
			return true;
		}
		return false;
		}catch(SQLException e12){
			throw new RuntimeException(e12);
		}
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

