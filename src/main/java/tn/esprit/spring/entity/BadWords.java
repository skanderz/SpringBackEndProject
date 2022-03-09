package tn.esprit.spring.entity;

	import java.io.Serializable;

import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

	import lombok.AllArgsConstructor;
	import lombok.Getter;
	import lombok.NoArgsConstructor;
	import lombok.Setter;


	@Entity
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public class BadWords implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Long IdWord;
		
		String word;

	}