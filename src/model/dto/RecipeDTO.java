package model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	private String imgPath;

	// 새로운 레시피 등록할때 필요한 생성자
	public RecipeDTO(int ingredientId, String foodName, String direction) {
		super();
		this.ingredientId = ingredientId;
		this.foodName = foodName;
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "RecipeDTO [recipeId=" + recipeId + ", ingredientId=" + ingredientId + ", foodName=" + foodName
				+ ", direction=" + direction + ", recipeOwner=" + recipeOwner + ", like=" + like + ", imgPath="+ imgPath + "]";
	}

}
