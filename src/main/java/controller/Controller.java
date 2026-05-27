package controller;

import model.*;

public class Controller {
	private Studente studente;
	private Docente docente;
	private Tesi tesi;
	private Tirocinio tirocinio;



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
}

