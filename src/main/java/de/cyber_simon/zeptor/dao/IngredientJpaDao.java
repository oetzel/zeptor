package de.cyber_simon.zeptor.dao;

import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import de.cyber_simon.zeptor.entity.IngredientEntity;
import de.cyber_simon.zeptor.entity.RecipeEntity;

@Named("ingredientDao")
@Singleton
public class IngredientJpaDao implements IngredientDao {

    @PersistenceContext
    private EntityManager em;
	
	@Override
	public IngredientEntity createNew() {
		return new IngredientEntity();
	}

	@Override
	public void persist(IngredientEntity entity) {
		em.persist(entity);
	}

	@Override
    @SuppressWarnings({"unchecked"})
	public List<IngredientEntity> findAll() {
		return em.createQuery("select e from IngredientEntity e").getResultList();
	}

	@Override
	public List<IngredientEntity> findByRecipe(RecipeEntity recipe) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<IngredientEntity> criteria = builder.createQuery(IngredientEntity.class);
		Root<IngredientEntity> root = criteria.from(IngredientEntity.class);
		criteria.where(builder.equal(root.get("recipe"), recipe));
		criteria.select(root);
		root.fetch("ingredientName", JoinType.LEFT);
		root.fetch("unit", JoinType.LEFT);

		return em.createQuery(criteria).getResultList();
	}	

	@Override
	public IngredientEntity findById(Long id) {
		return em.find(IngredientEntity.class, id);
	}

	@Override
	public void delete(IngredientEntity entity) {
		em.remove(entity);
	}
}
