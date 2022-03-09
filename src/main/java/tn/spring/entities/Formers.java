package tn.spring.entities;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "formers")

public
class Formers {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	  	private String nomprenom;
	  	private String specialite;
	  	private String email;

	  @JsonIgnore
	  @OneToMany(mappedBy="former")
	    private Set<Courses> courses;
	
	
	  public Formers() {}
	
	  
	
	  public Formers(String nomprenom, String specialite, String email) {
		super();
		this.nomprenom = nomprenom;
		this.specialite = specialite;
		this.email = email;
		
	}



public Long getId() {
    return this.id;
  }






public Set<Courses> getCourses() {
	return courses;
}



public void setCourses(Set<Courses> courses) {
	this.courses = courses;
}



public String getNomprenom() {
	return nomprenom;
}



public void setNomprenom(String nomprenom) {
	this.nomprenom = nomprenom;
}



public String getSpecialite() {
	return specialite;
}



public void setSpecialite(String specialite) {
	this.specialite = specialite;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}


  
  


}