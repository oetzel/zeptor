package de.cyber_simon.zeptor.service;

import de.cyber_simon.zeptor.entity.IngredientNameEntity;

public interface IngredientNameService extends BaseService<IngredientNameEntity> {

	IngredientNameEntity findOrCreateByName(String name);

}
