package de.cyber_simon.zeptor.dao;

import java.util.List;

import de.cyber_simon.zeptor.entity.IngredientEntity;
import de.cyber_simon.zeptor.entity.RecipeEntity;

public interface IngredientDao extends BaseDao<IngredientEntity> {

	List<IngredientEntity> findByRecipe(RecipeEntity recipe);
}
