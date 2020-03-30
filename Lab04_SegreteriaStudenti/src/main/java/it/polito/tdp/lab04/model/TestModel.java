package it.polito.tdp.lab04.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		Corso corso = new Corso("02CIXPG",null,null,null);
		Studente studente = new Studente(146101,"","","");
		
	//	System.out.println(model.getStudentiIscrittiAlCorso(corso));
		
	//	System.out.println(model.studenteIscrittoCorso(studente, corso));
	//	System.out.println(model.getTuttiStudenti());
		System.out.println(model.getTuttiICorsiByStudente(studente)) ;
		

	}

}
