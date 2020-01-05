package yg.dao;

import java.util.List;

import yg.model.Auteur;

public interface DAOAuteur {
	public List<Auteur> getAllAuteur();
	public void addAuteur(Auteur auteur);
}
