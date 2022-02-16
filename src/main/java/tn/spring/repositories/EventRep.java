package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Event;
@Repository
public interface EventRep extends CrudRepository<Event, Integer> {

}
