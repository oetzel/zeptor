package de.cyber_simon.zeptor.service;

import java.util.List;

import de.cyber_simon.zeptor.entity.BaseEntity;

public interface BaseService<T extends BaseEntity> {

    T createNew();

    void save(T entity);

    void delete(T entity);

    List<T> findAll();

    T findById(Long id);

}