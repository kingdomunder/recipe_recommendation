package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@SequenceGenerator(name="recipe_seq", sequenceName="recipe_id", initialValue=1, allocationSize=1)
public class Recipe {
	@Id
	@JoinColumn(name="recipe_id")
	@OneToOne
	private Ingredient recipeId;
	
	@Column(name="food_name")
	private String foodName;
	
	private String direction;
	
	@JoinColumn
	@OneToOne
	private Chef recipeOwner;
	
	@Column(name="recipe_like")
	private int like;
	
}
