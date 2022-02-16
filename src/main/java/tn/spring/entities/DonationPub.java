package tn.spring.entities;

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
import tn.spring.entities.User;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DonationPub {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdPub;
	private String TypePub;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="donationPubs")
	private Set<Donation> donations;
	@ManyToOne
	User user;

}
