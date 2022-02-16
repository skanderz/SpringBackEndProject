package tn.spring.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String Title;
	private String Description;
	private Date Date_S;
	private Date Date_D;
	private float price;
	@Enumerated(EnumType.STRING)
	private Status status; 
	@OneToMany(cascade = CascadeType.ALL, mappedBy="courses")
	private Set<Participation> participations;
	
	@ManyToMany(mappedBy="courses", cascade = CascadeType.ALL) 
	private Set<Former> formers;
	
	
	
	

	


	

	
	
	
	
	
	
	

}
