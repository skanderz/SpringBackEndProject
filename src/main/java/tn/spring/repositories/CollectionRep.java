package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Collection;

@Repository
public interface CollectionRep extends CrudRepository<Collection, Integer>{

}
