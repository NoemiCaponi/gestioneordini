package it.gestioneordini.dao.articolo;

import java.util.List;

import it.gestioneordini.dao.IBaseDAO;
import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;

public interface ArticoloDAO extends IBaseDAO<Articolo> {
	
	public List<Articolo> getEagerCategoria (Categoria categoriaInput) throws Exception;
	
	public List<Articolo> findAllByCategoria(Categoria categoriaInput);

}
