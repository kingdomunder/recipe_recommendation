package model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.entity.Chef;
import model.entity.Ingredient;
import model.entity.Recipe;

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
	
	// 새로운 레시피 등록할때 필요한 생성자
	public RecipeDTO(int ingredientId, String foodName, String direction, int recipeOwner) {
		super();
		this.ingredientId = ingredientId;
		this.foodName = foodName;
		this.direction = direction;
		this.recipeOwner = recipeOwner;
	}

//	public Recipe toEntity() {
//		return Recipe.builder().ingredientId(ingredientId).foodName(foodName).direction(direction).like(like).build();
//	}
	
	
	@Override
	public String toString() {
		return "RecipeDTO [recipeId=" + recipeId + ", ingredientId=" + ingredientId + ", foodName=" + foodName
				+ ", direction=" + direction + ", recipeOwner=" + recipeOwner + ", like=" + like + "]";
	}
	
	
}
