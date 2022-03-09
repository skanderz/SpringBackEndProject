package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("ALL")


@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "publicite")
public class Publicite implements Serializable {
	/**
	 * 
	 */
	 static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 Long Id;
	 String nom;
	@Enumerated(EnumType.STRING)
	 GenderCible genderCible;
	@Temporal(TemporalType.DATE)
	 Date dateDebut;
	@Temporal(TemporalType.DATE)
	 Date dateFin;
	 int nbrInitialVueCible;
	 int nbrFinalVue;
	 int debutAgeCible;
	 int finAgeCible;
	 float cout;
	 String video;
	 String image;
	 String emailProprietaire;
	 String numeroProprietaire;
	 boolean status;
	@ManyToOne
	 User IdUser;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "publicite")
	@JsonIgnore
	Event events;
	@Override
	public String toString() {
		return "Publicite [Id=" + Id + ", nom=" + nom + ", genderCible=" + genderCible + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", nbrInitialVueCible=" + nbrInitialVueCible + ", nbrFinalVue=" + nbrFinalVue
				+ ", debutAgeCible=" + debutAgeCible + ", finAgeCible=" + finAgeCible + ", cout=" + cout + ", video="
				+ video + ", image=" + image + ", emailProprietaire=" + emailProprietaire + ", numeroProprietaire="
				+ numeroProprietaire + ", status=" + status + "]";
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public GenderCible getGenderCible() {
		return genderCible;
	}
	public void setGenderCible(GenderCible genderCible) {
		this.genderCible = genderCible;
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
	public int getNbrInitialVueCible() {
		return nbrInitialVueCible;
	}
	public void setNbrInitialVueCible(int nbrInitialVueCible) {
		this.nbrInitialVueCible = nbrInitialVueCible;
	}
	public int getNbrFinalVue() {
		return nbrFinalVue;
	}
	public void setNbrFinalVue(int nbrFinalVue) {
		this.nbrFinalVue = nbrFinalVue;
	}
	public int getDebutAgeCible() {
		return debutAgeCible;
	}
	public void setDebutAgeCible(int debutAgeCible) {
		this.debutAgeCible = debutAgeCible;
	}
	public int getFinAgeCible() {
		return finAgeCible;
	}
	public void setFinAgeCible(int finAgeCible) {
		this.finAgeCible = finAgeCible;
	}
	public float getCout() {
		return cout;
	}
	public void setCout(float cout) {
		this.cout = cout;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getEmailProprietaire() {
		return emailProprietaire;
	}
	public void setEmailProprietaire(String emailProprietaire) {
		this.emailProprietaire = emailProprietaire;
	}
	public String getNumeroProprietaire() {
		return numeroProprietaire;
	}
	public void setNumeroProprietaire(String numeroProprietaire) {
		this.numeroProprietaire = numeroProprietaire;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public User getIdUser() {
		return IdUser;
	}
	public void setIdUser(User idUser) {
		IdUser = idUser;
	}
	public Event getEvents() {
		return events;
	}
	public void setEvents(Event events) {
		this.events = events;
	}
	public Publicite(Long id, String nom, GenderCible genderCible, Date dateDebut, Date dateFin, int nbrInitialVueCible,
			int nbrFinalVue, int debutAgeCible, int finAgeCible, float cout, String video, String image,
			String emailProprietaire, String numeroProprietaire, boolean status, User idUser, Event events) {
		super();
		Id = id;
		this.nom = nom;
		this.genderCible = genderCible;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nbrInitialVueCible = nbrInitialVueCible;
		this.nbrFinalVue = nbrFinalVue;
		this.debutAgeCible = debutAgeCible;
		this.finAgeCible = finAgeCible;
		this.cout = cout;
		this.video = video;
		this.image = image;
		this.emailProprietaire = emailProprietaire;
		this.numeroProprietaire = numeroProprietaire;
		this.status = status;
		IdUser = idUser;
		this.events = events;
	}
	public Publicite() {
		super();
	}
	
	
	
	
	
	
	

}
