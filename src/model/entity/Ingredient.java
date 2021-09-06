package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@SequenceGenerator(name="recipe_seq", sequenceName="recipe_id_seq", initialValue=1, allocationSize=1)
public class Ingredient {
	@Id
	@Column(name="recipe_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_seq")
	private int recipeId;
	
	private String ingredient1;
	private String ingredient2;
	private String ingredient3;
	private String ingredient4;
	private String ingredient5;
	
}
