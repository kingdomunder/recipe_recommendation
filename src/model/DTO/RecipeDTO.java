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
	private int ingredientId;
	private String foodName;
	private String direction;
	private int recipeOwner;
	private int like;
	
	
	@Override
	public String toString() {
		return "RecipeDTO [recipeId=" + recipeId + ", ingredientId=" + ingredientId + ", foodName=" + foodName
				+ ", direction=" + direction + ", recipeOwner=" + recipeOwner + ", like=" + like + "]";
	}
	
	
}
