package de.cyber_simon.zeptor.dao;

import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import de.cyber_simon.zeptor.entity.UnitEntity;

@Named("unitDao")
@Singleton
public class UnitJpaDao implements UnitDao {

    @PersistenceContext
    private EntityManager em;
	
	@Override
	public UnitEntity createNew() {
		return new UnitEntity();
	}

	@Override
	public void persist(UnitEntity entity) {
		em.persist(entity);
	}

	@Override
    @SuppressWarnings({"unchecked"})
	public List<UnitEntity> findAll() {
		return em.createQuery("select e from UnitEntity e").getResultList();
	}

	@Override
	public UnitEntity findById(Long id) {
		return em.find(UnitEntity.class, id);
	}

	@Override
	public UnitEntity findByShortName(String shortname) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<UnitEntity> criteria = builder.createQuery(UnitEntity.class);
		Root<UnitEntity> root = criteria.from(UnitEntity.class);
		criteria.where(builder.equal(root.get("shortName"), shortname));
		criteria.select(root);

		return em.createQuery(criteria).getSingleResult();
	}

	@Override
	public void delete(UnitEntity entity) {
		em.remove(entity);
	}
}
