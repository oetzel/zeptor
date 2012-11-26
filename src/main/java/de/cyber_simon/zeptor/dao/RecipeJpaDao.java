package de.cyber_simon.zeptor.dao;

import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.cyber_simon.zeptor.entity.RecipeEntity;

@Named("recipeDao")
@Singleton
public class RecipeJpaDao implements RecipeDao {

    @PersistenceContext
    private EntityManager em;
	
	@Override
	public RecipeEntity createNew() {
		return new RecipeEntity();
	}

	@Override
	public void persist(RecipeEntity entity) {
		em.persist(entity);
	}

	@Override
    @SuppressWarnings({"unchecked"})
	public List<RecipeEntity> findAll() {
		return em.createQuery("select e from RecipeEntity e").getResultList();
	}

	@Override
	public RecipeEntity findById(Long id) {
		return em.find(RecipeEntity.class, id);
	}

	@Override
	public void delete(RecipeEntity entity) {
		em.remove(entity);
	}
}
