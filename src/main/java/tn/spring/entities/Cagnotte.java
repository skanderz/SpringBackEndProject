package tn.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cagnotte {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdCag;
	private float Amount;  
	
	@OneToOne(mappedBy="cagnottes")
	private Event events;
	
	@ManyToOne
	 Collection collections;
	


}
