package de.cyber_simon.zeptor.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import de.cyber_simon.zeptor.entity.RecipeEntity;
import de.cyber_simon.zeptor.service.RecipeService;

@Named("listRecipeBean")
@Scope("request")
public class ListRecipeBean {

	private List<RecipeEntity> list;
    
    @Inject
    private RecipeService service;

    @PostConstruct
    public void init() {
		list = service.findAll();
	}
	
    public List<RecipeEntity> getEntityList() {
   		return list;
    }

}
