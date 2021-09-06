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
@SequenceGenerator(name="ingredient_seq", sequenceName="ingredient_id_seq", initialValue=1, allocationSize=1)
public class Ingredient {
	@Id
	@Column(name="ingredient_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_seq")
	private int ingredientId;
	
	private String ingredient1;
	private String ingredient2;
	private String ingredient3;
	private String ingredient4;
	private String ingredient5;
	
}
