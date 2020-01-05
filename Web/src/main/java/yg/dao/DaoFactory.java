package yg.dao;

import yg.dao.DAOArticle;
import yg.dao.DAOArticleImpl;
import yg.dao.MySQLManager;

public class DaoFactory {
	private MySQLManager manager;
	private DAOArticle daoArticle;
	private DAOAuteur daoAuteur;
	
	public DaoFactory() {
		manager = MySQLManager.getInstance();
		daoArticle = new DAOArticleImpl(manager.getConnection());
		daoAuteur = new DAOauteurImpl(manager.getConnection());
	}
	
	public DAOArticle getDaoArticle() {
		return daoArticle;
	}
	public DAOAuteur getDaoAuteur() {
		return daoAuteur;
	}
	

}
