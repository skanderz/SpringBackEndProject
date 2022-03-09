package tn.esprit.spring.entity;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(	name = "user",uniqueConstraints = { @UniqueConstraint(columnNames = "username") })
@FieldDefaults(level = AccessLevel.PRIVATE)

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) private Long iduser;
	 String username;
	 boolean status;
	@JsonIgnore private int identifiant ;
	 String firstname;
     String lastname;
    @Temporal(TemporalType.DATE)    
     Date dateNaissance;
     String password;
    @JsonIgnore  float solde;
    @Enumerated(EnumType.STRING)   ERole role;
    @OneToOne(cascade = CascadeType.ALL)   Subscription Subscription; 
    @JsonIgnore @OneToMany(mappedBy="user")   Set<Appointement> appointements;
	// @JsonIgnore @OneToMany(mappedBy="user")  private Set<Complaint> complaints;
	// @JsonIgnore @OneToMany(mappedBy="userr") private Set<FeedBackUser> FeedbacksUser;
    

	@JsonIgnore	@ManyToMany	List<Cagnotte> cagnotte;
	@Column(name = "sexe")	@Enumerated(EnumType.STRING)	Sexe sexe;
	@Column(name = "tel") String tel;
	@Temporal(TemporalType.DATE)	@JsonFormat(pattern = "yyyy-MM-dd")	Date dateN;
	@Column(name = "email") String email;
	@JsonIgnore @ManyToMany(mappedBy = "participant")	Set<Event> events;

	
	
	
	
	
	
	
	
	
	
	
	
	

	
}



