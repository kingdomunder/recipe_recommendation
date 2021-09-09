package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
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
@NamedQuery(query = "select c from Chef c where c.chefName=:chefName", name = "Chef.findChef")
@NamedQuery(query = "select c.password from Chef c where c.chefName=:chefName", name = "Chef.findByChefName")
@SequenceGenerator(name = "chef_seq", sequenceName = "chef_id_seq", initialValue = 1, allocationSize = 1)
public class Chef {
	@Id
	@Column(name = "chef_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chef_seq")
	private int chefId;

	@Column(name = "chef_name")
	private String chefName;

	private String password;

	private String password2;

	@Override
	public String toString() {
		return "Chef [chefId=" + chefId + ", chefName=" + chefName + ", password=" + password + ", password2=" + password2 + "]";
	}

	public Chef(String chefName, String password, String password2) {
		this.chefName = chefName;
		this.password = password;
		this.password2 = password2;
	}

}
