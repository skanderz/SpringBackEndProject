package tn.spring.entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.spring.entities.User;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdApp;
	private Date DateApp;
	private Date Hour;
	@ManyToOne
	User user;

}
