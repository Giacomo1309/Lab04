package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.DAO.*;

public class Model {
	private CorsoDAO daoC;
	private StudenteDAO daoS;
	
	public Model() {
		daoC= new CorsoDAO();
		daoS=new StudenteDAO();
	}
	
	//public Model() {
		// TODO Auto-generated constructor stub
	//}

	public List<Corso> getTuttiICorsi(){
		return daoC.getTuttiICorsi();
	}

	public Corso getCorso(Corso corso) {
		return daoC.getCorso(corso);
	}
	
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		return daoC.getStudentiIscrittiAlCorso(corso);
	}
	
	public List<Studente> getTuttiStudenti() {
		return daoS.getTuttiStudenti();
	}
	
	public List<Corso> getTuttiICorsiByStudente(Studente studente) {
		return daoS.getTuttiICorsiByStudente(studente);
	}

	public boolean studenteIscrittoCorso(Studente studente,Corso corso) {
		return this.getStudentiIscrittiAlCorso(corso).contains(studente);

	}
	public List<String> getElencoCorsi() {
		List<String> elenco = new LinkedList<String> ();
	  for(Corso c : this.getTuttiICorsi()) {
	     	String s = c.getNome();
	    	elenco.add(s);
	     }
		return elenco;
	}
	
	
}
