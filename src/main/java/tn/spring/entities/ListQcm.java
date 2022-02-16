package tn.spring.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListQcm {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdList;
	private String TitleQcm;
	@ManyToMany(mappedBy="listQcms", cascade = CascadeType.ALL) 
	private Set<Former> formers;
	@ManyToOne
	Qcm qcms; 
	

}
