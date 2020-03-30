	/**
	 * Sample Skeleton for 'Scene.fxml' Controller Class
	 */

	package it.polito.tdp.lab04;

	import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.Button;
	import javafx.scene.control.ChoiceBox;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextArea;
	import javafx.scene.control.TextField;

	public class FXMLController { 
		private Model model;

	    @FXML // ResourceBundle that was given to the FXMLLoader
	    private ResourceBundle resources;

	    @FXML // URL location of the FXML file that was given to the FXMLLoader
	    private URL location;

	    @FXML // fx:id="bntCorso"
	    private Label bntCorso; // Value injected by FXMLLoader

	    @FXML // fx:id="tendinaCorsi"
	    private ChoiceBox<String> tendinaCorsi; // Value injected by FXMLLoader

	    @FXML // fx:id="btnCercaIscrittoCorso"
	    private Button btnCercaIscrittoCorso; // Value injected by FXMLLoader

	    @FXML // fx:id="txtMatricola"
	    private TextField txtMatricola; // Value injected by FXMLLoader

	    @FXML // fx:id="txtNome"
	    private TextField txtNome; // Value injected by FXMLLoader

	    @FXML // fx:id="txtCognome"
	    private TextField txtCognome; // Value injected by FXMLLoader

	    @FXML // fx:id="bntCercaCorsi"
	    private Button bntCercaCorsi; // Value injected by FXMLLoader

	    @FXML // fx:id="txtRisultato"
	    private TextArea txtRisultato; // Value injected by FXMLLoader

	    @FXML // fx:id="bntReset"
	    private Button bntReset; // Value injected by FXMLLoader
	    @FXML
	    private Button btnCompletaNome;

	    
	    @FXML
	    void doCercaCorsi(ActionEvent event) {

	    }

	    @FXML
	    void doCercaIscrittoCorso(ActionEvent event) {

	    }

	    @FXML
	    void doReset(ActionEvent event) {

	    }
	    
	    @FXML
	  
	    void doCompletaNome(ActionEvent event) {
	    	String matricola = txtMatricola.getText();
	    	Studente s = new Studente(Integer.parseInt(matricola),"","","");
	    	Studente completo = this.model.getTuttiStudenti().get(this.model.getTuttiStudenti().indexOf(s));
	    	txtNome.setText(completo.getNome()); 
	    	txtCognome.setText(completo.getCognome());
	    }
	    public void setModel(Model model) {
	    	this.model = model;
	   //   ObservableList<String> elenco = FXCollections.observableArrayList();
	    	// aggiungo tendina bastarda
	    	tendinaCorsi.getItems().add(" ");
	    	for(String s : model.getElencoCorsi()) {
	    		tendinaCorsi.getItems().add(s);
	    	}
	    }

	    @FXML // This method is called by the FXMLLoader when initialization is complete
	    void initialize() {
	    	  txtMatricola.setEditable(true);
	    	assert btnCompletaNome != null : "fx:id=\"btnCompletaNome\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert bntCorso != null : "fx:id=\"bntCorso\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert tendinaCorsi != null : "fx:id=\"tendinaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert btnCercaIscrittoCorso != null : "fx:id=\"btnCercaIscrittoCorso\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert bntCercaCorsi != null : "fx:id=\"bntCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert bntReset != null : "fx:id=\"bntReset\" was not injected: check your FXML file 'Scene.fxml'.";
		   

	    }
	

  
}