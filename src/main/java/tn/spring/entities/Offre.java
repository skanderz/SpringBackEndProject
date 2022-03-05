package tn.spring.entities;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Offre {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer NumOffre;
	private String Type;
	@ManyToOne
	Candidat candidat;


	

}
