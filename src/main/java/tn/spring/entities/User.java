package tn.spring.entities;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public  class User  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdUser;
	private Integer IdSubscription;
	private String Fname;
	private String Lname;
	private String Photo;
	private String Email;
	private String Password;
	private Boolean Status;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Appointement> appointements;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Complaint> complaints;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Event> event;
	@OneToOne
   private Subscription subscription;
	@OneToOne
   private Candidat candidat ;
	@ManyToOne
	 Post posts;

}
