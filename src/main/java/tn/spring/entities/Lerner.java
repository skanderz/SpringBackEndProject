package tn.spring.entities;




import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;




@Entity
@Table(name = "lerners")
public class Lerner {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
		private String nomprenom;
	  	private String email;


  @ManyToMany
  @JoinTable(
    name = "lerners_courses")
  Set<Courses> courses;

  public Lerner() {}

  public Lerner(String nomprenom, String email, Set<Courses> courses) {
	super();
	this.nomprenom = nomprenom;
	this.email = email;
	this.courses = courses;
}

public Long getId() {
    return this.id;
  }

public String getNomprenom() {
	return nomprenom;
}

public void setNomprenom(String nomprenom) {
	this.nomprenom = nomprenom;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Set<Courses> getCourses() {
	return courses;
}

public void setCourses(Set<Courses> courses) {
	this.courses = courses;
}


}