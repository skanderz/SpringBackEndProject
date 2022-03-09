package tn.spring.Entities;


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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long IdApp;
	private Date DateApp;
	private Date Hour;
	private String Local;
	@ManyToOne
	User user;

}
