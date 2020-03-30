package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.*;

public class StudenteDAO {
	/*
	 * utile per il completamento automatico punto 2
	 */	
public List<Studente> getTuttiStudenti() {
		
		final String sql = "SELECT *" + 
				" FROM studente AS s  " ;
			

		List<Studente> studenti = new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Integer matricola = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String cds = rs.getString("cds");
				Studente s = new Studente(matricola,cognome,nome,cds);
				studenti.add(s);

				
			}

			conn.close();
			
			return studenti;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}

/*
 * per vedere se uno studente e gia iscritto ad un corso parto da qui.
 */
public List<Corso> getTuttiICorsiByStudente(Studente studente) {
		String sql = "SELECT c.codins,c.crediti,c.nome,c.pd" + 
				"FROM corso AS c , iscrizione AS i" + 
				"WHERE c.codins = i.codins AND matricola = ?" ;
				
		final String s = "SELECT c.codins, c.nome,c.crediti,c.pd" + 
				"FROM corso AS c, iscrizione AS i" + 
				"WHERE c.codins = i.codins AND matricola = ? "+
				"GROUP BY c.codins";
			// String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, studente.getMatricola());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				String nome = rs.getString("nome");
				int numeroCrediti = rs.getInt("crediti");	
				int periodoDidattico = rs.getInt("pd");

			//	System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);
				Corso c = new Corso(codins,numeroCrediti,nome,periodoDidattico);
				corsi.add(c);

			}

			conn.close();
			
			return corsi;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}

}
