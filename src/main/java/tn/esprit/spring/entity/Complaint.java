package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Complaint {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long IdComp;
	private String Description;
	private Date DateR;
	@Enumerated(EnumType.STRING)
	private Statuss statuss;
	@JsonIgnore @ManyToOne User user;
	@ManyToOne
    Subject subject;
}
