package de.cyber_simon.zeptor.dao;

import de.cyber_simon.zeptor.entity.IngredientNameEntity;

public interface IngredientNameDao extends BaseDao<IngredientNameEntity> {

	IngredientNameEntity findByName(String name);
}
