package it.gestioneordini.service;

import java.util.List;

import it.gestioneordini.dao.articolo.ArticoloDAO;
import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;



public interface ArticoloService {

	public List<Articolo> listAll() throws Exception;

	public Articolo caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Articolo articoloInstance) throws Exception;

	public void inserisciNuovo(Articolo articoloInstance) throws Exception;

	public void rimuovi(Articolo articoloInstance) throws Exception;

	public void aggiungiCategoria(Articolo articoloInstance, Categoria categoriaInstance) throws Exception;
	
	public void creaECollegaArticoloECategoria(Articolo articoloTransientInstance, Categoria categoriaTransientInstance) throws Exception;

	public void setArticoloDAO(ArticoloDAO articoloDAO);
	
	public List<Articolo> caricaSingoloArticoloConCategoria (Categoria categoriaInput) throws Exception; 

}
