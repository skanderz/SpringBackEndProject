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
@AllArgsConstructor
@NoArgsConstructor
public class Candidat {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer CandidId;
	private Integer Num;
	private String Cv;
	private String MLetter;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="candidat")
	private Set<Offre> offres;
	

	

}

