package it.gestioneordini.dao.ordine;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Ordine;

public class OrdineDAOImpl implements OrdineDAO {

	private EntityManager entityManager;

	@Override
	public List<Ordine> list() throws Exception {
		return entityManager.createQuery("from Ordine", Ordine.class).getResultList();
	}

	@Override
	public Ordine get(Long id) throws Exception {
		return entityManager.find(Ordine.class, id);
	}

	@Override
	public void update(Ordine ordineInstance) throws Exception {
		if (ordineInstance == null) {
			throw new Exception("Valore di input non ammesso");
		}
		ordineInstance = entityManager.merge(ordineInstance);

	}

	@Override
	public void insert(Ordine ordineInstance) throws Exception {
		if (ordineInstance == null) {
			throw new Exception("Valore di input non ammesso");
		}
		entityManager.persist(ordineInstance);
	}

	@Override
	public void delete(Ordine ordineInstance) throws Exception {
		if (ordineInstance== null) {
			throw new Exception("Problema valore in input");
		}
		Query query=entityManager.createQuery("delete from Articolo where ordine_id=?1");
		query.setParameter(1,ordineInstance.getId()).executeUpdate();
		
		entityManager.remove(entityManager.merge(ordineInstance));


	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}
	
	public List<Ordine> getEagerArticolo (Articolo articoloInput) throws Exception{
		TypedQuery<Ordine> query=entityManager.createQuery("select o from Ordine o left join fetch o.articoli a where a.id =?1", Ordine.class);
		query.setParameter(1, articoloInput.getId());
		return query.getResultList();
	}

}
