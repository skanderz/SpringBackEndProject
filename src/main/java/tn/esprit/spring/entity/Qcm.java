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
public class Qcm {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdQcm;
	private Integer Points;
	private String Title;
	private String Description;
	private Integer NbrQuestion;
	private double mark;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="qcms")
	private Set<ListQcm> listQcms;
	
	@ManyToOne
	Question questions;



	

}
