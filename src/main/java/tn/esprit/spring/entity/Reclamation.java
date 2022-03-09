package tn.esprit.spring.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Table(name = "Reclamation")

public class Reclamation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String titre;

	String description;

	boolean traiter;//by default false when it will be treated it will be true

	String etat;

	LocalDateTime dateRec;
    @Enumerated(EnumType.ORDINAL)
    private Priority priority;
	String reponse;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "condidat_id")
	Condidat condidat;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "offre_id")
	Offre offre;

}
