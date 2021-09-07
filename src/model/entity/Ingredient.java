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
@SequenceGenerator(name="ingredient_id_seq", sequenceName="ingredient_seq", initialValue=1, allocationSize=1)
public class Ingredient {
	@Id
	@Column(name="ingredient_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_id_seq")
	private int ingredientId;
	
	private String ingredient1;
	private String ingredient2;
	private String ingredient3;
	private String ingredient4;
	private String ingredient5;
	
	
	@Override
	public String toString() {
		return "Ingredient [ingredientId=" + ingredientId + ", ingredient1=" + ingredient1 + ", ingredient2="
				+ ingredient2 + ", ingredient3=" + ingredient3 + ", ingredient4=" + ingredient4 + ", ingredient5="
				+ ingredient5 + "]";
	}
	
}
