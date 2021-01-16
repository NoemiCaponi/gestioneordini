package it.gestioneordini.dao.categoria;

import java.util.List;

import javax.persistence.EntityManager;

import it.gestioneordini.model.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO {
	
	private EntityManager entityManager;

	@Override
	public List<Categoria> list() throws Exception {
		return entityManager.createQuery("from Categoria", Categoria.class).getResultList();
	}

	@Override
	public Categoria get(Long id) throws Exception {
		return entityManager.find(Categoria.class, id);
	}

	@Override
	public void update(Categoria categoriaInstance) throws Exception {
		if (categoriaInstance == null) {
			throw new Exception("Valore di input non ammesso");
		}
		categoriaInstance = entityManager.merge(categoriaInstance);
		
	}

	@Override
	public void insert(Categoria categoriaInstance) throws Exception {
		if (categoriaInstance == null) {
			throw new Exception("Valore di input non ammesso");
		}
		entityManager.persist(categoriaInstance);
		
	}

	@Override
	public void delete(Categoria o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager=entityManager;
		
	}

}