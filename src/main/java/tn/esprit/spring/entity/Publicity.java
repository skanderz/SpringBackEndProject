package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.scheduling.annotation.Scheduled;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Publicity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdPub;
	private String Canal; 
	private Date Date_D;
	private Date Date_F;
	private Integer NbrIniVues;
	private Integer NbrFinalVues;
	private float 	cost;
	@Enumerated(EnumType.STRING)
	private Channels channel; 
	@Enumerated(EnumType.STRING)
	private Type type;
	
	
	

	

	
	
	

}
