package yg.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import yg.model.Article;
import yg.model.Auteur;

public class DAOauteurImpl implements DAOAuteur {
	private Connection connection;
	
	public DAOauteurImpl(Connection connection) {
		this.connection = connection;
	}


	public List<Auteur> getAllAuteur() {
		List<Auteur> auteur = new ArrayList<Auteur>();
	
	try {
		String query = "SELECT * FROM auteur ;";
		PreparedStatement pr = connection.prepareStatement(query);

		ResultSet resultat = pr.executeQuery();

		while (resultat.next()) {
			Auteur a = new Auteur();
			
		
			a.setId_auteur(resultat.getInt("id_auteur"));
			a.setPseudo(resultat.getString("pseudo"));
			a.setPassword(resultat.getString("password_a"));
			
			
			
			auteur.add(a);
			
			
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return auteur;
}
	

	public void addAuteur(Auteur auteur) {
		 try {  
	            PreparedStatement p = connection.prepareStatement(
	            		"INSERT INTO auteur (pseudo, password_a) VALUES (?,?);");
	            p.setString(1, auteur.getPseudo());
	            p.setString(2, auteur.getPassword());
	         
				int statut = p.executeUpdate();
	        }catch (Exception e) {
	            e.printStackTrace();
	        }


	}
	

}
