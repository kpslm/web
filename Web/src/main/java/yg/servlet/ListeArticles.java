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

public class ListeArticles extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DaoFactory factory = new DaoFactory();
		DAOArticle daoarticle = factory.getDaoArticle();
		List<Article> article = daoarticle.getAllArticle();
		
		
		req.setAttribute("article", article);

		this.getServletContext().getRequestDispatcher("/WEB-INF/ListeArticles.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DaoFactory factory = new DaoFactory();
		DAOArticle daoarticle = factory.getDaoArticle();
		
		String selectid = req.getParameter("id");
		System.out.println(selectid);
		int id = Integer.parseInt(selectid);
		
		Article a = new Article();
		a.setId(id);
		daoarticle.deleteArticle(a);
		
		

		

		this.getServletContext().getRequestDispatcher("/WEB-INF/ListeArticles.jsp").forward(req, resp);
	}


}
