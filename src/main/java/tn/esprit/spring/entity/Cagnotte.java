package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("ALL")

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "cagnottes")
public class Cagnotte implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*-----------------------****Bean_Attributes****-------------------------------------*/

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cagnotte_id")
     Long id;
    @NotNull
    @Column(name = "Cagnotte_description")
     String description;
    
    @JsonIgnore 
    @ManyToMany(mappedBy="cagnotte")
     List<User> id_Part;
    @JsonIgnore 
    @OneToOne(mappedBy="cagnotte")
     Event id_Event;
    @Column(name = "Cagnotte_amount")
     float amount;


}
