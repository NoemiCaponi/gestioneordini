package it.gestioneordini.dao;

import it.gestioneordini.dao.articolo.ArticoloDAO;
import it.gestioneordini.dao.articolo.ArticoloDAOImpl;
import it.gestioneordini.dao.categoria.CategoriaDAO;
import it.gestioneordini.dao.categoria.CategoriaDAOImpl;
import it.gestioneordini.dao.ordine.OrdineDAO;
import it.gestioneordini.dao.ordine.OrdineDAOImpl;

public class MyDaoFactory {
	
	private static CategoriaDAO categoriaDAOInstance=null;
	private static ArticoloDAO articoloDAOInstance=null;
	private static OrdineDAO ordineDAOInstance=null;
	
	public static CategoriaDAO getCategoriaDAOInstance(){
		if(categoriaDAOInstance==null) 
			categoriaDAOInstance=new CategoriaDAOImpl();
		return categoriaDAOInstance;
	}
	
	public static ArticoloDAO getArticoloDAOInstance() {
		if(articoloDAOInstance==null)
			articoloDAOInstance=new ArticoloDAOImpl();
		return articoloDAOInstance;
	}
	
	public static OrdineDAO getOrdineDAOInstance() {
		if(ordineDAOInstance==null)
			ordineDAOInstance=new OrdineDAOImpl();
		return ordineDAOInstance;
	}

}
