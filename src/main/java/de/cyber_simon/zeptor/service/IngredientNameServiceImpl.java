package de.cyber_simon.zeptor.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.NoResultException;

import org.springframework.transaction.annotation.Transactional;

import de.cyber_simon.zeptor.dao.IngredientNameDao;
import de.cyber_simon.zeptor.entity.IngredientNameEntity;

@Named("ingredientNameService")
@Singleton
public class IngredientNameServiceImpl implements IngredientNameService {

	@Inject
	private IngredientNameDao dao;
	
	@Override
	public IngredientNameEntity createNew() {
		return dao.createNew();
	}

	@Override
	@Transactional
	public void save(IngredientNameEntity entity) {
		dao.persist(entity);
	}

	@Override
	@Transactional
	public void delete(IngredientNameEntity entity) {
		dao.delete(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<IngredientNameEntity> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public IngredientNameEntity findById(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public IngredientNameEntity findOrCreateByName(String name) {
		try {
			return dao.findByName(name);
		}
		catch (NoResultException e) {
			IngredientNameEntity entity = dao.createNew();
			entity.setName(name);
			dao.persist(entity);
			return entity;
		}
	}
}