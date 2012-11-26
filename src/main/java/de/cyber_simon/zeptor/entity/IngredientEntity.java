package de.cyber_simon.zeptor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ingredient")
public class IngredientEntity implements BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "value")
	private Double value;

	@ManyToOne
	@NotNull
	private IngredientNameEntity ingredientName;
	
	@ManyToOne
	private UnitEntity unit;
	
	@ManyToOne
	@NotNull
	private RecipeEntity recipe;
	
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public IngredientNameEntity getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(IngredientNameEntity ingredientName) {
		this.ingredientName = ingredientName;
	}

	public UnitEntity getUnit() {
		return unit;
	}

	public void setUnit(UnitEntity unit) {
		this.unit = unit;
	}

	public RecipeEntity getRecipe() {
		return recipe;
	}

	public void setRecipe(RecipeEntity recipe) {
		this.recipe = recipe;
	}

}
