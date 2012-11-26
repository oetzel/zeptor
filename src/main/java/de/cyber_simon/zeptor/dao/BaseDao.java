package de.cyber_simon.zeptor.dao;

import java.util.List;

import de.cyber_simon.zeptor.entity.BaseEntity;

public interface BaseDao<T extends BaseEntity> {

    T createNew();
    
    void persist(T entity);

    List<T> findAll();

    T findById(Long id);

    void delete(T entity);

}
