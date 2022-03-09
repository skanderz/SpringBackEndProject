package tn.spring.entities;

import java.util.Date;
import java.util.Set;

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
@NoArgsConstructor
@AllArgsConstructor
public class FeedBackUser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	private String Name;
	private Integer note;
	@ManyToOne
	User user; 

}
