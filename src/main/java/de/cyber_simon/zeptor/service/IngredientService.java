package de.cyber_simon.zeptor.service;

import java.util.List;

import de.cyber_simon.zeptor.entity.IngredientEntity;
import de.cyber_simon.zeptor.entity.RecipeEntity;

public interface IngredientService extends BaseService<IngredientEntity> {

	List<IngredientEntity> findByRecipe(RecipeEntity recipe);

}
