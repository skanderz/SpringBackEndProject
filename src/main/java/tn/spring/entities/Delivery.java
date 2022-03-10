package tn.spring.entities;
import java.time.LocalDate;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter

@AllArgsConstructor
public class Delivery {

    /**
     * Default constructor
     */
    public Delivery() {
    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String adresse;
    private boolean state;
    private float frais;
    private LocalDate date;
    private float poids;
    @ManyToOne
    @JsonIgnore
    DeliveryMen deliverMen;
   
    
    @ManyToOne
    @JsonIgnore
    private Course coursess;



}