package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
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
@Table(name = "condidat")
public class Condidat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Condidat_id")
    Long id;
	
    @Column(name = "Condidat_numero")
	Long numero;
    
    @Column(name = "Condidat_cv")
    String cv;
    
    @Column(name = "Condidat_mLettre")
    String mlettre;
    String email;
	@Enumerated(EnumType.STRING)
	 Avancement avancement;
	@JsonIgnore 	
	 @ManyToOne
	 Offre offre;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "condidat")
	private Set<Reclamation> reclamations;
    
    
	
	
	
}
