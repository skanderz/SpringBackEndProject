package tn.spring.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Collection {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdCollection;
	private Integer Charity;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="collections")
	private Set<Cagnotte> cagnottes;

}
