package it.gestioneordini.service;

import java.util.List;

import it.gestioneordini.dao.categoria.CategoriaDAO;
import it.gestioneordini.model.Categoria;

public interface CategoriaService {

	public List<Categoria> listAll() throws Exception;

	public Categoria caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Categoria categoriaInstance) throws Exception;

	public void inserisciNuovo(Categoria categoriaInstance) throws Exception;

	public void rimuovi(Categoria categoriaInstance) throws Exception;

	//public void aggiungiCategoria(Articolo articoloInstance, Categoria categoriaInstance) throws Exception;
	
	//public void creaECollegaArticoloECategoria(Articolo articoloTransientInstance, Categoria categoriaTransientInstance) throws Exception;

	public void setCategoriaDAO(CategoriaDAO categoriaDAO);
	
	//public List<Articolo> caricaSingoloArticoloConCategoria (Categoria categoriaInput) throws Exception; 
}
