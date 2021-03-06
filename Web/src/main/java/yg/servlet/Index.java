package yg.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yg.dao.DAOArticle;
import yg.dao.DaoFactory;
import yg.model.Article;

public class Index extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
		DaoFactory factory= new DaoFactory();
		DAOArticle daoarticle= factory.getDaoArticle();
		List<Article> article = daoarticle.getArtdeux();
				
		
        req.setAttribute("article",article);
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/Index.jsp").forward(req, resp);
    }
	
}

