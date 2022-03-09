package tn.esprit.spring.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="POST")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdPub ;
	private String Topic;
	private String Title;
	private Date DatePub;
	private Integer NbrVues;
	
	
	@JsonIgnore @ManyToOne	 Comments comments;
	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy="posts")
	//private Set<User>  users;
	
	
	@JsonIgnore @ManyToOne	 Likee likes;


	@JsonIgnore @ManyToOne	Dislike dislikes;
	
	
	
	
	

}
