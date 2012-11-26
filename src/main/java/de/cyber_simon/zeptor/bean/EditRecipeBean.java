package de.cyber_simon.zeptor.bean;

import java.util.List;

import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.orchestra.viewController.annotations.ViewController;
import org.springframework.context.annotation.Scope;

import de.cyber_simon.zeptor.entity.IngredientEntity;
import de.cyber_simon.zeptor.entity.RecipeEntity;
import de.cyber_simon.zeptor.service.IngredientNameService;
import de.cyber_simon.zeptor.service.IngredientService;
import de.cyber_simon.zeptor.service.RecipeService;
import de.cyber_simon.zeptor.service.UnitService;
import de.cyber_simon.zeptor.util.ViewIds;

@Named("editRecipeBean")
@Scope("access")
@ViewController(viewIds = {ViewIds.EDIT_RECIPE})
public class EditRecipeBean {

	@Inject
	private RecipeService service;
	
	@Inject
	private IngredientService ingredientService;
	
	@Inject
	private UnitService unitService;
	
	@Inject
	private IngredientNameService ingredientNameService;
	
	private List<IngredientEntity> ingredientList;
	private RecipeEntity entity;
	
	private Long id;
	private Boolean initialized = false;
	
	private String valueField;
	private String unitField;
	private String ingredientNameField;
	
	public void preRenderView(ComponentSystemEvent ev) {
		if (! initialized) {
			entity = service.findById(id);
			ingredientList = ingredientService.findByRecipe(entity);
			initialized = true;
		}
	}
	
	public void addIngredient() {
		if (ingredientNameField != null) {
			IngredientEntity ingredient = ingredientService.createNew();
			ingredient.setRecipe(entity);
			if (valueField != null)
				ingredient.setValue(new Double(valueField));
			if (unitField != null)
				ingredient.setUnit(unitService.findOrCreateByShortname(unitField));
			ingredient.setIngredientName(ingredientNameService.findOrCreateByName(ingredientNameField));
			ingredientService.save(ingredient);
			
			ingredientList.add(ingredient);
			
			setValueField(null);
			setIngredientNameField(null);
			setUnitField(null);
		}
	}
	
	public void deleteIngredient(IngredientEntity ingredient) {
		ingredientService.delete(ingredient);
		ingredientList.remove(ingredient);
	}
	
	public List<IngredientEntity> getIngredientList() {
		return ingredientList;
	}

	public String save() {
		service.save(entity);
		return ViewIds.SHOW_RECIPE + "?faces-redirect=true&id=" + entity.getId();
	}

	public RecipeEntity getEntity() {
		return entity;
	}

	public void setEntity(RecipeEntity entity) {
		this.entity = entity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValueField() {
		return valueField;
	}

	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	public String getUnitField() {
		return unitField;
	}

	public void setUnitField(String unitField) {
		this.unitField = unitField;
	}

	public String getIngredientNameField() {
		return ingredientNameField;
	}

	public void setIngredientNameField(String ingredientNameField) {
		this.ingredientNameField = ingredientNameField;
	}

	
}
