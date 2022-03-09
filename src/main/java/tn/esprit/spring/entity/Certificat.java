package tn.esprit.spring.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	private String comment;
	private String punishment;
	private double mark;
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="certificats")
	private Set<Learner> learners;

@OneToOne
@JsonIgnore 
private Qcm quiz;
@ManyToOne
@JsonIgnore
private Course course;


}
