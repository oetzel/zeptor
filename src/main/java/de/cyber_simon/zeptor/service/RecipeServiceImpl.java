package de.cyber_simon.zeptor.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.transaction.annotation.Transactional;

import de.cyber_simon.zeptor.dao.RecipeDao;
import de.cyber_simon.zeptor.entity.RecipeEntity;

@Named("recipeService")
@Singleton
public class RecipeServiceImpl implements RecipeService {

	@Inject
	private RecipeDao dao;
	
	@Override
	public RecipeEntity createNew() {
		return dao.createNew();
	}

	@Override
	@Transactional
	public void save(RecipeEntity entity) {
		dao.persist(entity);
	}

	@Override
	@Transactional
	public void delete(RecipeEntity entity) {
		dao.delete(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RecipeEntity> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public RecipeEntity findById(Long id) {
		return dao.findById(id);
	}
}