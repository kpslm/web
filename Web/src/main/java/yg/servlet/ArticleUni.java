package yg.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yg.dao.DAOArticle;
import yg.dao.DaoFactory;
import yg.model.Article;

public class ArticleUni extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
		DaoFactory factory= new DaoFactory();
		DAOArticle daoarticle= factory.getDaoArticle();
		String selectArticle =req.getParameter("article");
		int i = Integer.parseInt(selectArticle);
		Article article = daoarticle.getArticle(i);
		
				
		
        req.setAttribute("article",article);
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/ArticleUni.jsp").forward(req, resp);
    }
	
}

