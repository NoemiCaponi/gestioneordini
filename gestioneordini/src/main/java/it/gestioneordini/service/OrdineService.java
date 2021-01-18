package it.gestioneordini.service;

import java.util.List;

import it.gestioneordini.dao.ordine.OrdineDAO;
import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Ordine;

public interface OrdineService {

	public List<Ordine> listAll() throws Exception;

	public Ordine caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Ordine ordineInstance) throws Exception;

	public void inserisciNuovo(Ordine ordineInstance) throws Exception;

	public void rimuovi(Ordine ordineInstance) throws Exception;

	public void aggiungiArticolo(Ordine ordineInstance, Articolo articoloInstance) throws Exception;

	public void setOrdineDAO(OrdineDAO ordineDAO);
	
	public List<Ordine> caricaSingoloOrdineConArticolo (Articolo articoloInput) throws Exception; 
}
