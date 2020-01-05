package yg.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import yg.model.Article;
import yg.model.Auteur;

public class DAOArticleImpl implements DAOArticle {
	private Connection connection;

	public DAOArticleImpl(Connection connection) {
		this.connection = connection;
	}

	public Article getArticle(int id) {
		Article a = new Article();
		try {
			String query = "Select * FROM articles JOIN auteur On auteur.id_auteur=articles.id_auteur WHERE id=?;";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);

			ResultSet resultat = ps.executeQuery();

			while (resultat.next()) {

				Auteur aut = new Auteur();
				
				a.setTitre(resultat.getString("titre"));
				a.setDescription(resultat.getString("description_a"));
				a.setTexte(resultat.getString("texte"));
				a.setDate(resultat.getDate("date_a"));
				aut.setPseudo(resultat.getString("pseudo"));
				a.setAuteur(aut);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return a;
	}

	public List<Article> getAllArticle() {

		List<Article> article = new ArrayList<Article>();
		try {
			String query = "SELECT * FROM articles JOIN auteur On auteur.id_auteur=articles.id_auteur;";
			PreparedStatement pr = connection.prepareStatement(query);

			ResultSet resultat = pr.executeQuery();

			while (resultat.next()) {
				Article a = new Article();
				Auteur aut = new Auteur();

				a.setId(resultat.getInt("id"));
				a.setTitre(resultat.getString("titre"));
				a.setDescription(resultat.getString("description_a"));
				a.setTexte(resultat.getString("texte"));
				a.setDate(resultat.getDate("date_a"));
				aut.setId_auteur(resultat.getInt("id_auteur"));
				aut.setPseudo(resultat.getString("pseudo"));
				aut.setPassword(resultat.getString("password_a"));
				a.setAuteur(aut);

				article.add(a);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}

	public void addArticle(Article article) {
		try {
			PreparedStatement p = connection.prepareStatement(
					"INSERT INTO articles (id_auteur, titre, description_a, texte, date_a) VALUES (?,?,?,?,?);");
			p.setInt(1, article.getAuteur().getId_auteur());
			p.setString(2, article.getTitre());
			p.setString(3, article.getDescription());
			p.setString(4, article.getTexte());
			p.setDate(5, (Date) article.getDate());

			int statut = p.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateArticle(Article article) {
		try {
			String query = "UPDATE articles SET titre=?, description_a=?, texte=?, date_a=? WHERE id=? ;";
			PreparedStatement p = connection.prepareStatement(query);
			p.setString(1, article.getTitre());
			p.setString(2, article.getDescription());
			p.setString(3, article.getTexte());
			p.setDate(4, (Date) article.getDate());
			p.setInt(5, article.getId());

			int statut = p.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteArticle(Article article) {
		try {
			String query = "DELETE FROM articles WHERE id=? ;";
			PreparedStatement p = connection.prepareStatement(query);
			p.setInt(1, article.getId());
			boolean resultat = p.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Article> getArtdeux() {
		List<Article> article = new ArrayList<Article>();
		try {
			String query = "SELECT * FROM articles ORDER BY date_a desc LIMIT 2;";
			PreparedStatement pr = connection.prepareStatement(query);

			ResultSet resultat = pr.executeQuery();

			while (resultat.next()) {
				Article a = new Article();

				a.setTitre(resultat.getString("titre"));
				a.setDescription(resultat.getString("description_a"));
				a.setTexte(resultat.getString("texte"));
				a.setDate(resultat.getDate("date_a"));
				System.out.println(a.getTitre());
				article.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}

}
