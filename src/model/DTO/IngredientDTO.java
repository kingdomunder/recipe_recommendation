package model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	
	
	@Override
	public String toString() {
		return "IngredientDTO [ingredientId=" + ingredientId + ", ingredient1=" + ingredient1 + ", ingredient2="
				+ ingredient2 + ", ingredient3=" + ingredient3 + ", ingredient4=" + ingredient4 + ", ingredient5="
				+ ingredient5 + "]";
	}
	
	
	
}
