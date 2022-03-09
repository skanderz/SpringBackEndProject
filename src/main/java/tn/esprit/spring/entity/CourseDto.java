package tn.esprit.spring.entity;


public class CourseDto {
    private long id;

private String titre;
private String description;
private String dateDebut;
private String dateFin;
private Float prix;
private String etat;
private long idFormer;


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
public String getDateDebut() {
	return dateDebut;
}
public void setDateDebut(String dateDebut) {
	this.dateDebut = dateDebut;
}
public String getDateFin() {
	return dateFin;
}
public void setDateFin(String dateFin) {
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
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public long getIdFormer() {
	return idFormer;
}
public void setIdFormer(long idFormer) {
	this.idFormer = idFormer;
}



    
}
