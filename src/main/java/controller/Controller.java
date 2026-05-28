package controller;

import model.*;

import java.util.ArrayList;
import java.util.Date;

public class Controller {
	private Studente studente;
	private Docente docente;
	private Tesi tesi;
	private Tirocinio tirocinio;
	private Richiesta richiesta;
	private SedutaLaurea sedutaLaurea;



	public Controller() {
	}

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

	public String getNome(boolean stuDoc) {
		if (stuDoc == true){
			return studente.getNomeUtente();
	}else{
			return docente.getNomeUtente();
	}
	}

	public String getCognome(boolean stuDoc) {
		if (stuDoc == true){
			return studente.getCognomeUtente();
		}
		else{
			return docente.getCognomeUtente();
		}
	}

	public boolean salvaTesi(String titolo, String testo){
		tesi = new Tesi(titolo, testo, false);
		return true;
	}

	public boolean caricaTesi(){
		tesi.caricaTesi();
		return true;
	}

	public boolean notNullTesi(){
		if(tesi==null){
			return false;
		}
		return true;
	}

	public String getTitolo(){
		return tesi.getTitolo();
	}
	public String getTesto(){
		return tesi.getTesto();
	}

	public boolean creaTirocinio(String nome, String ente){
		if("Interno".equals(ente)) {
			tirocinio = new Tirocinio(nome, Ente.Interno, true, false);
			return true;
		}else{
			tirocinio = new Tirocinio(nome, Ente.Esterno, true, false);
			return true;
		}
	}

	public String leggiNomeTirocinio(){
		return tirocinio.getNomeTirocinio();
	}

	public String leggiEnteTirocinio(){
		if(Ente.Interno.equals(tirocinio.getEnteTirocinio()))
		{
			return "Interno";
		}else{
			return "Esterno";
		}
	}

	public boolean leggiDisponibilitaTirocinio(){
		return tirocinio.getDisponibileTirocinio();
	}

	public boolean leggiInCorsoTirocinio(){
		return tirocinio.getInCorsoTirocinio();
	}

	public boolean verificaNomeTirocinio(String nome){
		if(tirocinio.getNomeTirocinio().equals(nome)){
			if(tirocinio.getDisponibileTirocinio()==true){
			richiesta= new Richiesta(null, tirocinio, studente, docente);
			return true;
		}}
		return false;
	}

	public String getTirocinio(){
		return richiesta.getTirocinio().getNomeTirocinio();
	}

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

	public boolean verificaRichiesta(String nomeStudente,String cognomeStudente,
										String nomeTirocinio){
		if(nomeStudente.equals(richiesta.getStudente().getNomeUtente()) &&
				cognomeStudente.equals(richiesta.getStudente().getCognomeUtente()) &&
				nomeTirocinio.equals(richiesta.getTirocinio())){
			return true;
		}
		return false;
	}

	public void cambiaStatoRichiesta(boolean stato){
		if(stato){
			richiesta.approva();
		}else{
			richiesta.rifiuta();
		}
	}

	public String getDataSeduta(){
		if(sedutaLaurea==null){
			return"";
		}
		return String.valueOf(sedutaLaurea.getDataSeduta());
	}

	public String getLuogoSeduta(){
		return sedutaLaurea.getLuogoSeduta();
	}

	public boolean verificaSeduta(String data, String luogo){
		if(data.equals(String.valueOf(sedutaLaurea.getDataSeduta())) && luogo.equals(sedutaLaurea.getLuogoSeduta())){
			studente.prenotaSedutaLaurea(sedutaLaurea);
			return true;
		}
		return false;
	}
}

