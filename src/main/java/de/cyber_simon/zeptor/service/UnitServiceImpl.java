package de.cyber_simon.zeptor.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.NoResultException;

import org.springframework.transaction.annotation.Transactional;

import de.cyber_simon.zeptor.dao.UnitDao;
import de.cyber_simon.zeptor.entity.UnitEntity;

@Named("UnitService")
@Singleton
public class UnitServiceImpl implements UnitService {

	@Inject
	private UnitDao dao;
	
	@Override
	public UnitEntity createNew() {
		return dao.createNew();
	}

	@Override
	@Transactional
	public void save(UnitEntity entity) {
		dao.persist(entity);
	}

	@Override
	@Transactional
	public void delete(UnitEntity entity) {
		dao.delete(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UnitEntity> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public UnitEntity findById(Long id) {
		return dao.findById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public UnitEntity findOrCreateByShortname(String shortname) {
		try {
			return dao.findByShortName(shortname);
		}
		catch (NoResultException e) {
			UnitEntity entity = dao.createNew();
			entity.setShortName(shortname);
			dao.persist(entity);
			return entity;
		}
	}
	
}