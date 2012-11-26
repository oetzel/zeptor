package de.cyber_simon.zeptor.bean;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import de.cyber_simon.zeptor.entity.RecipeEntity;
import de.cyber_simon.zeptor.service.RecipeService;
import de.cyber_simon.zeptor.util.ViewIds;

@Named("addRecipeBean")
@Scope("access")
public class AddRecipeBean {

	@Inject
	private RecipeService service;
	
	private RecipeEntity entity;
	
	@PostConstruct
	public void init() {
		entity = service.createNew();
	}

	public String save() {
		service.save(entity);
		return ViewIds.EDIT_RECIPE + "?id=" + entity.getId() + "&faces-redirect=true";
	}
	
	public RecipeEntity getEntity() {
		return entity;
	}

	public void setEntity(RecipeEntity entity) {
		this.entity = entity;
	}
	
	
}
