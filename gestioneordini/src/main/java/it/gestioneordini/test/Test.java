package it.gestioneordini.test;

import java.util.List;

import it.gestioneordini.dao.EntityManagerUtil;
import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;
import it.gestioneordini.model.Ordine;
import it.gestioneordini.service.ArticoloService;
import it.gestioneordini.service.CategoriaService;
import it.gestioneordini.service.MyServiceFactory;
import it.gestioneordini.service.OrdineService;


public class Test {

	public static void main(String[] args) {
		OrdineService ordineServiceInstance = MyServiceFactory.getOrdineServiceInstance();
		ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
		CategoriaService categoriaServiceInstance=MyServiceFactory.getCategoriaServiceInstance();

		
		try {
			
			Articolo articoloInstance=new Articolo("computer", 700);
//			articoloServiceInstance.inserisciNuovo(articoloInstance);
//			if(articoloServiceInstance.caricaSingoloElemento(articoloInstance.getId())!=null)
//				System.out.println("inserimento articolo riuscito");
			
			Ordine ordineInstance=new Ordine("pippo","via roma");
//			ordineServiceInstance.inserisciNuovo(ordineInstance);
//			if(ordineServiceInstance.caricaSingoloElemento(ordineInstance.getId())!=null)
//				System.out.println("inserimento ordine riuscito");
			
			Categoria categoriaInstance=new Categoria("Tecnologia");
//			categoriaServiceInstance.inserisciNuovo(categoriaInstance);
//			if(categoriaServiceInstance.caricaSingoloElemento(categoriaInstance.getId())!=null)
//				System.out.println("inserimento categoria riuscito");
			
//			Articolo articoloDaCollegare=articoloServiceInstance.caricaSingoloElemento(1L);
//			Categoria categoriaDaCollegare=categoriaServiceInstance.caricaSingoloElemento(1L);
//			if(articoloDaCollegare!=null) {
//				articoloServiceInstance.aggiungiCategoria(articoloDaCollegare, categoriaDaCollegare);
//			}
//			for(Articolo articoloItem:articoloServiceInstance.listAll())
//				System.out.println(articoloItem);
//			for(Ordine ordineItem:ordineServiceInstance.listAll()) {
//				System.out.println(ordineItem);
//			}
//			for(Categoria categoriaItem: categoriaServiceInstance.listAll()) {
//				System.out.println(categoriaItem);
//			}
			
			Articolo articoloProva= articoloServiceInstance.caricaSingoloElemento(8L);
			//articoloServiceInstance.inserisciNuovo(articoloProva);
//			Ordine ordineInstance2=ordineServiceInstance.caricaSingoloElemento(1L);
//			articoloServiceInstance.collegaArticoloEOrdine(articoloProva, ordineInstance2);
			
			Categoria categoriaProva=categoriaServiceInstance.caricaSingoloElemento(1L);
		/*	articoloServiceInstance.creaECollegaArticoloECategoria(articoloProva, categoriaProva);
			for(Articolo articoloItem:articoloServiceInstance.caricaSingoloArticoloConCategoria(categoriaProva))
				System.out.println(articoloItem);*/
			
//			Articolo articoloDaEliminare=articoloServiceInstance.caricaSingoloElemento(7L);
//			articoloServiceInstance.rimuovi(articoloDaEliminare);
//			for(Articolo articoloItem: articoloServiceInstance.listAll()) {
//				System.out.println(articoloItem);
//			}
//			
//			Categoria categoriaDaEliminare=categoriaServiceInstance.caricaSingoloElemento(2L);
//			categoriaServiceInstance.rimuovi(categoriaDaEliminare);
//			for(Categoria categoriaItem:categoriaServiceInstance.listAll()) {
//				System.out.println(categoriaItem);
//			}
					
//			List<Ordine> listaPerCategoria=ordineServiceInstance.caricaOrdineConCategoria(categoriaProva);
//			for(Ordine ordineItem:listaPerCategoria) {
//				System.out.println(ordineItem);
//			}
//			Ordine ordineDaCercare=ordineServiceInstance.caricaSingoloElemento(2L);
//			List<Categoria> lista2=categoriaServiceInstance.trovaByArticoloEOrdine(ordineDaCercare);
//			for(Categoria categoriaItem:lista2) {
//				System.out.println(categoriaItem);
//			}
			
			Categoria categoriaDaSommare=categoriaServiceInstance.caricaSingoloElemento(3L);
			System.out.println("La somma: "+articoloServiceInstance.calcolaSommaArticoliByCategoria(categoriaDaSommare));
	

//			for(Ordine ordineItem: ordineServiceInstance.caricaSingoloOrdineConArticolo(articoloProva))
//				System.out.println(ordineItem);
			
//			Ordine ordineDaInserire=ordineServiceInstance.caricaSingoloElemento(1L);
//			System.out.println(ordineDaInserire);
//			Articolo articoloDaInserireInOrdine=articoloServiceInstance.caricaSingoloElemento(1L);
//			System.out.println(articoloDaInserireInOrdine);
//			if(ordineDaInserire!=null) {
//				ordineServiceInstance.aggiungiArticolo(ordineDaInserire, articoloDaInserireInOrdine);
//				System.out.println("fatto");
//			}
//			
			

			
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
				// main
				EntityManagerUtil.shutdown();
			}
		}
	
	
}
