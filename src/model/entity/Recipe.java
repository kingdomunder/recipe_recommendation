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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@SequenceGenerator(name="recipe_id_seq", sequenceName="recipe_seq", initialValue=1, allocationSize=1)
@NamedQuery(query = "select r from Recipe r where r.recipeId=:recipeId", name = "Recipe.findByRecipeId")
public class Recipe {
	@Id
	@Column(name="recipe_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_id_seq")
	private int recipeId;
	
	@JoinColumn(name="ingredient_id")
	@OneToOne
	private Ingredient ingredientId;
	
	@Column(name="food_name")
	private String foodName;
	
	private String direction;
	
	@JoinColumn(name="recipe_owner")
	@OneToOne
	private Chef recipeOwner;
	
	@Column(name="recipe_like")
	private int like;

	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", ingredientId=" + ingredientId + ", foodName=" + foodName
				+ ", direction=" + direction + ", recipeOwner=" + recipeOwner + ", like=" + like + "]";
	}
	
	
}
