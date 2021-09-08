package model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.entity.Ingredient;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class IngredientDTO {
	private int ingredientId;	
	private String ingredient1;
	private String ingredient2;
	private String ingredient3;
	private String ingredient4;
	private String ingredient5;
	
	// 새로운 레시피재료 등록할때 필요한 생성자
	public IngredientDTO(String ingredient1, String ingredient2, String ingredient3, String ingredient4,
			String ingredient5) {
		super();
		this.ingredient1 = ingredient1;
		this.ingredient2 = ingredient2;
		this.ingredient3 = ingredient3;
		this.ingredient4 = ingredient4;
		this.ingredient5 = ingredient5;
	}
	
	public Ingredient toEntity() {
		return Ingredient.builder().ingredient1(ingredient1).ingredient2(ingredient2).ingredient3(ingredient3).ingredient4(ingredient4).ingredient5(ingredient5).build();
	}
	
	@Override
	public String toString() {
		return "IngredientDTO [ingredientId=" + ingredientId + ", ingredient1=" + ingredient1 + ", ingredient2="
				+ ingredient2 + ", ingredient3=" + ingredient3 + ", ingredient4=" + ingredient4 + ", ingredient5="
				+ ingredient5 + "]";
	}
	
}