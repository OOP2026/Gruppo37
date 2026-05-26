package controller;

import model.*;

public class Controller {
	private Studente studente;
	private Docente docente;



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
			if(studente.login(login,password)){
				return true;
			}
		}
		else{
			if(docente.login(login,password)){
				return true;
			}
		}
		return false;
		}
	}

