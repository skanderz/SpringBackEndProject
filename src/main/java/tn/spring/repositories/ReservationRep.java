package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Reservation;

@Repository
public interface ReservationRep extends CrudRepository<Reservation, Integer>{

}
