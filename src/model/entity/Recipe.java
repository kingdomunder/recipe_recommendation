package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
public class Recipe {
	@Id
	@Column(name="recipe_id")
	private int recipeId;
	
	@JoinColumn(name="ingredient_id")
	@OneToOne
	private Ingredient ingredientId;
	
	@Column(name="food_name")
	private String foodName;
	
	private String direction;
	
	@JoinColumn
	@OneToOne
	private Chef recipeOwner;
	
	@Column(name="recipe_like")
	private int like;
}
