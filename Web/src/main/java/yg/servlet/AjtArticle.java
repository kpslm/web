package yg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yg.dao.DAOArticle;
import yg.dao.DaoFactory;
import yg.model.Article;
import yg.model.Auteur;

public class AjtArticle extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/AjtArticle.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String selectTitre = req.getParameter("Titre");
		String selectDescription = req.getParameter("Description");
		String select = req.getParameter("Texte");
		

		Article a = new Article();
		Auteur aut = new Auteur();
		java.util.Date d1 = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(d1.getTime());

		a.setDescription(selectDescription);
		a.setTitre(selectTitre);
		a.setTexte(select);
		aut.setId_auteur(1);
		a.setAuteur(aut);
		a.setDate(sqlDate);

		DaoFactory factory = new DaoFactory();
		DAOArticle daoarticle = factory.getDaoArticle();
		daoarticle.addArticle(a);

		this.getServletContext().getRequestDispatcher("/WEB-INF/AjtArticle.jsp").forward(req, resp);
	}

}
