# **Documentazione** 



La classe Utente rappresenta un utente che utilizza al sistema, con i suoi attributi: nome, cognome, email, login, password.



La classe Studente rappresenta uno studente che utilizza il sistema, questa classe è una sottoclasse della classe Utente, avente come attributo matricola. Lo studente può visualizzare tutti i tirocini disponibili e i vari docenti.



La classe Docente rappresenta un docente relatore che utilizza il sistema, questa classe è una sottoclasse della classe Utente, avente come attributo elencoArgomentiTirocinio. IL docente può visualizzare i tirocini in corso e gli studenti che lo frequentano, inoltre il docente può approvare o rifiutare le richieste e le tesi fatte dagli studenti.



La classe Coordinatore rappresenta un coordinatore che utilizza il sistema, questa classe è una sottoclasse della classe Docente.



La classe Tirocinio rappresenta un tirocinio frequentabile dagli studenti, con i suoi attributi: nomeTirocinio, spazioTirocinio, disponibile.



La classe Azienda rappresenta un'azienda esterna che può collaborare con l'università per offrire tirocini, avente come attributo referenteAziendale.



La classe Richiesta rappresenta una richiesta fatta dagli studenti per frequentare un determinato tirocinio, questa è una classe associativa tra Studente e Tirocinio, avente come attributi: stato, dataRichiesta.



La classe Tesi rappresenta una tesi scritta da uno studente, con i suoi attributi: stato, caricata.



La classe SedutaLairea rappresenta una seduta di laurea dove possono prenotarsi i vari studenti, con i suoi attributi: dataSeduta, luogoSeduta.

