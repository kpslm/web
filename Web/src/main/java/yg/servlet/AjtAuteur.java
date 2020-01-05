package yg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yg.dao.DAOArticle;
import yg.dao.DAOAuteur;
import yg.dao.DaoFactory;
import yg.model.Article;
import yg.model.Auteur;

public class AjtAuteur extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/AjtAuteur.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String selectPseudo = req.getParameter("Pseudo");
		String selectPassword = req.getParameter("Password");
		
		

		Auteur aut = new Auteur();
		

		aut.setPseudo(selectPseudo);
		aut.setPassword(selectPassword);
		


		DaoFactory factory = new DaoFactory();
		DAOAuteur daoauteur = factory.getDaoAuteur();
		daoauteur.addAuteur(aut);

		this.getServletContext().getRequestDispatcher("/WEB-INF/AjtAuteur.jsp").forward(req, resp);
	}

}

