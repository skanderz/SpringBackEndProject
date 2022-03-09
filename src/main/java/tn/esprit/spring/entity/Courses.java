package tn.esprit.spring.entity;

import java.util.Set; 



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "courses")
public
class Courses {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;


private String titre;
private String description;
@DateTimeFormat(pattern="dd-MM-yyyy")
private Date dateDebut;
@DateTimeFormat(pattern="dd-MM-yyyy")
private Date dateFin;
private Float prix;
private String etat;


  
  @ManyToOne
  @JoinColumn(name="id_former")
  private Formers former;

  @ManyToMany(mappedBy = "courses")
  private Set<Lerner> lerners;


  public Courses() {
  }


public Courses(String titre, String description, String dateDebut, String dateFin, Float prix, String etat) {
	super();
	this.titre = titre;
	this.description = description;
	this.prix = prix;
	this.etat = etat;

}


public long getId() {
	return id;
}


public String getTitre() {
	return titre;
}


public void setTitre(String titre) {
	this.titre = titre;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}




public Date getDateDebut() {
	return dateDebut;
}


public void setDateDebut(Date dateDebut) {
	this.dateDebut = dateDebut;
}


public Date getDateFin() {
	return dateFin;
}


public void setDateFin(Date dateFin) {
	this.dateFin = dateFin;
}


public Float getPrix() {
	return prix;
}


public void setPrix(Float prix) {
	this.prix = prix;
}


public String getEtat() {
	return etat;
}


public void setEtat(String etat) {
	this.etat = etat;
}


public Formers getFormer() {
	return former;
}


public void setFormer(Formers former) {
	this.former = former;
}


public Set<Lerner> getLerners() {
	return lerners;
}


public void setLerners(Set<Lerner> lerners) {
	this.lerners = lerners;
}
  

  

}