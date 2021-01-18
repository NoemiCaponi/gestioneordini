package it.gestioneordini.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.gestioneordini.dao.EntityManagerUtil;
import it.gestioneordini.dao.MyDaoFactory;
import it.gestioneordini.dao.articolo.ArticoloDAO;
import it.gestioneordini.dao.categoria.CategoriaDAO;
import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;

public class CategoriaServiceImpl implements CategoriaService {
	
	private CategoriaDAO categoriaDAO;
	private ArticoloDAO articoloDAO;

	@Override
	public List<Categoria> listAll() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			categoriaDAO.setEntityManager(entityManager);

			return categoriaDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Categoria caricaSingoloElemento(Long id) throws Exception {
		EntityManager entityManager= EntityManagerUtil.getEntityManager();
		try {
			categoriaDAO.setEntityManager(entityManager);
			return categoriaDAO.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Categoria categoriaInstance) throws Exception {
		EntityManager entityManager=EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			categoriaDAO.setEntityManager(entityManager);
			categoriaDAO.update(categoriaInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void inserisciNuovo(Categoria categoriaInstance) throws Exception {
		EntityManager entityManager=EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			categoriaDAO.setEntityManager(entityManager);
			categoriaDAO.insert(categoriaInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
		
	}

	@Override
	public void rimuovi(Categoria categoriaInstance) throws Exception {
		EntityManager entityManager=EntityManagerUtil.getEntityManager();
		try {
				
			articoloDAO=MyDaoFactory.getArticoloDAOInstance();
			entityManager.getTransaction().begin();
			
			articoloDAO.setEntityManager(entityManager);
			List<Articolo> lista=articoloDAO.findAllByCategoria(categoriaInstance);
			for(Articolo articoloItem: lista) {
				articoloItem.getCategorie().remove(categoriaInstance);
				articoloDAO.update(articoloItem);
			}
			
			categoriaDAO.setEntityManager(entityManager);	
			categoriaDAO.delete(categoriaInstance);
			
			entityManager.getTransaction().commit();
		
	
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
		
	}

	@Override
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO=categoriaDAO;
		
	}

	@Override
	public void aggiungiArticolo(Categoria categoriaInstance, Articolo articoloInstance) throws Exception {
		EntityManager entityManager=EntityManagerUtil.getEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			
			categoriaDAO.setEntityManager(entityManager);
			categoriaInstance=entityManager.merge(categoriaInstance);
			articoloInstance=entityManager.merge(articoloInstance);
			
			categoriaInstance.getArticoliCategoria().add(articoloInstance);
			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

		
	}

	@Override
	public Categoria findAllByDescrizione(String descrizioneInput) throws Exception {
		
		EntityManager entityManager=EntityManagerUtil.getEntityManager();
		
		try {
			categoriaDAO.setEntityManager(entityManager);
			return categoriaDAO.findByDescrizione(descrizioneInput);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
