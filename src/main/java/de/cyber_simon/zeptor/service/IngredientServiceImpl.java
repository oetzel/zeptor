package de.cyber_simon.zeptor.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.transaction.annotation.Transactional;

import de.cyber_simon.zeptor.dao.IngredientDao;
import de.cyber_simon.zeptor.entity.IngredientEntity;
import de.cyber_simon.zeptor.entity.RecipeEntity;

@Named("ingredientService")
@Singleton
public class IngredientServiceImpl implements IngredientService {

	@Inject
	private IngredientDao dao;
	
	@Override
	public IngredientEntity createNew() {
		return dao.createNew();
	}

	@Override
	@Transactional
	public void save(IngredientEntity entity) {
		dao.persist(entity);
	}

	@Override
	@Transactional
	public void delete(IngredientEntity entity) {
		dao.delete(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<IngredientEntity> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<IngredientEntity> findByRecipe(RecipeEntity recipe) {
		return dao.findByRecipe(recipe);
	}

	@Override
	@Transactional(readOnly = true)
	public IngredientEntity findById(Long id) {
		return dao.findById(id);
	}
}