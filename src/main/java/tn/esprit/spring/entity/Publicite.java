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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
