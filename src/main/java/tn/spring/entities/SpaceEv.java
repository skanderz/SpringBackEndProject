package tn.spring.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpaceEv {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   private Integer Id;
   private String Availability;
   
   @OneToMany(cascade = CascadeType.ALL, mappedBy="spaces")
	private Set<Event> events;

   
}
