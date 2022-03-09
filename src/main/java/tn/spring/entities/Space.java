package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;


@Entity

@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "spaces")
public class Space implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*-----------------------****Bean_Attributes****-------------------------------------*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Space_id")
	 Long id;
	@Column(name = "Space_local")
	 String local;
	@Column(name = "Space_capacity")
	int capacity;
	@Column(name = "Space_disponibilte")
	boolean disponibilte;
	@JsonIgnore
	@OneToMany(mappedBy = "space")
	 List<Event> events = new ArrayList<Event>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public boolean isDisponibilte() {
		return disponibilte;
	}
	public void setDisponibilte(boolean disponibilte) {
		this.disponibilte = disponibilte;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	public Space(Long id, String local, int capacity, boolean disponibilte, List<Event> events) {
		super();
		this.id = id;
		this.local = local;
		this.capacity = capacity;
		this.disponibilte = disponibilte;
		this.events = events;
	}
	public Space() {
		super();
	}
	
	
	
}
