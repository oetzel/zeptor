package de.cyber_simon.zeptor.dao;

import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import de.cyber_simon.zeptor.entity.IngredientNameEntity;

@Named("ingredientNameDao")
@Singleton
public class IngredientNameJpaDao implements IngredientNameDao {

    @PersistenceContext
    private EntityManager em;
	
	@Override
	public IngredientNameEntity createNew() {
		return new IngredientNameEntity();
	}

	@Override
	public void persist(IngredientNameEntity entity) {
		em.persist(entity);
	}

	@Override
    @SuppressWarnings({"unchecked"})
	public List<IngredientNameEntity> findAll() {
		return em.createQuery("select e from IngredientNameEntity e").getResultList();
	}

	@Override
	public IngredientNameEntity findByName(String name) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<IngredientNameEntity> criteria = builder.createQuery(IngredientNameEntity.class);
		Root<IngredientNameEntity> root = criteria.from(IngredientNameEntity.class);
		criteria.where(builder.equal(root.get("name"), name));
		criteria.select(root);

		return em.createQuery(criteria).getSingleResult();
	}

	@Override
	public IngredientNameEntity findById(Long id) {
		return em.find(IngredientNameEntity.class, id);
	}

	@Override
	public void delete(IngredientNameEntity entity) {
		em.remove(entity);
	}
}
