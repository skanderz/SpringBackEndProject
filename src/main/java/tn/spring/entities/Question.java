package tn.spring.entities;

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
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String Title;
	private Integer Mark;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="questions")
	private Set<Qcm> qcms;
	
	@ManyToOne
	Answer responses;
	@ManyToOne
	@JsonIgnore
	private Qcm quiz;
	


}
