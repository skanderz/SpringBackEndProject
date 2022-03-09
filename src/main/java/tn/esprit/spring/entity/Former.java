package tn.esprit.spring.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
public class Former {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id ;
	private String NameF;
	private String LastF;
	private String Icon;
	private String Specialty;
	private String Email;
	private Integer nbrCourse;

	
	@ManyToMany(cascade = CascadeType.ALL) 
	private Set<Course> courses;
	
	@ManyToMany(cascade = CascadeType.ALL) 
	private Set<ListQcm> listQcms;

	
	

	

	

}
