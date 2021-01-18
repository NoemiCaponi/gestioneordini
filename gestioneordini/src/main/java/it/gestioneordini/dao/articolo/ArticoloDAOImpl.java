package it.gestioneordini.dao.articolo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;

public class ArticoloDAOImpl implements ArticoloDAO {

	private EntityManager entityManager;

	@Override
	public List<Articolo> list() throws Exception {
		return entityManager.createQuery("from Articolo", Articolo.class).getResultList();
	}

	@Override
	public Articolo get(Long id) throws Exception {
		return entityManager.find(Articolo.class, id);
	}

	@Override
	public void update(Articolo articoloInstance) throws Exception {
		if (articoloInstance == null) {
			throw new Exception("Valore di input non ammesso");
		}
		articoloInstance = entityManager.merge(articoloInstance);

	}

	@Override
	public void insert(Articolo articoloInstance) throws Exception {
		if (articoloInstance == null) {
			throw new Exception("Valore di input non ammesso");
		}
		entityManager.persist(articoloInstance);
	}

	@Override
	public void delete(Articolo articoloInstance) throws Exception {
		if (articoloInstance == null) {
		throw new Exception("Problema valore in input");
	}
	entityManager.remove(entityManager.merge(articoloInstance));

	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}
	
	public List<Articolo> findAllByCategoria(Categoria categoriaInput) {
		TypedQuery<Articolo> query = entityManager.createQuery("select a FROM Articolo a left join a.categorie c where c = :categoria", Articolo.class);
		query.setParameter("categoria", categoriaInput);
		return query.getResultList();
	}
	
	public List<Articolo> getEagerCategoria (Categoria categoriaInput) throws Exception{
		TypedQuery<Articolo> query = entityManager
				.createQuery("select a from Articolo a left join fetch a.categorie c where c.id =?1", Articolo.class);
		query.setParameter(1, categoriaInput.getId());
		return query.getResultList();
	}


}
