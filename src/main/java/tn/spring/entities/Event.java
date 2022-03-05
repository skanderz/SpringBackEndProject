package tn.spring.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdEvent ;
	private Date DateEvent;
	private String PlaceEvent;
	
	@OneToOne
	private Cagnotte cagnottes; 
	
	@ManyToOne
	 Space spaces;
	@ManyToMany(mappedBy="event", cascade = CascadeType.ALL)
  private Set<User> users;
}
