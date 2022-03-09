package tn.esprit.spring.entity;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(	name = "user",uniqueConstraints = { @UniqueConstraint(columnNames = "username") })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) private Long iduser;
	private String username;
	private boolean status;
	@JsonIgnore private int identifiant ;
	private String firstname;
    private String lastname;
    @Temporal(TemporalType.DATE)    private Date dateNaissance;
    private String email;
    private String password;
    @JsonIgnore private double solde;
    @Enumerated(EnumType.STRING)  private ERole role;
    @OneToOne(cascade = CascadeType.ALL)  private Subscription Subscription; 
    @JsonIgnore 	@OneToMany(mappedBy="user")  private Set<Appointement> appointements;
	@JsonIgnore 	@OneToMany(mappedBy="user")  private Set<Complaint> complaints;
	@JsonIgnore 	@OneToMany(mappedBy="userr") private Set<FeedBackUser> FeedbacksUser;
    


	
	
	
	
	
	
	
	
	
	
	
	
	

	
}



