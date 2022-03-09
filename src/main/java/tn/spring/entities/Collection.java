package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

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
@Table(name = "collections")
public class Collection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*-----------------------****Bean_Attributes****-------------------------------------*/

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Collection_id")
     Long id;

    @Column(name = "Collection_charity")
     float charity;
    @JsonIgnore 
    @OneToOne(mappedBy="collection")
     Event id_Event;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getCharity() {
		return charity;
	}
	public void setCharity(float charity) {
		this.charity = charity;
	}
	public Event getId_Event() {
		return id_Event;
	}
	public void setId_Event(Event id_Event) {
		this.id_Event = id_Event;
	}
	public Collection(Long id, float charity, Event id_Event) {
		super();
		this.id = id;
		this.charity = charity;
		this.id_Event = id_Event;
	}
	public Collection() {
		super();
	}
    
}
