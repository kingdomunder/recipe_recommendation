package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

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

@Entity
@NamedQuery(query="select r from Recipe r where r.foodName=:foodName", name="Recipe.findByFoodName")
@SequenceGenerator(name="recipe_seq", sequenceName="recipe_id_seq", initialValue=1, allocationSize=1)
public class Recipe {
	@Id
	@Column(name="recipe_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_seq")
	private int recipeId;

	@OneToOne
	@JoinColumn(name="ingredient_id")
	private Ingredient ingredientId;
	
	@Column(name="food_name")
	private String foodName;
	
	private String direction;
	
	@JoinColumn(name="recipe_owner")
	@OneToOne
	private Chef recipeOwner;
	
	@Column(name="recipe_like")
	private int like;
	
	// 레시피 등록할때 필요한 생성자
	public Recipe(Ingredient ingredientId, String foodName, String direction, Chef recipeOwner) {
		super();
		this.ingredientId = ingredientId;
		this.foodName = foodName;
		this.direction = direction;
		this.recipeOwner = recipeOwner;
	}
	
	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", ingredientId=" + ingredientId + ", foodName=" + foodName
				+ ", direction=" + direction + ", recipeOwner=" + recipeOwner + ", like=" + like + "]";
	}
	
}
