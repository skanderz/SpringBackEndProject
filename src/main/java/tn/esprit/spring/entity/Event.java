package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("ALL")

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "evenments")
public class Event implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*-----------------------****Bean_Attributes****-------------------------------------*/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Event_id")
	Long id;
	@Column(name = "Event_name")
	String name;
	@Column(name = "Event_description")
	String description;
	@Column(name = "Event_hasFinished")
	boolean hasFinished;
	@Temporal(TemporalType.DATE)
	@Column(name = "Event_start_date")
	Date start_date;
	@Temporal(TemporalType.DATE)
	@Column(name = "Event_end_date")
	Date end_date;
    String image;
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	Set<User> participant;
	@OneToOne
	@JsonIgnore
	Collection collection;
	@OneToOne
	@JsonIgnore
	Cagnotte cagnotte;
	@ManyToOne
	@JsonIgnore
	Space space;
	@OneToOne
	@JsonIgnore
	private Publicite publicite;

	public int getNumberOFdaybythisEvent() {
		Date start = getStart_date();
		Date end = getEnd_date();

		long diff = end.getTime() - start.getTime();
		long res = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		return Math.round(res);
	}
}
