package tn.spring.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class Comments {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdCom;
	private String Topic ;
	private Number Number;
	private Date DateCom; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="comments")
	private Set<Post> posts;
	
	
	
	
	
	
	  
	
	
	

}
