package it.gestioneordini.service;

import java.util.List;

import it.gestioneordini.dao.categoria.CategoriaDAO;
import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;

public interface CategoriaService {

	public List<Categoria> listAll() throws Exception;

	public Categoria caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Categoria categoriaInstance) throws Exception;

	public void inserisciNuovo(Categoria categoriaInstance) throws Exception;

	public void rimuovi(Categoria categoriaInstance) throws Exception;

	public void aggiungiArticolo(Categoria categoriaInstance, Articolo articoloInstance) throws Exception;
	
	public void setCategoriaDAO(CategoriaDAO categoriaDAO);
	
	public Categoria findAllByDescrizione(String descrizioneInput)throws Exception;
	
	//public List<Articolo> caricaSingoloArticoloConCategoria (Categoria categoriaInput) throws Exception; 
}
