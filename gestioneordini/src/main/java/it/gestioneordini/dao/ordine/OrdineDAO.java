package it.gestioneordini.dao.ordine;

import java.util.List;

import it.gestioneordini.dao.IBaseDAO;
import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Ordine;

public interface OrdineDAO extends IBaseDAO<Ordine> {
	
	public List<Ordine> getEagerArticolo (Articolo articoloInput) throws Exception;

}
