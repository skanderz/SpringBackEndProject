package tn.spring.entities;

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
public class Donation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdDonation;
	
	@ManyToOne
	 DonationPub donationPubs;
}
