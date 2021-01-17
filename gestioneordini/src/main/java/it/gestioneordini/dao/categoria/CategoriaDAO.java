package it.gestioneordini.dao.categoria;

import it.gestioneordini.dao.IBaseDAO;
import it.gestioneordini.model.Categoria;

public interface CategoriaDAO extends IBaseDAO<Categoria> {
	
	public Categoria findByDescrizione (String descrizioneInput) throws Exception;

}
