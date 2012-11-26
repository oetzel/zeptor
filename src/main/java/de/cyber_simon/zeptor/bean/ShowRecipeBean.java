package de.cyber_simon.zeptor.bean;

import java.util.List;

import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import ch.lambdaj.Lambda;

import de.cyber_simon.zeptor.entity.IngredientEntity;
import de.cyber_simon.zeptor.entity.RecipeEntity;
import de.cyber_simon.zeptor.service.IngredientService;
import de.cyber_simon.zeptor.service.RecipeService;
import de.cyber_simon.zeptor.util.BBCodeConverter;

@Named("showRecipeBean")
@Scope("request")
public class ShowRecipeBean {

	@Inject
	private RecipeService service;

	@Inject
	private IngredientService ingredientService;
	
	@Inject
	private BBCodeConverter bbCodeConverter;
	
	private RecipeEntity entity;
	private List<IngredientEntity> ingredientList;
	private String instruction;
	private Long id;

	public void preRenderView(ComponentSystemEvent ev) {
		entity = service.findById(id);
		ingredientList = Lambda.sort(ingredientService.findByRecipe(entity), 
				Lambda.on(IngredientEntity.class).getId());
		instruction = bbCodeConverter.convert(entity.getInstruction());
	}
	
	public List<IngredientEntity> getIngredientList() {
		return ingredientList;
	}

	public RecipeEntity getEntity() {
		return entity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInstruction() {
		return instruction;
	}
}
