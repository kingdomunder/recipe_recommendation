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
@SequenceGenerator(name="chef_seq", sequenceName="chef_id_seq", initialValue=1, allocationSize=1)
public class Chef {
	@Id
	@Column(name="chef_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chef_seq")
	private int chefId;
	
	@Column(name="chef_name")
	private String chefName;
	
	private String password;
	
}
