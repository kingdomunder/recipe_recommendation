package model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.entity.Chef;
import model.entity.Ingredient;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RecipeDTO {
	private int recipeId;
	private Ingredient ingredientId;
	private String foodName;
	private String direction;
	private Chef recipeOwner;
	private int like;
	
	
	
	
}
