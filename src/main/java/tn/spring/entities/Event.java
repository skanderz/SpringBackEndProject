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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isHasFinished() {
		return hasFinished;
	}

	public void setHasFinished(boolean hasFinished) {
		this.hasFinished = hasFinished;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Set<User> getParticipant() {
		return participant;
	}

	public void setParticipant(Set<User> participant) {
		this.participant = participant;
	}

	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}

	public Cagnotte getCagnotte() {
		return cagnotte;
	}

	public void setCagnotte(Cagnotte cagnotte) {
		this.cagnotte = cagnotte;
	}

	public Space getSpace() {
		return space;
	}

	public void setSpace(Space space) {
		this.space = space;
	}

	public Publicite getPublicite() {
		return publicite;
	}

	public void setPublicite(Publicite publicite) {
		this.publicite = publicite;
	}

	public Event(Long id, String name, String description, boolean hasFinished, Date start_date, Date end_date,
			String image, Set<User> participant, Collection collection, Cagnotte cagnotte, Space space,
			Publicite publicite) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.hasFinished = hasFinished;
		this.start_date = start_date;
		this.end_date = end_date;
		this.image = image;
		this.participant = participant;
		this.collection = collection;
		this.cagnotte = cagnotte;
		this.space = space;
		this.publicite = publicite;
	}

	public Event() {
		super();
	}
	
	
	
}
