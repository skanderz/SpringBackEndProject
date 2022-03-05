package tn.spring.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Certificat {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdCertificat;
	private String Title;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="certificats")
	private Set<Learner> learners;


}
