package tn.spring.entities;

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
public class Type {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer Id;
	private String Image;
	private String Video;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="types")
	private Set<Publicity> publicities;

}
